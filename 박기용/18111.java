import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int blocks = Integer.parseInt(st.nextToken());
        int[][] surface = new int[row][column];
        int sum = 0;

        for (int i = 0; i < row; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                surface[i][j] = Integer.parseInt(st1.nextToken());
                sum += surface[i][j];
            }
        }

        int land = row * column;
        int limitHeight = (sum + blocks) / land;

        int timeMin = 100000000;
        int finalHeight = 0;

        for (int k = 0; k <= limitHeight; k++) {
            int timeSum = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (surface[i][j] < k) {
                        timeSum += k - surface[i][j];
                    } else if (surface[i][j] > k) {
                        timeSum += 2 * (surface[i][j] - k);
                    }
                }
            }
            if (timeMin >= timeSum){
                timeMin = timeSum;
                finalHeight = k;
            }
        }

        bw.write(timeMin + " " + finalHeight);
        bw.close();
    }
}
