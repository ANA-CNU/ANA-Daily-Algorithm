import java.io.*;
import java.util.*;

class Pair {
  int loc, value;
  Pair (int loc, int value ) {
    this.loc = loc;
    this.value = value;
  }
}

class Triple {
  int n1, n2, value;
  Triple (int n1, int n2) {
    this.n1 = n1;
    this.n2 = n2;
  }
}

public class Main {
  public static int mki () {
    return Integer.parseInt(st.nextToken());
  }
  public static StringTokenizer st;
  public static ArrayList<ArrayList<Pair>> load;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    int N = mki(), M = mki(), K = mki(), Q = mki();
    
    load = new ArrayList<>(N+1);
    for (int i=0;i<=N;i++) load.add(new ArrayList<>());
    
    ArrayList<Triple> loads = new ArrayList<>();
    
    for (int i=0;i<M;i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = mki(), n2 = mki(), dist = mki();
      load.get(n1).add(new Pair(n2, dist));
      load.get(n2).add(new Pair(n1, dist));
      
      loads.add(new Triple(n1, n2));
    }
  
    int[] dp = new int[N+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.value, o2.value);
      }
    });
    
    
    for (int i=0;i<K;i++) {
      int node = Integer.parseInt(br.readLine());
      pq.offer(new Pair(node, 0));
      dp[node] = 0;
    }
    
    while(!pq.isEmpty()) {
      Pair now = pq.poll();
      if (now.value != dp[now.loc]) continue;
      
      for (Pair go : load.get(now.loc)) {
        if (dp[go.loc] > now.value + go.value) {
          dp[go.loc] = now.value + go.value;
          pq.offer(new Pair(go.loc, dp[go.loc]));
        }
      }
    }
    
    int[] left = new int[Q], right = new int[Q];
    
    Pair[] queries = new Pair[Q];
    
    for (Triple t : loads)
      t.value = Math.min(dp[t.n1], dp[t.n2]);
    
    loads.sort(new Comparator<Triple>() {
      @Override
      public int compare(Triple o1, Triple o2) {
        return Integer.compare(o2.value, o1.value);
      }
    });
    
    parent = new int[N+1];
    for (int i=0;i<parent.length;i++) parent[i] = i;
    
    ArrayList<Triple> real = new ArrayList<>(M+1);
    for (int i=0;i<M;i++) {
      if (find(loads.get(i).n1) != find(loads.get(i).n2)) {
        union(loads.get(i).n1, loads.get(i).n2);
        real.add(loads.get(i));
      }
    }
  
    
    loads = real;
    Arrays.fill(right, loads.size()+1);
    
    for (int i=0;i<Q;i++) {
      st = new StringTokenizer(br.readLine());
      queries[i] = new Pair(mki(), mki());
    }
    
    ArrayList<ArrayList<Integer>> mid = new ArrayList<>(M+1);
    for (int i=0;i<=M;i++) mid.add(new ArrayList<>());
    
    
    while(true) {
      boolean stop = true;
      for (int i=0;i<Q;i++) {
        if (left[i] + 1 == right[i]) continue;
        stop = false;
        mid.get(left[i] + right[i] >> 1).add(i);
      }
      
      if (stop) break;
      
      for (int i=0;i<parent.length;i++) parent[i] = i;
      
      for (int i=0;i<loads.size();i++) {
        union(loads.get(i).n1, loads.get(i).n2);
        
        for (int idx : mid.get(i+1)) {
          if (find(queries[idx].loc) != find(queries[idx].value)) {
            left[idx] = i+1;
          } else {
            right[idx] = i+1;
          }
        }
        
        mid.get(i+1).clear();
      }
    }
  
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i=0;i<Q;i++) {
      bw.write(loads.get(right[i]-1).value+"\n");
    }
    bw.flush();
  }
  public static int[] parent;
  
  public static int find (int node) {
    if (parent[node] == node) return node;
    return parent[node] = find(parent[node]);
  }
  
  public static void union (int n1, int n2) {
    parent[find(n1)] = find(n2);
  }
}
