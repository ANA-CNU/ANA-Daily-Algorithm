import java.io.*;
import java.util.*;

class Query {
  int left, right;
  long value;
  Query (int left, int right, long value) {
    this.left = left;
    this.right = right;
    this.value = value;
  }
}

class Seg {
  long[] tree, lazy, between;
  int start = 1;
  Seg (int size) {
    while(start < size) start <<= 1;
    
    tree = new long[start << 1];
    lazy = new long[start << 1];
    between = new long[start << 1];
  }
  
  public void clear () {
    Arrays.fill(tree, 0);
    Arrays.fill(lazy, 0);
    Arrays.fill(between, 0);
  }
  
  public boolean update (int node, int s, int e, int left, int right) {
    if (lazy[node] != 0) propagate(node, left, right);
    
    if (e < left || right < s) return false;
    
    if (s <= left && right <= e) {
      lazy[node]++;
      propagate(node, left, right);
      return true;
    }
    
    int mid = left + right >> 1;
    
    boolean l = update(node << 1, s, e, left, mid);
    boolean r = update(node << 1 | 1, s, e, mid+1, right);
    
    if (l && r) between[node]+= Main.sort.get(mid) - Main.sort.get(mid-1) - 1;
    tree[node] = tree[node << 1] + tree[node << 1 | 1] + between[node];
    return true;
  }
  
  
  public long query (int node, int s, int e, int left, int right) {
    if (e < left || right < s) return 0;
  
    if (lazy[node] != 0) propagate(node, left, right);
  
    if (s <= left && right <= e) return tree[node];
  
    int mid = left + right >> 1;
    
    return query(node << 1, s, e, left, mid)
        + query(node << 1 | 1, s, e, mid+1, right) + ((s <= mid && mid+1 <= e) ? between[node] : 0);
  }
  
  public void propagate (int node, int left, int right) {
    int dist = Main.sort.get(right-1) - Main.sort.get(left-1) + 1;
    tree[node] += lazy[node] * dist;
    
    if (left == right || node >= start) {
      lazy[node] = 0;
      return;
    }
    
    int mid = left + right >> 1;
    between[node] += (Main.sort.get(mid) - Main.sort.get(mid-1) - 1) * lazy[node];
    
    lazy[node << 1] += lazy[node];
    lazy[node << 1 | 1] += lazy[node];
    lazy[node] = 0;
  }
}

public class Main {
  public static int N, M, Q;
  public static HashMap<Integer, Integer> com = new HashMap<>();
  public static ArrayList<Integer> sort;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());
  
    HashSet<Integer> hs = new HashSet<>();
    ArrayList<Query> queries = new ArrayList<>(M);
    for (int i=0;i<M;i++) {
      st = new StringTokenizer(br.readLine());
      int left = Integer.parseInt(st.nextToken());
      int right= Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      
      queries.add(new Query(left, right, value));
      maker(left, hs); maker(right, hs);
    }
    
    queries.sort(new Comparator<Query>() {
      @Override
      public int compare(Query o1, Query o2) {
        return Long.compare(o1.value, o2.value);
      }
    });
    
    Query[] find = new Query[Q];
    
    for (int i=0;i<Q;i++) {
      st = new StringTokenizer(br.readLine());
      int left = Integer.parseInt(st.nextToken());
      int right= Integer.parseInt(st.nextToken());
      long value = Long.parseLong(st.nextToken());
      find[i] = new Query(left, right, value);
      
      maker(left, hs); maker(right, hs);
    }
    
    sort = new ArrayList<>(hs);
    Collections.sort(sort);
    for (int i=0;i<sort.size();i++) {
      com.put(sort.get(i), i+1);
    }
    
    int[] left = new int[Q], right = new int[Q];
    Arrays.fill(right, M+1);
    
    ArrayList<ArrayList<Integer>> mid = new ArrayList<>(M+1);
    for (int i=0;i<=M;i++) mid.add(new ArrayList<>());
    
    for (Query q : queries) {
      q.left = com.get(q.left);
      q.right = com.get(q.right);
    }
    
    for (int i=0;i<find.length;i++) {
      find[i].left = com.get(find[i].left);
      find[i].right = com.get(find[i].right);
    }
    
    Seg tree = new Seg(sort.size());
    
    while(true) {
      for(ArrayList<Integer> arr : mid) arr.clear();
      
      boolean stop = true;
      for (int i=0;i<Q;i++) {
        if (left[i] + 1 == right[i]) continue;
        stop = false;
        mid.get(left[i] + right[i] >> 1).add(i);
      }
      
      if (stop) break;
      
      tree.clear();
      for (int i=0;i<M;i++) {
        tree.update(1, queries.get(i).left, queries.get(i).right, 1, tree.start);
  
        for (int idx : mid.get(i+1)) {
          long count = tree.query(1, find[idx].left, find[idx].right, 1, tree.start);
          
          if (find[idx].value <= count) {
            right[idx] = i+1;
          } else {
            left[idx] = i+1;
          }
        }
      }
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i=0;i<find.length;i++) {
      bw.write(queries.get(right[i]-1).value+"\n");
    }
    bw.flush();
  }
  
  public static void maker(int value, HashSet<Integer> hs) {
    hs.add(value);
  }
}
