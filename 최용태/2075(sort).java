import java.util.*;
import java.io.*;


public class Main {
    static int MAX_VALUE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size=0;
        int[] a=new int[N];
        int maxNum=-1000000001;
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int cmp=Integer.parseInt(s.nextToken());
            if(cmp>maxNum) maxNum=cmp;
        }
        a[size++]=maxNum;
        for (int i = 1; i < N; i++) {
            StringTokenizer ss=new StringTokenizer(br.readLine()," ");
            for (int j= 0; j < N; j++) {
                int cmp = Integer.parseInt(ss.nextToken());
                if(cmp>a[0]){
                    if(size<N) a[size++]=cmp;
                    else{
                        a[0]=cmp;
                        Arrays.sort(a);
                    }
                }
            }
        }

        System.out.println(a[0]);
    }
}