import java.io.*;
import java.util.*;

public class Main {
    static int H = 0;
    static int W = 0;
    static int[][] a;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static class Loc {
        int i = 0;
        int j = 0;

        Loc(int ii, int jj) {
            i = ii;
            j = jj;
        }
    }
    public static class lvQ{
        int r = 0;
        int f = 0;
        int MS = 0;
        int[] d;

        lvQ(int size) {
            d = new int[size];
            MS = size;
        }

        void eq(int i) {
            r = (r + 1) % MS;
            d[r] = i;
        }

        int dq() {
            if (isEmpty())
                return -1;

            f = (f + 1) % MS;
            return d[f];
        }

        boolean isEmpty() {
            return (f == r);
        }
    }
    public static class Q{
        int r = 0;
        int f = 0;
        int MS = 0;
        Loc[] d;

        Q(int size) {
            d = new Loc[size];
            MS = size;
        }

        void eq(Loc i) {
            r = (r + 1) % MS;
            d[r] = i;
        }

        Loc dq() {
            if (isEmpty())
                return null;

            f = (f + 1) % MS;
            return d[f];
        }

        boolean isEmpty() {
            return (f == r);
        }
    }

    public static boolean isGoal(Loc L) {
        return (L.i == H - 1 && L.j == W - 1);
    }

    public static int BFS() {
        int ans = 0;
        Q q = new Q(H * W);
        lvQ lvq= new lvQ(H*W);
        q.eq(new Loc(0, 0));
        lvq.eq(1);
        a[0][0] = -1;
        while (!q.isEmpty()) {
            Loc currentLoc = q.dq();
            int cLv=lvq.dq();

            if (isGoal(currentLoc)) {
                ans = cLv;
                break;
            }

            if (currentLoc.i - 1 > -1 && a[currentLoc.i - 1][currentLoc.j] == 1) {
                a[currentLoc.i - 1][currentLoc.j] = -1;
                q.eq(new Loc(currentLoc.i - 1, currentLoc.j));
                lvq.eq(cLv+1);
            }
            if (currentLoc.j + 1 < W && a[currentLoc.i][currentLoc.j + 1] == 1) {
                a[currentLoc.i][currentLoc.j + 1] = -1;
                q.eq(new Loc(currentLoc.i, currentLoc.j + 1));
                lvq.eq(cLv+1);
            }
            if (currentLoc.j - 1 > -1 && a[currentLoc.i][currentLoc.j - 1] == 1) {
                a[currentLoc.i][currentLoc.j - 1] = -1;
                q.eq(new Loc(currentLoc.i, currentLoc.j - 1));
                lvq.eq(cLv+1);
            }
            if (currentLoc.i + 1 < H && a[currentLoc.i + 1][currentLoc.j] == 1) {
                a[currentLoc.i + 1][currentLoc.j] = -1;
                q.eq(new Loc(currentLoc.i + 1, currentLoc.j));
                lvq.eq(cLv+1);
            }
        }

        return ans;
    }

    public static void search() throws IOException {
        a = new int[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(BFS());
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(s.nextToken());
        W = Integer.parseInt(s.nextToken());

        search();
    }
}
