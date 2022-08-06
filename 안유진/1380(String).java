import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int count = 1;
        String s = "";

        while(true){
            s = br.readLine();
            if(s.equals("0")){
                break;
            }
            int num = Integer.parseInt(s);
            String name[] = new String[num];
            int number[] = new int[num];
            for(int i = 0; i < num; i++){
                name[i] = br.readLine();
            }
            for(int i = 0; i < num*2 - 1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int stu = Integer.parseInt(st.nextToken());
                number[stu-1]++;
            }
            for(int i = 0; i < num; i++){
                if(number[i] == 1){
                    sb.append(count).append(" "+name[i]).append('\n');
                }
            }
            count++;
        }
        System.out.println(sb);
    }
}
