import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
  int left, right;
  long weight;
  long using;
  
  Pair (int left, int right) {
    this.left = left;
    this.right= right;
    this.weight = Main.location.get(right) - Main.location.get(left);
  }
  Pair (int left, int right, long variable) {
    this(left, right);
    this.weight -= variable << 1;
    using = variable;
  }
  
  public long total () {
    return Main.location.get(right) - Main.location.get(left);
  }
}

public class Main {
  public static ArrayList<Long> location = new ArrayList<>(100001)  ;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
  
    int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
    
    for (int i=0;i<N;i++) location.add(Long.parseLong(br.readLine()));
    
    Collections.sort(location);
  
    PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Long.compare(o1.weight, o2.weight);
      }
    });
    
    boolean[] choosed = new boolean[N+1];
    int[] cLeft = new int[N], cRight = new int[N];
    for (int i=0;i<N;i++) {
      cLeft[i] = cRight[i] = i;
    }
    
    for (int i=0;i+1<location.size();i++) {
      pq.offer(new Pair(i, i+1));
    }
    
    long answer = 0;
    HashMap<String, Long> nowUsing = new HashMap<>();
    
    while(!pq.isEmpty() && K>0) {
      Pair now = pq.poll();
      
      if (choosed[now.left] || choosed[now.right]) continue;
      
      choosed[now.left] = choosed[now.right] = true;
      
      answer += now.weight;
      K--;
  
      if (now.left == 0 || now.right == N-1) continue;
      
      int left = find(now.left-1, cLeft), right = find(now.right+1, cRight);
      
      long minus = now.total() - now.using;
      minus += nowUsing.getOrDefault(left+" "+now.left, 0L);
      minus += nowUsing.getOrDefault(now.right+" "+right, 0L);
  
      union(now.left, now.right, cLeft, cRight);
  
      nowUsing.put(left+" "+right, minus);
      pq.offer(new Pair(left, right, minus));
      
      cLeft[find(now.left, cLeft)] = find(now.left-1, cLeft);
      cRight[find(now.right, cRight)] = find(now.right+1, cRight);
    }
    
    System.out.println(answer);
  }
  
  public static int find (int node, int[] parent) {
    if (parent[node] == node) return node;
    return parent[node] = find(parent[node], parent);
  }
  
  public static void union (int n1, int n2, int[] l, int[] r) {
    int p1 = find(n1, l);
    int p2 = find(n2, l);
    
    l[Math.max(p1, p2)] = Math.min(p1, p2);
    p1 = find(n1, r);
    p2 = find(n2, r);
    
    r[Math.min(p1, p2)] = Math.max(p1, p2);
  }
}
