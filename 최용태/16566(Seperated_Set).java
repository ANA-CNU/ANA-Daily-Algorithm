import java.util.*;
import java.io.*;


public class Main {

    public static StringTokenizer getToken(String s) {
        return new StringTokenizer(s, " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        StringTokenizer s = getToken(br.readLine());
        StringTokenizer ss = getToken(br.readLine());
        StringTokenizer sss = getToken(br.readLine());

        int N = Integer.parseInt(s.nextToken());
        int M = Integer.parseInt(s.nextToken());
        int K = Integer.parseInt(s.nextToken());

        boolean[] originalPack = new boolean[N + 1+1]; // 카드의 존재 유무
        int[] list = new int[N + 1+1];

        for (int i = 0; i < M; i++) {
            originalPack[Integer.parseInt(ss.nextToken())] = true;
        } // true==카드가 존재함


        for(int i=N;i>0;i--){
            if(!originalPack[i+1])
                list[i]=list[i+1];
            else
                list[i]=i+1;
        }

        for(int i=0;i<K;i++){
            int pick=Integer.parseInt(sss.nextToken());
            int c=list[pick];

            while(!originalPack[c]) c=list[c];
            list[pick]=list[c];
            sb.append(c).append("\n");
            originalPack[c]=false;
        }

        System.out.println(sb);
    }
}