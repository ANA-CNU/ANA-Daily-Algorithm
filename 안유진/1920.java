import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();

        int firstN = Integer.parseInt(br.readLine());

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s," ");
        for(int i = 0; i<firstN; i++){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        int secondN = Integer.parseInt(br.readLine());

        s = br.readLine();
        StringTokenizer token  = new StringTokenizer(s, " ");

        for(int i = 0; i<secondN; i++){
            int comp = Integer.parseInt(token.nextToken());
            if(set.contains(comp)){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}
