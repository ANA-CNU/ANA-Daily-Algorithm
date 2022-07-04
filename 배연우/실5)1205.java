import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        //input
        int n, s, l;
        StringTokenizer st = getSt();
        n = stoi(st);
        s = stoi(st);
        l = stoi(st);

        //special case
        if(n == 0) {
            if(l == 0) {
                System.out.println(-1);
                return;
            }
            System.out.println(1);
            return;
        }

        int[] list = new int[n];
        st = getSt();
        for (int i = 0; i < n; i++) {
            list[i] = stoi(st);
        }

        //cal1: return -1
        if(n == l && s <= list[n-1]) {
            System.out.println(-1);
            return;
        }

        //cal2: get rank
        int rank = 0;
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if(pre != list[i]) {
                rank++;
            }

            if(s >= list[i]) {
                System.out.println(rank);
                return;
            }
        }

        System.out.println(n+1);
    }

    static StringTokenizer getSt() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}