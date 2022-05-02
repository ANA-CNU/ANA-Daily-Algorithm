import java.io.*;

public class 백준_16515 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double sum = 0;

        for(int i = 0; i <= n; i++){
            sum = sum + factorial(i);
        }
        System.out.println(sum);
    }
    public static double factorial(int n){
        // n!
        double fac = 1.0;
        for(int i = 1; i <= n; i++){
            fac *= i;
        }
        return 1/fac;
    }
}
