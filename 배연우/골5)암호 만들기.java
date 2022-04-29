import java.util.Arrays;
import java.util.Scanner;

class Main {
    static char[] list;
    static boolean[] visited;
    static char[] mo = {'a', 'e','i','o','u'};
    static Scanner s = new Scanner(System.in);
    static int N;
    static int M;
    public static void main(String[] Args) {
        N = s.nextInt();
        int cnt = s.nextInt();
        M = cnt;
        list = new char[cnt];
        visited = new boolean[cnt];
        for(int i = 0; i < cnt; i++) {
            list[i] = s.next().charAt(0);
        }
        Arrays.sort(list);
        bf(-1, 0);
    }

    static void bf(int pre, int cnt) {
        if(cnt == N) {
            int isMo = 0;
            String ret = "";
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    ret += list[i];
                    for(char j : mo) {
                        if(j == list[i]) {
                            isMo++;
                        }
                    }
                }
            }
            if(isMo > 0 && isMo <= N-2) {
                System.out.println(ret);
            }
            return;
        }

        for(int i = pre +1; i < M; i++) {
            visited[i] = true;
            bf(i , cnt+1);
            visited[i] = false;
        }
    }
}