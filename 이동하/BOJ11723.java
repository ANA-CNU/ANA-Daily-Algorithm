import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] S = new boolean[21];
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if (st.countTokens() != 0) {
                x = Integer.parseInt(st.nextToken());
            }
            if (cmd.equals("add")) {
                S[x] = true;
            } else if (cmd.equals("remove")) {
                S[x] = false;
            } else if (cmd.equals("check")) {
                if (S[x]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (cmd.equals("toggle")) {
                S[x] = !S[x];
            } else if (cmd.equals("all")) {
                S[1] = true;
                S[2] = true;
                S[3] = true;
                S[4] = true;
                S[5] = true;
                S[6] = true;
                S[7] = true;
                S[8] = true;
                S[9] = true;
                S[10] = true;
                S[11] = true;
                S[12] = true;
                S[13] = true;
                S[14] = true;
                S[15] = true;
                S[16] = true;
                S[17] = true;
                S[18] = true;
                S[19] = true;
                S[20] = true;
            } else {
                S[1] = !true;
                S[2] = !true;
                S[3] = !true;
                S[4] = !true;
                S[5] = !true;
                S[6] = !true;
                S[7] = !true;
                S[8] = !true;
                S[9] = !true;
                S[10] = !true;
                S[11] = !true;
                S[12] = !true;
                S[13] = !true;
                S[14] = !true;
                S[15] = !true;
                S[16] = !true;
                S[17] = !true;
                S[18] = !true;
                S[19] = !true;
                S[20] = !true;
            }
        }
        System.out.println(sb);
    }
}
