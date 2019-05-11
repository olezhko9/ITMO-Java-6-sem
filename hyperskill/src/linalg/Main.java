package linalg;

import linalg.vector.VectorMath;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Linear Equation Solver");
        double[] va = {1, 2, 3};
        double[] vb = {3, 2, 1};
        double[] res = VectorMath.divide(va, 2);
        System.out.println(Arrays.toString(res));
    }
}
