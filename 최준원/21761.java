import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long>[] ka=new PriorityQueue[5];
        for(int i=0; i<4; i++) ka[i]=new PriorityQueue<>(Collections.reverseOrder());
        String[] s = bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
        long[] k=new long[4];
        s = bf.readLine().split(" ");
        for(int i=0; i<4; i++) {
            k[i]=Long.parseLong(s[i]);
        }
        for(int i=0; i<a; i++){
            s = bf.readLine().split(" ");
            ka[s[0].charAt(0)-'A'].add(Long.parseLong(s[1]));
        }
        for(int i=0; i<4; i++) ka[i].add(0L);
        while(b-->0){
            long[][] tmp=new long[4][2];
            for(int i=0; i<4; i++){
                tmp[i][0]=i; tmp[i][1]=k[i];
            }
            Arrays.sort(tmp,(o1, o2) -> o1[1]*ka[(int)o2[0]].peek()>o2[1]*ka[(int)o1[0]].peek()?1:-1);
            int x=(int)tmp[0][0];
            k[x]+=ka[x].peek();
            sb.append((char)(x+'A')).append(" ").append(ka[x].poll()).append("\n");
        }
        System.out.println(sb);
    }
}
