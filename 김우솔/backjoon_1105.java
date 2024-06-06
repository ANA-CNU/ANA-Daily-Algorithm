package done;

import java.io.*;
import java.util.*;

public class backjoon_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();

        if (l.length() != r.length()) {
            bw.write(0 + "\n");
        }else {
            int count = 0;
            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) == r.charAt(i) && l.charAt(i) == '8') {
                    count++;
                }else if (l.charAt(i) != r.charAt(i)){
                    break;
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}

