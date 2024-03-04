import java.util.*;
import java.io.*;
public class Boj1806 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, s;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;
        while(start <= n && end <= n) {
            if(total >= s && min > end - start)
                min = end - start;
            if(total < s) {
                total += arr[end];
                end++;
            } else {
                total -= arr[start];
                start++;
            }
        }
        if(min == Integer.MAX_VALUE)
            System.out.println("0");
        else
            System.out.println(min);
    }
}
