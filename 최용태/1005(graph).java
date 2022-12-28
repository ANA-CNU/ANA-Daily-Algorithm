import java.io.*;
import java.util.*;

public class Main {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph;
    static int[] valueOfNode;
    static int[] linkOfNode;

    public static ArrayList<ArrayList<Integer>> graphInit(int size){
        ArrayList<ArrayList<Integer>> tmp=new ArrayList<>();
        for(int i=0;i<size+1;i++) tmp.add(new ArrayList<>());
        return tmp;
    }

    public static int[] valueInit(int size) throws IOException {
        StringTokenizer n=new StringTokenizer(br.readLine()," ");
        int[] tmp=new int[size+1];
        for(int i=1;i<size+1;i++) tmp[i]=Integer.parseInt(n.nextToken());
        return tmp;
    }

    public static long search(int size,int end){
        long[] total = Arrays.stream(valueOfNode.clone()).mapToLong(i -> i).toArray();
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<size+1;i++) if(linkOfNode[i]==0) q.offer(i);

        while(!q.isEmpty()){
            int current=q.poll();
            for(int i=0;i<graph.get(current).size();i++){
                int target=graph.get(current).get(i);
                total[target]=Math.max(total[target],valueOfNode[target]+total[current]);
                if(--linkOfNode[target]==0) q.offer(target);
            }
        }
        return total[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        for(int x=0;x<T;x++){
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int N=Integer.parseInt(s.nextToken());
            int M=Integer.parseInt(s.nextToken());
            valueOfNode=valueInit(N);
            graph=graphInit(N);
            linkOfNode=new int[N+1];
            for(int i=0;i<M;i++){
                StringTokenizer ss=new StringTokenizer(br.readLine()," ");
                int from=Integer.parseInt(ss.nextToken());
                int to=Integer.parseInt(ss.nextToken());
                graph.get(from).add(to);
                linkOfNode[to]++;
            }

            int endStructure=Integer.parseInt(br.readLine());
            bw.write(search(N,endStructure)+"\n");
        }
        bw.flush();
    }
}
