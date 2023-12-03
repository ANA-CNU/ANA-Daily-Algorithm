import java.io.*;
public class Boj17425{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] f = new int[1000001];
        long[] s = new long[1000001];
        for(int i = 1; i <= 1000000; i++) {
            for(int j = i; j <= 1000000; j += i) {
                f[j] += i;
            }
        }
        for(int i = 1; i <= 1000000; i++) {
            s[i] = f[i] + s[i-1];
        }
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(s[n] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
