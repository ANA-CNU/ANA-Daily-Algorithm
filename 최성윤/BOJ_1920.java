import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] A = new int [N];

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            if(Arrays.binarySearch(A, Integer.parseInt(st1.nextToken())) >= 0){

                sb.append(1).append('\n');

            }
            else {
                sb.append(0).append('\n');
            }

        }
        System.out.println(sb);


    }

}
