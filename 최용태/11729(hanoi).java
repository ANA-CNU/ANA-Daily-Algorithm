import java.util.*;
import java.io.*;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb=new StringBuilder();
    static int counted=0;
    public static void hanoi(int num, int from, int to, int end) throws IOException {
        if(num==1){
            sb.append(from).append(" ").append(end).append("\n");
            counted++;
        }else{
            hanoi(num-1,from,end,to);
           sb.append(from).append(" ").append(end).append("\n");
            counted++;
            hanoi(num-1,to,from,end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hanoi(Integer.parseInt(br.readLine()),1,2,3);
        System.out.println(counted+"\n"+sb);
    }
}
