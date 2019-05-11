import java.io.IOException;
import java.util.Arrays;

import linalg.solver.*;


public class Main {

    public static void main(String[] args) {
        System.out.println("Linear Equation Solver");
        double[][] A = {
                {2, 1, 3},
                {-1, 2, 1},
                {3, 1, 6}
        };

        double[] Y = {43, 3, 4};
        double[] X;

        try {
            LinearEquationSolver gaussJordanSolver = new GaussJordanSolver(2);
            X = gaussJordanSolver.solve(A, Y);
            System.out.println(Arrays.toString(X));
        } catch (SolverException e) {
            System.out.println(e.getMessage());
        }

        try {
            double[][] data = DataWorker.readDataFromFile("resources/in.txt");
            for (double[] row : data) {
                System.out.println(Arrays.toString(row));
            }
        } catch (IOException e) {
            System.out.println("Wrong input file format");
        }

        try {
            DataWorker.writeDataToFile("resources/out.txt", Y);
        } catch (IOException e) {
            System.out.println("Wrong input file format");
        }
    }


}
