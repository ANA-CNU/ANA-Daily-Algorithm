import java.util.*;
import java.io.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] Args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()) {
            st = new StringTokenizer(sc.nextLine());
            int c = stoi(st);
            final int sTc = stoi(st);
            int cnt = c;
            while(c / sTc != 0) {
                cnt+=c/sTc;
                c = c/sTc + c%sTc;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static int stoi() throws IOException {
        return Integer.parseInt(sc.nextLine());
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}