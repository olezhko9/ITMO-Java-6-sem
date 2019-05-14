package linalg.solver;

public class InfiniteSolutionsException extends SolverException {

    public InfiniteSolutionsException(String msg) { super(msg); }

    public InfiniteSolutionsException(String msg, Exception cause){
        super(msg, cause);
    }
}
