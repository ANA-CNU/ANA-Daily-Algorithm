import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        int arr[][] = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < N; i++){
            arr[i][0] = arr[i][0] + Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] = arr[i][1] + Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] = arr[i][2] + Math.min(arr[i-1][0], arr[i-1][1]);
        }
        System.out.println(Math.min(arr[N-1][0], Math.min(arr[N-1][1], arr[N-1][2])));
    }
}
//1. N을 받아서
//2. 배열에 저장하자
//3. 하나씩내려가면서 직전 index피해서 최소값골라줌
