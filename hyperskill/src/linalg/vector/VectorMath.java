package linalg.vector;

public class VectorMath {


    public static double[] mult(double[] va, double a) {
        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] * a;
        }

        return product;
    }

    public static double[] mult(double[] va, double[] vb) {
        if (va.length != vb.length) {
            // TODO: handle incompatible dimensions
            return null;
        }
        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] * vb[i];
        }

        return product;
    }

    public static double[] divide(double[] va, double a) {
        if (a == 0.0) {
            // TODO: handle division by zero
            return null;
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

    public static double[] add(double[] va, double[] vb) {
        if (va.length != vb.length) {
            // TODO: handle incompatible dimensions
            return null;
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

    public static double[] minus(double[] va, double[] vb) {
        if (va.length != vb.length) {
            // TODO: handle incompatible dimensions
            return null;
        }

        double[] product = new double[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = va[i] - vb[i];
        }

        return product;
    }
}
