import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static ArrayList<ArrayList<Integer>> relationGraph=new ArrayList<>();
    static ArrayList<Integer> relationPrice=new ArrayList<>();
    static int[] friends;
    static boolean[] isRelated;

    public static int getMinPriceOfRelation(int start){
        Queue<Integer> q=new LinkedList<>();
        int minValue=friends[start];
        q.offer(start);

        while(!q.isEmpty()){
            int friend=q.poll();
            for(int i=0;i<relationGraph.get(friend).size();i++){
                int target=relationGraph.get(friend).get(i);
                if(!isRelated[target]){
                    q.offer(target);
                    minValue=Math.min(minValue,friends[target]);
                    isRelated[target]=true;
                }
            }
        }
        return minValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        StringTokenizer money=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(s.nextToken());
        int M=Integer.parseInt(s.nextToken());
        int K=Integer.parseInt(s.nextToken());

        long ans=0;

        friends=new int[N+1];
        isRelated=new boolean[N+1];

        IntStream.range(1,N+1).forEach(i->friends[i]=Integer.parseInt(money.nextToken()));
        IntStream.range(0,N+1).forEach(i->relationGraph.add(new ArrayList<>()));

        for(int i=0;i<M;i++){
            StringTokenizer ss=new StringTokenizer(br.readLine()," ");
            int f=Integer.parseInt(ss.nextToken());
            int e=Integer.parseInt(ss.nextToken());
            relationGraph.get(f).add(e);
            relationGraph.get(e).add(f);
        }

        IntStream.range(1,N+1).forEach(i->{
            if(!isRelated[i])
                relationPrice.add(getMinPriceOfRelation(i));
        });

        Collections.sort(relationPrice);

        for (int required : relationPrice) {
            K -= required;
            if (K < 0) {
                ans = -1;
                break;
            }
            ans += required;
        }

        if(ans==-1){
            System.out.println("Oh no");
        }else{
            System.out.println(ans);
        }
    }
}
