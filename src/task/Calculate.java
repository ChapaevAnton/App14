package task;

public interface Calculate {

    double getCalc(double a, double b, double c);

    static double calcDiscriminant(double a, double b, double c) {
        return Math.pow(b, 2) - (4 * a * c);
    }

    static double calcFunction(double a, double b, double c) {
        return a + Math.pow(b, c);
    }
}
