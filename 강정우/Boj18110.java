import java.util.*;
import java.io.*;
import java.math.*;
public class Boj18110 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        double sum=0;
        int k=(int)Math.round(n*0.15);
        Arrays.sort(arr);
        for(int i=k;i<n-k;i++){
            sum+=arr[i];
        }
        System.out.println((int)Math.round(sum/(n-2*k)));
    }
}
