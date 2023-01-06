import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        long INF = 2000000000;

        for(int t=0;t<T;t++) {
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int n=Integer.parseInt(s.nextToken());
            int N=Integer.parseInt(s.nextToken());
            int M=Integer.parseInt(s.nextToken());
            long[][] src = new long[N + 1][N + 1];
            int[] person=new int[n];

            for(int i=0;i<n;i++) person[i]=Integer.parseInt(br.readLine());

            for(int i=1;i<=N;i++){
               Arrays.fill(src[i],INF);
               src[i][i]=0;
            }


            for(int i=0;i<M;i++){
                StringTokenizer ss=new StringTokenizer(br.readLine()," ");
                int f=Integer.parseInt(ss.nextToken());
                int e=Integer.parseInt(ss.nextToken());
                int v=Integer.parseInt(ss.nextToken());
                src[f][e]=Math.min(src[f][e],v);
                src[e][f]=Math.min(src[e][f],v);
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        src[i][j] = Math.min(src[i][j], src[i][k] + src[k][j]);
                    }
                }
            }

            int ansNum=0;
            long ansValue=Long.MAX_VALUE;

            for (int i = 1; i <= N; i++) {
                long cmp=0;
                boolean flag=false;
                for (int j = 0; j < n; j++) {
                    if(src[i][person[j]]==INF) {
                        flag=true;
                        break;
                    }
                    cmp += Math.pow(src[i][person[j]], 2);
                }
                if(flag) continue;
                if(cmp<ansValue){
                    ansValue=cmp;
                    ansNum=i;
                }
            }

            bw.write(ansNum+" "+ansValue+"\n");
        }
        bw.flush();
    }
}


