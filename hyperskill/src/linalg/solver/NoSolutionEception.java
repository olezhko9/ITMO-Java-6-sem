package linalg.solver;

public class NoSolutionEception extends SolverException {

    public NoSolutionEception(String msg) { super(msg); }

    public NoSolutionEception(String msg, Exception cause){
        super(msg, cause);
    }
}
