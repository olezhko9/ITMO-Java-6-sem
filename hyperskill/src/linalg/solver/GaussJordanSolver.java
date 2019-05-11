package linalg.solver;

import linalg.vector.VectorMath;
import linalg.vector.VectorMathException;

public class GaussJordanSolver extends LinearEquationSolver {

    private int precision;

    public GaussJordanSolver() {}

    public GaussJordanSolver(int precision) {
        this.precision = precision;
    }

    @Override
    public double[] solve(double[][] A, double[] Y) throws SolverException{

        double[][] extendedA = new double[A.length][A[0].length + 1];
        int nrow = extendedA.length;

        for (int i = 0; i < nrow; i++) {
            if (A[i].length >= 0) System.arraycopy(A[i], 0, extendedA[i], 0, A[i].length);
            extendedA[i][A[i].length] = Y[i];
        }

        return this.solve(extendedA);
    }

    @Override
    public double[] solve(double[][] extendedMatrix) throws SolverException {

        int nrow = extendedMatrix.length;
        double[] X = new double[nrow];

        for (int i = 0; i < nrow; i++) {
            double m = extendedMatrix[i][i];
            try {
                for (int j = 0; j < nrow; j++) {
                    if (j != i) {
                        double k = extendedMatrix[j][i] / m;
                        extendedMatrix[j] = VectorMath.minus(extendedMatrix[j], VectorMath.mult(extendedMatrix[i], k));
                    }
                }
                extendedMatrix[i] = VectorMath.divide(extendedMatrix[i], m);
            } catch (VectorMathException e) {
                throw new SolverException("Can't solve given equation");
            }

        }

        for (int i = 0; i < nrow; i++) {
            double k = Math.pow(10.0, this.precision);
            X[i] = Math.round(extendedMatrix[i][nrow] * k) / k;
        }

        return X;
    }
}
