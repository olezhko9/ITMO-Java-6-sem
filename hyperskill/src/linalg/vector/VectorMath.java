package linalg.vector;

public class VectorMath {


    public static double[] mult(double[] va, double a) {
        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] * a;
        }

        return product;
    }

    public static double[] mult(double[] va, double[] vb) throws VectorMathException {
        if (va.length != vb.length) {
            throw new VectorMathException(String.format("Incompatible dimensions: %d and %d", va.length, vb.length));
        }
        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] * vb[i];
        }

        return product;
    }

    public static double[] divide(double[] va, double a) throws VectorMathException{
        if (a == 0.0) {
            throw new VectorMathException("Division by zero");
        }

        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] / a;
        }

        return product;
    }

    public static double[] add(double[] va, double a) {

        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] + a;
        }

        return product;
    }

    public static double[] add(double[] va, double[] vb) throws VectorMathException{
        if (va.length != vb.length) {
            throw new VectorMathException(String.format("Incompatible dimensions: %d and %d", va.length, vb.length));
        }

        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] + vb[i];
        }

        return product;
    }

    public static double[] minus(double[] va, double a) {

        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] - a;
        }

        return product;
    }

    public static double[] minus(double[] va, double[] vb) throws VectorMathException{
        if (va.length != vb.length) {
            throw new VectorMathException(String.format("Incompatible dimensions: %d and %d", va.length, vb.length));
        }

        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] - vb[i];
        }

        return product;
    }

    public static boolean isZeros(double[] va, int start, int end) {
        for (int i = start; i < end; i++) {
            if (va[i] != 0) return false;
        }
        return true;
    }
}
