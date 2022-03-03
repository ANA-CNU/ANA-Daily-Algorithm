import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
       StringBuffer sb = new StringBuffer();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       while(true) {
           String s = br.readLine();
           StringTokenizer st = new StringTokenizer(s, " ");
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());

           if(a == 0 && b == 0 && c == 0){
               break;
           }

           if(a*a + b*b == c*c){
               sb.append("right").append('\n');
           }else if(a*a + c*c == b*b){
               sb.append("right").append('\n');
           }else if(b*b + c*c == a*a){
               sb.append("right").append('\n');
           }else{
               sb.append("wrong").append('\n');
           }
       }
        System.out.println(sb);
    }
}
