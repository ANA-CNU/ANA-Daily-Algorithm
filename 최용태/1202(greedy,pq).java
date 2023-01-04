import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(s.nextToken());
        int K=Integer.parseInt(s.nextToken());
        PriorityQueue<Item> weightPQ=new PriorityQueue<>(new WeightComparator());
        PriorityQueue<Item> valuePQ=new PriorityQueue<>(new ValueComparator());
        int[] bag=new int[K];
        long ans=0;

        for(int i=0;i<N;i++){
            StringTokenizer ss=new StringTokenizer(br.readLine()," ");
            int w=Integer.parseInt(ss.nextToken());
            int v=Integer.parseInt(ss.nextToken());
            weightPQ.offer(new Item(w,v));
        }

        for(int i=0;i<K;i++) {
            bag[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        for(int i=0;i<K;i++) {
            int weightLimit=bag[i];
            while (!weightPQ.isEmpty() && weightPQ.peek().w <= weightLimit) {
                valuePQ.offer(weightPQ.poll());
            }
            if(valuePQ.isEmpty()) continue;
            ans+=valuePQ.poll().v;
        }

        System.out.println(ans);
    }
}

class WeightComparator implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2) {
        return o1.w-o2.w;
    }
}

class ValueComparator implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2) {
        return o2.v-o1.v;
    }
}

class Item{
    int w;
    int v;

    Item(int W,int V){
        w=W;
        v=V;
    }
}
