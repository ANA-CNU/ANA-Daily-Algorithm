import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    static boolean check(String[] src,int start){
        String cmp=src[start];
        int cmpLen=cmp.length();

        for(int i=start+1;i<src.length;i++){
            int strLen=src[i].length();
            boolean fail=true;
            if(strLen<=cmpLen) continue;

            for(int j=0;j<cmpLen;j++){
                if(src[i].charAt(j)!=cmp.charAt(j)){
                    fail=false;
                    break;
                }
            }

            if(fail) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int t=0;t<T;t++){
            int N=Integer.parseInt(br.readLine());
            String[] strArr=new String[N];
            String ans="YES";
            for(int i=0;i<N;i++) strArr[i]=br.readLine();

            Arrays.sort(strArr,(o1,o2)->o1.length()-o2.length());

            for(int i=0;i<N;i++) if(!check(strArr,i)) ans="NO";

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
