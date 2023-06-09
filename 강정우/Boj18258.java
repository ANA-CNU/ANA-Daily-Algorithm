import java.io.*;
import java.util.*;
public class Boj18258 {
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer>queue=new LinkedList<>();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        int back=-1;
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String s= st.nextToken();
            if(s.equals("push")) {
                back= Integer.parseInt(st.nextToken());
                queue.add(back);
            }
            else if (s.equals("pop")) {
                if(queue.isEmpty())
                    bw.append(-1+"\n");
                else
                    bw.append(queue.poll()+"\n");
            } else if (s.equals("size")) {
                bw.append(queue.size()+"\n");
            } else if (s.equals("empty")) {
                if(queue.isEmpty())
                    bw.append(1+"\n");
                else
                    bw.append(0+"\n");
            } else if (s.equals("front")) {
                if(queue.isEmpty())
                    bw.append(-1+"\n");
                else
                    bw.append(queue.peek()+"\n");
            }else{
                if(queue.isEmpty())
                    bw.append(-1+"\n");
                else
                    bw.append(back+"\n");
            }
        }
        bw.flush();
    }
}
