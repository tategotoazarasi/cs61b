public class Planet {
    private static final double G = 6.67e-11;
    /**
     * Its current x position
     */
    public double xxPos;
    /**
     * Its current y position
     */
    public double yyPos;
    /**
     * Its current velocity in the x direction
     */
    public double xxVel;
    /**
     * Its current velocity in the y direction
     */
    public double yyVel;
    /**
     * Its mass
     */
    public double mass;
    /**
     * The name of the file that corresponds to the image that depicts the planet
     */
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
            double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
     * calculates the distance between two Planets.
     * 
     * @param p a single Planet
     * @return a double equal to the distance between the supplied planet and the
     *         planet that is doing the calculation
     */
    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * @param p a planet
     * @return a double describing the force exerted on this planet by the given
     *         planet.
     */
    public double calcForceExertedBy(Planet p) {
        double r = this.calcDistance(p);
        if (r == 0) {
            return 0;
        }
        return this.mass * p.mass * G / r / r;
    }

    public double calcForceExertedByX(Planet p) {
        double r = this.calcDistance(p);
        if (r == 0) {
            return 0;
        }
        double dx = p.xxPos - this.xxPos;
        double f = calcForceExertedBy(p);
        return f * dx / r;
    }

    public double calcForceExertedByY(Planet p) {
        double r = this.calcDistance(p);
        if (r == 0) {
            return 0;
        }
        double dy = p.yyPos - this.yyPos;
        double f = calcForceExertedBy(p);
        return f * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double ans = 0;
        for (Planet planet : planets) {
            ans += this.calcForceExertedByX(planet);
        }
        return ans;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double ans = 0;
        for (Planet planet : planets) {
            ans += this.calcForceExertedByY(planet);
        }
        return ans;
    }

    /**
     * @param dt
     * @param fx x-force
     * @param fy y-force
     */
    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += dt * xxVel;
        this.yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
