package linalg.solver;

import linalg.complex.Complex;
import linalg.vector.VectorMath;
import linalg.vector.VectorMathException;

public class GaussJordanSolver extends LinearEquationSolver {

    private int precision;

    public GaussJordanSolver() {}

    public GaussJordanSolver(int precision) {
        this.precision = precision;
    }

    @Override
    public Complex[] solve(Complex[][] A, Complex[] Y) throws SolverException{

        Complex[][] extendedA = new Complex[A.length][A[0].length + 1];
        int nEquations = extendedA.length;

        for (int i = 0; i < nEquations; i++) {
            if (A[i].length >= 0) System.arraycopy(A[i], 0, extendedA[i], 0, A[i].length);
            extendedA[i][A[i].length] = Y[i];
        }

        return this.solve(extendedA);
    }

    @Override
    public Complex[] solve(Complex[][] extendedMatrix) throws SolverException {

        int nEquations = extendedMatrix.length;
        int nVars = extendedMatrix[0].length - 1;

        int nonZeroRows = nEquations;

        for (int i = 0; i < nEquations; i++) {
            if (VectorMath.isZeros(extendedMatrix[i], 0, nVars)) {
                nonZeroRows -= 1;
                continue;
            }

            Complex m = extendedMatrix[i][i];
            try {
                if (m.equals(new Complex(0.0, 0.0))) {
                    int l = i;
                    while (m.equals(new Complex(0.0, 0.0)) && l < nEquations) {
                        l += 1;
                        m = extendedMatrix[l][i];
                    }
                    Complex[] temp = extendedMatrix[i];
                    extendedMatrix[i] = extendedMatrix[l];
                    extendedMatrix[l] = temp;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new InfiniteSolutionsException("Infinitely many solutions");
            }

            try {
                for (int j = 0; j < nEquations; j++) {
                    if (j != i) {
                        Complex k = Complex.divide(extendedMatrix[j][i], m);
                        extendedMatrix[j] = VectorMath.minus(extendedMatrix[j], VectorMath.mult(extendedMatrix[i], k));
                    }
                }
                extendedMatrix[i] = VectorMath.divide(extendedMatrix[i], m);
            } catch (VectorMathException e) {
                throw new SolverException("Can't solve given equation");
            }

        }

        if (checkForNoSolution(extendedMatrix)) {
            throw new NoSolutionEception("No solutions");
        }

        if (nonZeroRows < nVars) {
            throw new InfiniteSolutionsException("Infinitely many solutions");
        }

        Complex[] X = new Complex[nonZeroRows];

        double k = Math.pow(10.0, this.precision);
        for (int i = 0; i < nonZeroRows; i++) {
            X[i] = extendedMatrix[i][nVars];
        }

        return X;
    }

    private boolean checkForNoSolution(Complex[][] extendedMatrix) {
        for (Complex[] row : extendedMatrix) {
            if (VectorMath.isZeros(row, 0, row.length - 1) && !row[row.length - 1].equals(new Complex(0.0, 0.0))) {
                return true;
            }
        }
        return false;
    }
}
