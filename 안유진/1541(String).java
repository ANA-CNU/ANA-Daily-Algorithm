import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int answer = 0;
        boolean flag = false;
        while (st.hasMoreTokens()){
            int tempSum = 0;
            StringTokenizer plus = new StringTokenizer(st.nextToken(),"+");
            while (plus.hasMoreTokens()){
                tempSum += Integer.parseInt(plus.nextToken());
            }
            if(!flag){
                answer += tempSum;
                flag = true;
            }else{
                answer -= tempSum;
            }
        }
        System.out.println(answer);
    }
}
