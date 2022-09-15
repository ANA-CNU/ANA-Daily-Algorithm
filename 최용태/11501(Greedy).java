import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static long stocking(int N) throws IOException {
       long ans=0;
       Stack<Integer> s=new Stack<Integer>();
       StringTokenizer v=new StringTokenizer(br.readLine()," ");

       for(int i=0;i<N;i++){
            s.push(Integer.parseInt(v.nextToken()));
       }

       while(!s.isEmpty()){
           int current=s.pop();
           while(!s.isEmpty() && s.peek()<=current){
               ans+=current-s.pop();
           }
       }
       return ans;
   }
    public static void main(String[] args) throws IOException {
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int N=Integer.parseInt(br.readLine());

       for(int i=0;i<N;i++){
           bw.write(stocking(Integer.parseInt(br.readLine()))+"\n");
       }

       bw.flush();
    }
}