import java.io.*;
import java.util.*;

public class Hororop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());

        int start = 0;
        while (true) {
            int max = 0;
            int index = 0;

            int target = Math.min(N - 1, S + start);
            for(int i = start; i < target + 1; i++){
                if(max < arr[i]){
                    max = arr[i];
                    index = i;
                }
            }

            for(int i = index; i > start; i--){
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }

            S -= (index - start);
            start++;

            if(S <= 0 || start == N - 1){
                break;
            }
        }

        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
