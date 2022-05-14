import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = 666;
        int cnt = 1;
        while(cnt!=N) {
            M++;
            if(String.valueOf(M).contains("666")) {
                cnt++;
            }
        }

        System.out.println(M);
    }
}