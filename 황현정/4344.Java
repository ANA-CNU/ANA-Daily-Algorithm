import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int[][] score = new int[c][];
        float[] average = new float[c];
        int n = 0;
        for (int i=0; i<c; i++){
            n = sc.nextInt();
            score[i] = new int[n];
            float sum = 0.0f;
            for (int j=0; j<n; j++){
                score[i][j] = sc.nextInt();
                sum += score[i][j];
            }
            average[i] = sum/n;
        }
        for(int i=0; i<c; i++){
            int count = 0;
            for(int j=0; j<score[i].length; j++){
                if (average[i] < score[i][j]) {
                    count += 1;
                }
            }
            System.out.printf("%.3f%%\n",100*((float)count/(float)score[i].length));
        }
    }
}
