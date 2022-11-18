import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Box {
  int weight, partner, limit, idx;
  Box (int weight, int partner, int limit, int idx) {
    this.weight = weight;
    this.partner = partner;
    this.limit = limit;
    this.idx = idx;
  }
  
}


public class Main {
  public static int MAX = 200002;
  public static int[] limit = new int[MAX];
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()  );
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    for (int i=0;i<M;i++) {
      limit[i+1] = Integer.parseInt(st.nextToken());
    }
  
    ArrayList<Integer> arr = new ArrayList<>(K);
    
    st = new StringTokenizer(br.readLine());
    for (int i=0;i<K;i++) arr.add(Integer.parseInt(st.nextToken()));
    
    PriorityQueue<Box>[] pq = new PriorityQueue[N+1];
    
    for (int i=0;i<pq.length;i++) pq[i] = new PriorityQueue<>(new Comparator<Box>() {
      @Override
      public int compare(Box o1, Box o2) {
        return Integer.compare(o1.weight, o2.weight);
      }
    });
  
    for(int i=0;i<Q;i++) {
      st = new StringTokenizer(br.readLine());
      int k1 = Integer.parseInt(st.nextToken()), k2 = Integer.parseInt(st.nextToken());
      int lim = limit[Integer.parseInt(st.nextToken())];
      
      pq[k1].add(new Box(lim / 2, k2, lim, i));
      if (k1 == k2) continue;
      pq[k2].add(new Box(lim / 2, k1, lim, i));
    }
    
    boolean up = false;
    int[] tall = new int[N+1];
    boolean[] used = new boolean[Q];
  
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int riding = 0;
  
    for (int i=0;i<arr.size();i++) {
      int person = arr.get(i);
      tall[person] += (up ? 2 : 1);
      up = false;
      
      while(!pq[person].isEmpty()) {
        if (used[pq[person].peek().idx]) {
          pq[person].poll();
          continue;
        }
        if (tall[person] < pq[person].peek().weight) break;
        
        Box now = pq[person].poll();
        if (tall[person] + tall[now.partner] >= now.limit) {
          if (used[now.idx]) continue;
          riding++;
          used[now.idx] = up = true;
        } else {
          now.weight = tall[person] + (now.limit - tall[person] - tall[now.partner]) / 2;
          if (now.weight == tall[person]) now.weight++;
          pq[person].offer(now);
          if (now.partner != person)
            pq[now.partner].offer(new Box(tall[now.partner] + (now.limit - tall[person] - tall[now.partner]) / 2
              , person, now.limit, now.idx));
        }
      }
      
      if (i == 0) up = false;
      bw.write(riding+"\n");
    }
    bw.flush();
  }
}
