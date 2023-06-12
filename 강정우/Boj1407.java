import java.io.*;
public class Boj1407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        System.out.println(function(B)-function(A-1));
    }

    static long function(long x) {
        long sum = 0;
        long y;
        long i = 1;

        while(x>0) {
            if(x%2==0)
                y = x/2;
            else
                y = x/2+1;
            sum += y*i;
            x -= y;
            i*=2;
        }
        return sum;
    }
}
