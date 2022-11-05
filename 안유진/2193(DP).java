import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long arr[] = new long[N + 1];

        if(N < 2){
            System.out.println(1);
        } else {
            arr[0] = 0;
            arr[1] = 1;

            for(int i = 2; i < N + 1; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            System.out.println(arr[N]);
        }
    }
}
