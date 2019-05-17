package linalg.complex;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Complex {
    public static final double EPSILON = 0.001;

    final double real;
    final double imag

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex(String s) throws NumberFormatException {
        final String[] strs = split(s);
        System.out.println(strs[0] + " " + strs[1]);
        if (strs[1].contains("i")) {
            strs[1] = strs[1].replace("i", "1");
        }
        if (strs[1].equals("-")) {
            strs[1] = "-1";
        }
        if (strs[1].equals("+")) {
            strs[1] = "1";
        }
        real = Double.parseDouble(strs[0]);
        imag = Double.parseDouble(strs[1]);
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imag + b.imag);
    }

    public static Complex divide(Complex a, Complex b) {
        final Complex bConjugate = b.conjugate();
        final Complex a1 = Complex.multiply(a, bConjugate);
        final Complex b1 = Complex.multiply(b, bConjugate);

        return new Complex(a1.real / b1.real, a1.imag / b1.real);
    }

    public static Complex multiply(Complex a, Complex b) {
        return new Complex(a.real * b.real - a.imag * b.imag, a.real * b.imag + a.imag * b.real);
    }

    public Complex conjugate() {
        return new Complex(real, -imag);
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (!(other instanceof Complex)) {
            return false;
        }

        Complex o = (Complex) other;
        return Math.abs(o.imag - imag) < EPSILON && Math.abs(o.real - real) < EPSILON;
    }

    @Override
    public String toString() {
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        final DecimalFormat realFormat = new DecimalFormat("0.####", symbols);
        final DecimalFormat imagFormat = new DecimalFormat("0.####i", symbols);
        if (Math.abs(imag) < EPSILON) {
            return realFormat.format(real);
        }
        if (Math.abs(real) < EPSILON) {
            return imagFormat.format(imag);
        }
        imagFormat.setPositivePrefix("+");
        return String.format("%s%s", realFormat.format(real), imagFormat.format(imag));
    }

    private String[] split(String s) throws NumberFormatException {
        if (s.equals("i")) {
            return new String[]{"0", "1"};
        }
        if (s.equals("-i")) {
            return new String[]{"0", "-1"};
        }
        String realString = "0";
        String imagString = "0";
        int i = 1;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                realString = s.substring(0, i);
                imagString = s.substring(i, s.length() - 1);
                if (s.charAt(s.length()-1) != 'i') {
                    throw new NumberFormatException("can't parse complex");
                }
                break;
            }
            if (s.charAt(i) == 'i') {
                if (i != s.length() - 1) {
                    throw  new NumberFormatException("can't parse complex");
                }
                imagString = s.substring(0, i);
                break;
            }
        }
        if (i == s.length()) {
            realString = s;
        }
        if (imagString.length() == 0) {
            imagString = "1";
        }
        return new String[]{realString, imagString};
    }
}