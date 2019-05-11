package linalg.vector;

class VectorMathException extends Exception {

    VectorMathException(String msg) {
        super(msg);
    }

    VectorMathException(String msg, Exception cause){
        super(msg, cause);
    }

}
