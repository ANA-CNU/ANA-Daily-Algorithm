import java.io.*;

public class 백준_11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        String[] nums = br.readLine().split(" ");
        int[] accumSum = new int[N+1];

        accumSum[0] = 0;
        accumSum[1] = Integer.parseInt(nums[0]);

        for(int i = 1; i <= N; i++){
            accumSum[i] = accumSum[i-1] + Integer.parseInt(nums[i-1]);
        }

        for(int i = 0; i < M; i++){
            st = br.readLine().split(" ");
            int k = Integer.parseInt(st[0]);
            int j = Integer.parseInt(st[1]);
            System.out.println(accumSum[j]-accumSum[k-1]);
        }
    }
        
}