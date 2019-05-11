package linalg;

import java.util.Arrays;

import linalg.solver.LinearEquationSolver;
import linalg.solver.GaussJordanSolver;
import linalg.solver.SolverException;



public class Main {

    public static void main(String[] args) {
        System.out.println("Linear Equation Solver");
        double[][] A = {
                {2, 1, 3},
                {-1, 2, 1},
                {3, 1, 6}
        };

        double[] Y = {43, 3, 4};

        try {
            LinearEquationSolver gaussJordanSolver = new GaussJordanSolver();
            double[] ans = gaussJordanSolver.solve(A, Y);
            System.out.println(Arrays.toString(ans));
        } catch (SolverException e) {
            System.out.println(e.getMessage());
        }
    }
}
