package linalg.vector;

import linalg.complex.Complex;

public class VectorMath {


    public static Complex[] mult(Complex[] va, Complex a) {
        Complex[] product = new Complex[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = Complex.multiply(va[i], a);
        }

        return product;
    }

    public static Complex[] mult(Complex[] va, Complex[] vb) throws VectorMathException {
        if (va.length != vb.length) {
            throw new VectorMathException(String.format("Incompatible dimensions: %d and %d", va.length, vb.length));
        }
        Complex[] product = new Complex[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = Complex.multiply(va[i], vb[i]);
        }

        return product;
    }

    public static Complex[] divide(Complex[] va, Complex a) throws VectorMathException{
        if (a.equals(new Complex(0.0, 0.0))) {
            throw new VectorMathException("Division by zero");
        }

        Complex[] product = new Complex[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = Complex.divide(va[i], a);
        }

        return product;
    }

    public static Complex[] add(Complex[] va, Complex a) {

        Complex[] product = new Complex[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = Complex.add(va[i], a);
        }

        return product;
    }

    public static Complex[] add(Complex[] va, Complex[] vb) throws VectorMathException{
        if (va.length != vb.length) {
            throw new VectorMathException(String.format("Incompatible dimensions: %d and %d", va.length, vb.length));
        }

        Complex[] product = new Complex[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = Complex.add(va[i], vb[i]);
        }

        return product;
    }

    public static Complex[] minus(Complex[] va, Complex a) {

        Complex[] product = new Complex[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = Complex.sub(va[i], a);
        }

        return product;
    }

    public static Complex[] minus(Complex[] va, Complex[] vb) throws VectorMathException{
        if (va.length != vb.length) {
            throw new VectorMathException(String.format("Incompatible dimensions: %d and %d", va.length, vb.length));
        }

        Complex[] product = new Complex[va.length];

        for (int i = 0; i < product.length; i++) {
            product[i] = Complex.sub(va[i], vb[i]);
        }

        return product;
    }

    public static boolean isZeros(Complex[] va, int start, int end) {
        for (int i = start; i < end; i++) {
            if (!va[i].equals(new Complex(0.0, 0.0))) return false;
        }
        return true;
    }
}
