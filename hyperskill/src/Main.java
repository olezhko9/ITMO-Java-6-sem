import java.io.IOException;
import java.util.Arrays;

import linalg.solver.*;


public class Main {

    public static void main(String[] args) {

        double[][] matrix;
        double[] X;

        try {
            matrix = DataWorker.readDataFromFile("resources/in.txt");

            LinearEquationSolver gaussJordanSolver = new GaussJordanSolver(4);
            X = gaussJordanSolver.solve(matrix);
            System.out.println(Arrays.toString(X));

            DataWorker.writeDataToFile("resources/out.txt", X);
        } catch (IOException e) {
            System.out.println("Wrong file format");
            e.printStackTrace();
        } catch (SolverException e) {
            System.out.println(e.getMessage());
        }
    }


}
