package linalg.solver;

import linalg.vector.VectorMath;
import linalg.vector.VectorMathException;

public class GaussJordanSolver extends LinearEquationSolver {

    @Override
    public double[] solve(double[][] A, double[] Y) throws SolverException{

        double[] X = new double[A.length];
        double[][] extendedA = new double[A.length][A[0].length + 1];
        int nrow = extendedA.length;

        for (int i = 0; i < nrow; i++) {
            if (A[i].length >= 0) System.arraycopy(A[i], 0, extendedA[i], 0, A[i].length);
            extendedA[i][A[i].length] = Y[i];
        }

        for (int i = 0; i < nrow; i++) {
            double m = extendedA[i][i];
            try {

                for (int j = 0; j < nrow; j++) {
                    if (j != i) {
                        double k = extendedA[j][i] / m;
                        extendedA[j] = VectorMath.minus(extendedA[j], VectorMath.mult(extendedA[i], k));
                    }
                }

                extendedA[i] = VectorMath.divide(extendedA[i], m);

            } catch (VectorMathException e) {
                throw new SolverException("Can't solve given equation");
            }

        }

        for (int i = 0; i < nrow; i++) {
            X[i] = extendedA[i][nrow];
        }

        return X;
    }
}
