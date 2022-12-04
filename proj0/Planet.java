public class Planet {
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

}
