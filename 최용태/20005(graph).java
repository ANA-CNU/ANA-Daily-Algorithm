import java.util.*;
import java.io.*;


public class Main {
    static char[][] BOARD;
    static int N;
    static int M;
    static User[] USER_INFO=new User['z'+1];
    static final char BLOCKED='X';
    static final char BOSS='B';
    static  StringTokenizer getToken(String s){
        return new StringTokenizer(s," ");
    }

    static int calculate(int bossHP){
        int result=0;
        int lastHP=bossHP;
        int prevTime=0;
        int stackedDPS=0;

        Arrays.sort(USER_INFO,(o1, o2) -> o1.time - o2.time);

        for(int i=0;i<USER_INFO.length;i++){
            User user=USER_INFO[i];
            int timeGap=user.time-prevTime;

            if(user.dps==0) continue;

            lastHP-=timeGap*stackedDPS;

            if(lastHP<=0)
                break;

            stackedDPS += user.dps;
            prevTime = user.time;
            result++;
        }

        return result;
    }
    static boolean isUser(char c){
        return c>='a' && c<='z';
    }
    public static int play(Loc bossLoc,int bossHP){
        Queue<Loc> q=new LinkedList<>();
        int[] di={1,-1,0,0};
        int[] dj={0,0,-1,1};

        BOARD[bossLoc.i][bossLoc.j]=BLOCKED;
        q.offer(bossLoc);

        while(!q.isEmpty()){
            Loc cLoc=q.poll();
            int cTime=cLoc.time;

            for(int l=0;l<di.length;l++){
                int I=di[l]+cLoc.i;
                int J=dj[l]+cLoc.j;

                if(I>=0 && I<N && J>=0 && J<M) {
                    char unit = BOARD[I][J];

                    if (unit != BLOCKED) {
                        if (isUser(unit))
                            USER_INFO[unit].time = cTime + 1;

                        BOARD[I][J] = BLOCKED;
                        q.offer(new Loc(I, J, cTime + 1));
                    }
                }
            }
        }

        return calculate(bossHP);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s=getToken(br.readLine());

        N=Integer.parseInt(s.nextToken());
        M=Integer.parseInt(s.nextToken());
        int users=Integer.parseInt(s.nextToken());
        Loc bossLoc=new Loc(0,0,0);

        BOARD =new char[N][M];

        for(int i=0;i<USER_INFO.length;i++) USER_INFO[i]=new User(0);

        for(int i=0;i<N;i++) {
            String row=br.readLine();
            for (int j = 0; j < M; j++) {
                BOARD[i][j]=row.charAt(j);

                if(BOARD[i][j]==BOSS)
                    bossLoc=new Loc(i,j,0);
            }
        }

        for(int i=0;i<users;i++){
            StringTokenizer ss=getToken(br.readLine());
            char usr=ss.nextToken().charAt(0);
            int dps=Integer.parseInt(ss.nextToken());

            USER_INFO[usr]=new User(dps);
        }

        int bossHP=Integer.parseInt(br.readLine());

        System.out.println(play(bossLoc,bossHP));
    }
}

class User{
    int time=0;
    int dps;

    User(int d){
        dps=d;
    }
}
class Loc {
    int i;
    int j;
    int time;

    Loc(int ii, int jj, int tt) {
        i = ii;
        j = jj;
        time = tt;
    }
}