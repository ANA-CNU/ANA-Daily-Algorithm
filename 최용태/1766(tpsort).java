import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<Integer>> NODE_INFO=new ArrayList<>();
    static int[] TABLE;

    public static void sort(){
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Integer> q=new PriorityQueue<>();

        for(int i=1;i<TABLE.length;i++){
            if(TABLE[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int currentNode=q.poll();
            sb.append(currentNode).append(" ");

            for(int i=0;i<NODE_INFO.get(currentNode).size();i++) {
                int targetNode=NODE_INFO.get(currentNode).get(i);
                TABLE[targetNode]--;
                if(TABLE[targetNode]==0){
                    q.offer(targetNode);
                }
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(s.nextToken());
        int M=Integer.parseInt(s.nextToken());
        TABLE=new int[N+1];

        for(int i=0;i<N+1;i++){
            NODE_INFO.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            StringTokenizer ss=new StringTokenizer(br.readLine()," ");
            int f=Integer.parseInt(ss.nextToken());
            int e=Integer.parseInt(ss.nextToken());

            NODE_INFO.get(f).add(e); // f가 e를 지목한다.
            TABLE[e]++;
        }

        sort();
    }
}
