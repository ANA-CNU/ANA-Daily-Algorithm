package BOJ;

import java.io.*;

public class BOJ14453 {

    static class Game {
        int H, P, S;
        Game() {
            this.H = 0; this.P = 0; this.S = 0;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Game [] fj = new Game[N + 1]; // H, P, S
        fj[0] = new Game();
        for (int n = 1; n <= N; n++) {
            fj[n] = new Game();
            String given = br.readLine();
            if (given.equals("H")) fj[n].H++;
            else if (given.equals("P")) fj[n].P++;
            else fj[n].S++;

            fj[n].H += fj[n - 1].H;
            fj[n].P += fj[n - 1].P;
            fj[n].S += fj[n - 1].S;
        }

        int ans = Math.max(fj[N].H, Math.max(fj[N].P, fj[N].S));

        for (int n = 2; n <= N; n++) {
            int start = Math.max(fj[n - 1].H, Math.max(fj[n - 1].P, fj[n - 1].S));
            int end = Math.max((fj[N].H - fj[n - 1].H), Math.max((fj[N].P - fj[n - 1].P), (fj[N].S - fj[n - 1].S)));
            ans = Math.max(ans, (start + end));
        }
        System.out.println(ans);
    }
}
