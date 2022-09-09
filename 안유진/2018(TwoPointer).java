import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //슬라이딩윈도우를 위한 배열생성
        int arr[] = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (true){
            if(sum >= N){
                sum -= arr[left];
                left++;
            }
            else if(right == N-1){
                break;
            }else if(sum < N){
                sum += arr[right];
                right++;
            }
            if(sum == N){
                count++;
            }
        }
        if(N == 1){
            System.out.println(1);
        }else {
            System.out.println(count + 1);
        }

    }
}
