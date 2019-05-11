package linalg.vector;

public class VectorMathException extends Exception {

    public VectorMathException(String msg) {
        super(msg);
    }

    public VectorMathException(String msg, Exception cause){
        super(msg, cause);
    }

}
