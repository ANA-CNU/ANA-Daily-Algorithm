import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] arr = br.readLine().split(" ");

            double student = Integer.parseInt(arr[0]);
            double[] score = new double[arr.length - 1];
            double sum = 0;

            for (int j = 0; j < arr.length - 1; j++) {
                score[j] = Integer.parseInt(arr[j + 1]);
                sum += Integer.parseInt(arr[j + 1]);
            }
            double average = sum / student;

            double high = 0;

            for (int j = 0; j < student; j++) {
                if (score[j] > average) {
                    high++;
                }
            }

            double highstudent = 100 * high / student;
            System.out.printf("%.3f", highstudent);
            System.out.println("%");
        }
    }
}
