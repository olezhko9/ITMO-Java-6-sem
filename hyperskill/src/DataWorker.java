import linalg.complex.Complex;

import java.io.*;

class DataWorker {

    static Complex[][] readDataFromFile(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String[] firstLine = br.readLine().split(" ");
        int nVars = Integer.parseInt(firstLine[0]);
        int nEquations = Integer.parseInt(firstLine[1]);
        Complex[][] data = new Complex[nEquations][nVars + 1];

        for (int i = 0; i < nEquations; i++) {
            String line = br.readLine();
            data[i] = parseNumbersFromString(line);
        }

        br.close();
        return data;
    }

    static void writeDataToFile(String filename, Complex[] data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (Complex datum : data) {
            bw.write(datum + "\n");
        }

        bw.close();
    }

    static void writeDataToFile(String filename, String data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write(data);
        bw.close();
    }

    private static Complex[] parseNumbersFromString(String s) {
        String[] parts = s.split("\\s+");

        Complex[] numbers = new Complex[parts.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Complex(parts[i]);
        }

        return numbers;
    }
}
