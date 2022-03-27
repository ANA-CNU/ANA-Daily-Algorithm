package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {

    static boolean [] brokenButton;

    static int remoteControl(int channel) {
        if (channel == 0) {
            if (brokenButton[0]) return -1;
            return 1;
        }

        int dist = 0;
        while(channel > 0) {
            if (brokenButton[channel % 10]) return -1;
            dist++;
            channel /= 10;
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        brokenButton = new boolean[10];
        int currentChannel = 100;

        if (N == currentChannel) {
            System.out.println(0);
            return;
        }

        if (M > 0) st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) brokenButton[Integer.parseInt(st.nextToken())] = true;

        int ans = Math.abs(N - currentChannel);
        int cnt;
        for (int i = 0; i < 1_000_000; ++i) {
            cnt = remoteControl(i);
            if (cnt > 0) {
                cnt += Math.abs(N - i);
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}
