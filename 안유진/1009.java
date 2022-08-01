import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a%=10;


            if(a == 2 || a == 3 || a == 7 || a == 8){
                int mod = b % 4;
                if(mod == 0){
                    sb.append((int)Math.pow(a, 4) % 10).append('\n');
                }else{
                    sb.append((int)Math.pow(a, mod)% 10).append('\n');
                }
            }else if(a == 5 || a == 6 || a == 1){
                sb.append(a%10).append('\n');

            }else if(a == 4 || a == 9){
                if(b % 2 == 0){
                    if(a == 4){
                        sb.append(6).append('\n');
                    }else{
                        sb.append(1).append('\n');
                    }
                }else{
                    if(a == 4){
                        sb.append(4).append('\n');
                    }else{
                        sb.append(9).append('\n');
                    }
                }
            }else if(a == 0){
                sb.append(10).append('\n');
            }
        }
        System.out.println(sb);
    }
}
