import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int num = 0;

        while (N --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            if(st.countTokens() == 1){
                String s = st.nextToken();
                if(s.equals("all")){
                    num = (int)Math.pow(2, 21) - 1;
                }else if(s.equals("empty")){
                    num = 0;
                }
            } else {
                String s = st.nextToken();
                int temp = Integer.parseInt(st.nextToken());
                if(s.equals("add")){
                    num = num | (1 << temp);
                }else if(s.equals("remove")){
                    num = num &~ (1 << temp);
                }else if(s.equals("check")){
                    if((num & (1 << temp)) > 0){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                }else if(s.equals("toggle")){
                    num = num ^ (1 << temp);
                }
            }
        }
        System.out.println(sb);
    }
}
