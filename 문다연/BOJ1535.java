package BOJ;
import java.io.*;
import java.util.*;

public class BOJ1535 {

    static int N;
    static int [] pain, gain;

    static int thankU(int idx, int health) {
        if (idx == N) return 0;

        int sayThanks = 0, noThanks = 0;

        if (health - pain[idx + 1] > 0) sayThanks = thankU(idx + 1, health - pain[idx + 1]) + gain[idx + 1];

        noThanks = thankU(idx + 1, health);
        return Math.max(sayThanks, noThanks);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        pain = new int[N + 1];
        gain = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) pain[n] = Integer.parseInt(st.nextToken()); // 잃는 체력
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) gain[n] = Integer.parseInt(st.nextToken()); // 얻는 기쁨

        System.out.println(thankU(0, 100));
    }
}
