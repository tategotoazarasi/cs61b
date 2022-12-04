public class NBody {
    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int n = in.readInt();
        in.readDouble();
        Planet[] ans = new Planet[n];
        for (int i = 0; i < n; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            ans[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return ans;
    }
}
