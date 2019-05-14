package linalg.solver;

public class SolverException extends Exception{

    public SolverException(String msg) {
        super(msg);
    }

    public SolverException(String msg, Exception cause){
        super(msg, cause);
    }
}


