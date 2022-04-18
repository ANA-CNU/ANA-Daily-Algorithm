import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1934 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /* 유클리드 호제법
        1. a와 b의 최대공약수
        == b와 r의 최대공약수
        == r과 r2의 최대공약수
        ...
        a % b => r
        b % r => r2
        r % r2 => r3
        if) r3가 0, 즉 나머지가 0이면 최대공약수는 r2

        2. a와 b의 최대공배수
        -> a*b / gcd(a,b)
        */

        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int r = gcd(A, B);
            System.out.println(A*B/r);

        }
    }

    public static int gcd(int a, int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
