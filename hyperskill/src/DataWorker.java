import java.io.*;

class DataWorker {

    static double[][] readDataFromFile(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String[] firstLine = br.readLine().split(" ");
        int nVars = Integer.parseInt(firstLine[0]);
        int nEquations = Integer.parseInt(firstLine[1]);
        double[][] data = new double[nEquations][nVars + 1];

        for (int i = 0; i < nEquations; i++) {
            String line = br.readLine();
            data[i] = parseNumbersFromString(line);
        }

        br.close();
        return data;
    }

    static void writeDataToFile(String filename, double[] data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (double datum : data) {
            bw.write(datum + "\n");
        }

        bw.close();
    }

    static void writeDataToFile(String filename, String data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write(data);
        bw.close();
    }

    private static double[] parseNumbersFromString(String s) {
        String[] parts = s.split("\\s+");

        double[] numbers = new double[parts.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.parseDouble(parts[i]);
        }

        return numbers;
    }
}
