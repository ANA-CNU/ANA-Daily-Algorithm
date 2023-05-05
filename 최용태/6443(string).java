import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static void printAll(int[] ana,char[] print,int n){
        if(n==print.length){
            IntStream.range(0,print.length).forEach(i->sb.append(print[i]));
            sb.append("\n");
            return;
        }else{
            for(int i='a';i<'z'+1;i++){
                if(ana[i]>0) {
                    ana[i]--;
                    print[n]=(char)i;
                    printAll(ana, print, n + 1);
                    ana[i]++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String src=br.readLine();
            int [] ana=new int['z'+1];
            IntStream.range(0,src.length()).forEach(idx->ana[src.charAt(idx)]++);
            printAll(ana,new char[src.length()],0);
        }


        System.out.println(sb);
    }
}
