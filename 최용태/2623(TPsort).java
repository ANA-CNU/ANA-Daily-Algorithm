import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> src=new ArrayList<>();
    static int[] LINKED_INFO;

    public static void setInfo(ArrayList<Integer> info){
        for(int i=0;i<info.size()-1;i++){
            int f=info.get(i);
            int t=info.get(i+1);
            src.get(f).add(t);
            LINKED_INFO[t]++;
        }
    }

    public static StringBuilder search(){
        Queue<Integer> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        int size=LINKED_INFO.length-1;

        for(int i=size;i>0;i--){
            if(LINKED_INFO[i]==0){
                q.offer(i);
                sb.append(i+"\n");
            }
        }

        while(!q.isEmpty()){
            int current=q.poll();
            for(int i=0;i<src.get(current).size();i++){
                int target=src.get(current).get(i);
                if(--LINKED_INFO[target]==0){
                    q.offer(target);
                    sb.append(target+"\n");
                }
            }
        }

        for(int i=size;i>0;i--){
            if(LINKED_INFO[i]!=0){
                return new StringBuilder().append(0);
            }
        }

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(s.nextToken());
        int M=Integer.parseInt(s.nextToken());

        LINKED_INFO=new int[N+1];

        for(int i=0;i<N+1;i++) src.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            StringTokenizer x=new StringTokenizer(br.readLine()," ");
            int n=Integer.parseInt(x.nextToken());
            ArrayList<Integer> info=new ArrayList<>();
            for(int j=0;j<n;j++) info.add(Integer.parseInt(x.nextToken()));
            setInfo(info);
        }

        System.out.println(search());
    }
}