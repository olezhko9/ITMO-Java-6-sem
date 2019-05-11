import java.io.*;

class DataWorker {

    static double[][] readDataFromFile(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filename));

        int n = Integer.parseInt(br.readLine());
        double[][] data = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            data[i] = parseNumbersFromString(line);
        }

        return data;
    }

    static void writeDataToFile(String filename, double[] data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (double el : data) {
            bw.write(Double.toString(el));
        }
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
