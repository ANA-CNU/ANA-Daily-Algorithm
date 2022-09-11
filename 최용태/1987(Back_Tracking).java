import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] a;
    static int N = 0;
    static int M = 0;
    static int ans = 1;

    public static void run() throws IOException {
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());
        a = new char[N][M];

        for (int i = 0; i < N; i++) {
            a[i] = br.readLine().toCharArray();
        }
        boolean V[]=new boolean['Z'-'A'+1];
        V[a[0][0]-'A']=true;
        search(V,0, 0, 1);
        System.out.println(ans);
    }

    public static void search(boolean[] visited, int I, int J, int n) {
        if (I - 1 >= 0 && !visited[a[I - 1][J] - 'A']) {
            visited[a[I - 1][J] - 'A'] = true;
            search(visited, I - 1, J, n + 1);
            visited[a[I - 1][J] - 'A'] = false;
        }
        if (I+1<N && !visited[a[I+1][J] - 'A']) {
            visited[a[I+1][J] - 'A'] = true;
            search(visited, I+1, J, n + 1);
            visited[a[I+1][J] - 'A'] = false;
        }
        if (J-1 >= 0 && !visited[a[I][J-1] - 'A']) {
            visited[a[I][J-1] - 'A'] = true;
            search(visited, I, J-1, n + 1);
            visited[a[I][J-1] - 'A'] = false;
        }
        if (J+1<M && !visited[a[I][J+1] - 'A']) {
            visited[a[I][J+1] - 'A'] = true;
            search(visited, I, J+1, n + 1);
            visited[a[I][J+1] - 'A'] = false;
        }
        ans=Math.max(n,ans);
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}