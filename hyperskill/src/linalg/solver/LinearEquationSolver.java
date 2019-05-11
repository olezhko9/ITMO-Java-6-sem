package linalg.solver;

public abstract class LinearEquationSolver {

    public LinearEquationSolver() {}

    public abstract double[] solve(double[][] A, double[] Y) throws SolverException;

    public abstract double[] solve(double[][] extendedA) throws SolverException;
}
