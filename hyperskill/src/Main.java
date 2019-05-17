import java.io.IOException;
import java.util.Arrays;

import linalg.complex.Complex;
import linalg.solver.*;


public class Main {

    public static void main(String[] args) {

        Complex[][] matrix;
        Complex[] X;

        try {
            matrix = DataWorker.readDataFromFile("resources/in.txt");

            for (Complex[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }

            LinearEquationSolver gaussJordanSolver = new GaussJordanSolver(3);
            X = gaussJordanSolver.solve(matrix);
            System.out.println(Arrays.toString(X));

            DataWorker.writeDataToFile("resources/out.txt", X);
        } catch (IOException e) {
            System.out.println("Wrong file format or file doesn't exist");
            e.printStackTrace();
        }
        catch (SolverException e) {
            System.out.println(e.getMessage());
            try {
                DataWorker.writeDataToFile("resources/out.txt", e.getMessage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
