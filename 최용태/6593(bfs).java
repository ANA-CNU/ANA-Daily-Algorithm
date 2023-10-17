import com.sun.jdi.Value;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {
    static char[][][] building;
    static final char BLOCK='#';
    static final char GOAL='E';
    static int H;
    static int N;
    static int M;

    public static boolean inRange(Loc loc){
        return loc.i > -1 && loc.i < N && loc.j > -1 && loc.j < M && loc.h > -1 && loc.h < H;
    }
    public static Loc bfs(Loc start){
        Queue<Loc> q=new LinkedList<>();
        q.offer(start);
        building[start.h][start.i][start.j]=BLOCK;

        int[] di={-1,1,0,0,0,0};
        int[] dj={0,0,-1,1,0,0};
        int[] dh={0,0,0,0,-1,1};


        while(!q.isEmpty()){
            Loc here=q.poll();

            for(int i=0;i<di.length;i++){
                Loc next = new Loc(di[i]+here.i,dj[i]+here.j,dh[i]+here.h);
                if(inRange(next) && building[next.h][next.i][next.j]!=BLOCK){

                    next.d += here.d+1; // depth increase

                    if(building[next.h][next.i][next.j] == GOAL){
                        return next;
                    }

                    building[next.h][next.i][next.j] = BLOCK;
                    q.offer(next);
                }
            }
        }

        return null;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s;
        StringBuilder writer=new StringBuilder();

        while(true) {
            s = new StringTokenizer(br.readLine(), " ");

            H = Integer.parseInt(s.nextToken());
            N = Integer.parseInt(s.nextToken());
            M = Integer.parseInt(s.nextToken());

            if(N+H+M == 0) break;

            building = new char[H][N][M];
            Loc start = null;

            for (int h = 0; h < H; h++) {
                for (int n = 0; n < N; n++) {
                    String src = br.readLine();
                    for (int m = 0; m < M; m++) {
                        building[h][n][m] = src.charAt(m);
                        if (building[h][n][m] == 'S')
                            start = new Loc(n, m, h);
                    }
                }
                br.readLine();
            }
            Loc result = bfs(start);
            String ans = result==null ? "Trapped!\n" : String.format("Escaped in %d minute(s).\n",result.d);
            writer.append(ans);
        }

        System.out.println(writer);

    }
}

class Loc{
    int i;
    int j;
    int h;
    int d=0;

    Loc(int ii,int jj,int hh){
        i=ii;
        j=jj;
        h=hh;
    }
}
