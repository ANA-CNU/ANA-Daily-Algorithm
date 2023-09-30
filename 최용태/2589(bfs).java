import com.sun.jdi.Value;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {
    static char[][] map;
    static char[][] originalMap;

    public static int bfs(Loc start) {
        Queue<Loc> q = new LinkedList<>();
        q.offer(start);
        boolean[][] visited=new boolean[map.length][map[0].length];
        visited[start.i][start.j]=true;

        Loc LAST=start;

        int[] di={1,-1,0,0};
        int[] dj={0,0,-1,1};

        while (!q.isEmpty()) {
            LAST = q.poll();
            for(int x=0;x<di.length;x++){
                Loc next=new Loc(LAST.i+di[x],LAST.j+dj[x], LAST.depth+1);
                if(inRange(next) && !visited[next.i][next.j] && map[next.i][next.j]=='L'){
                    q.offer(next);
                    visited[next.i][next.j]=true;
                }
            }
        }

        return LAST.depth;
    }

    public static boolean inRange(Loc l){
        return 0 <= Math.min(l.i,l.j) && l.i<map.length && l.j<map[0].length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(s.nextToken());
        int M = Integer.parseInt(s.nextToken());

        map = new char[N][M];

        for (int n = 0; n < N; n++) map[n] = br.readLine().toCharArray();

        int max=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='L'){
                    max=Math.max(bfs(new Loc(i,j,0)),max);
                }
            }
        }

        System.out.println(max);
    }
}

class Loc {
    int i;
    int j;
    int depth;

    Loc(int ii, int jj,int d) {
        i = ii;
        j = jj;
        depth=d;
    }
}
