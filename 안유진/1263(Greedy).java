import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            arr[i][0] = t;
            arr[i][1] = s;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int lateSleep = arr[0][1] - arr[0][0];

        for(int i = 1; i < N; i++) {
            if(arr[i][1] < lateSleep) {
                lateSleep = (arr[i][1] - arr[i][0]);
            }else{
                lateSleep -= arr[i][0];
            }
        }

        if(lateSleep < 0){
            System.out.println(-1);
        }else{
            System.out.println(lateSleep);
        }
    }
}
