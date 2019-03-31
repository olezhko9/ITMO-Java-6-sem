import java.util.Date;

/** Base class Main */
public class Main {
    /** Program entry point */
    public static void main(String[] args){
        System.out.println("Starting project");

        byte v_byte = 127;
        short v_short = 129;
        char v_char = 'a';
        int v_int = 65999;
        long v_long = 4294967296L;
        float v_float = 0.33333334f;
        double v_double = 0.3333333333333333;
        boolean v_bool = true;

        System.out.println("This is byte: " + v_byte);
        System.out.println("This is short: " + v_short);
        System.out.println("This is char: " + v_char);
        System.out.println("This is int: " + v_int);
        System.out.println("This is long: " + v_long);
        System.out.println("This is float: " + v_float);
        System.out.println("This is double: " + v_double);
        System.out.println("This is boolean: " + v_bool);

        forChar((char) 97, (char) 123);
        System.out.println("Benchmark for int: " + intBenchmark());
        System.out.println("Benchmark for long: " + longBenchmark());

        int[] arr = {12, 43, 12, -65, 778, 123, 32, 76};
        System.out.println("Max element is " + maxElement(arr));

        Matrix matrix = new Matrix(3, 3);
        matrix.init();
        System.out.println("Normal matrix");
        matrix.show();
        matrix.transpose();
        System.out.println("Transposed matrix");
        matrix.show();

    }

    static void forChar(char begin, char end){
        for (char ch = begin; ch < end; ch++) {
            System.out.println(ch);
        }
    }

    static long intBenchmark(){
        long begin = new Date().getTime();
        int i = 0;
        for (int j = 0; j <= 100000000; j++) {
            i += 1;
        }
        long end = new Date().getTime();
        return end - begin;
    }

    static long longBenchmark(){
        long begin = new Date().getTime();
        long i = 0;
        for (int j = 0; j <= 100000000; j++) {
            i += 1;
        }
        long end = new Date().getTime();
        return end - begin;
    }

    static int maxElement(int[] mas){
        int maxEl = mas[0];
        for (int el : mas) {
            if (el > maxEl)
                maxEl = el;
        }
        return maxEl;
    }
}

