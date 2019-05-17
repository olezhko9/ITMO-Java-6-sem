package linalg.solver;

import linalg.complex.Complex;

public abstract class LinearEquationSolver {

    public LinearEquationSolver() {}

    public abstract Complex[] solve(Complex[][] A, Complex[] Y) throws SolverException;

    public abstract Complex[] solve(Complex[][] extendedA) throws SolverException;
}
