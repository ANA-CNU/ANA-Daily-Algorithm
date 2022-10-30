import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meteor {
  int left, right, amount;
  Meteor (int left, int right, int amount) {
    this.left = left;
    this.right = right;
    this.amount = amount;
  }
  
}

public class Main {
  public static StringTokenizer st;
  public static int N, M;
  public static int mki() {
    return Integer.parseInt(st.nextToken());
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = mki(); M = mki();
  
    ArrayList<ArrayList<Integer>> having = new ArrayList<>(N+1);
    for (int i=0;i<=N;i++) having.add(new ArrayList<>());
    
    st = new StringTokenizer(br.readLine());
    for (int i=1;i<=M;i++) {
      having.get(mki()).add(i);
    }
    
    int[] goal = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for (int i=1;i<=N;i++) goal[i] = mki();
    
    int queries = Integer.parseInt(br.readLine());
    ArrayList<Meteor> meteors = new ArrayList<>(queries);
    for (int i=0;i<queries;i++) {
      st = new StringTokenizer(br.readLine());
      meteors.add(new Meteor(mki(), mki(), mki()));
    }
    
    while(start < M) start <<= 1;
    tree = new long[start << 1];
    
    ArrayList<ArrayList<Integer>> mid = new ArrayList<>(queries+1);
    for (int i=0;i<=queries+1;i++) mid.add(new ArrayList<>());
    
    int[] left = new int[N+1], right = new int[N+1];
    Arrays.fill(right, queries+1);
    
    while(true) {
      for (ArrayList<Integer> m : mid) m.clear();
      
      boolean b = true;
      for (int i=1;i<=N;i++) {
        if (left[i] + 1 == right[i]) continue;
        mid.get(left[i] + right[i] >> 1).add(i);
        b = false;
      }
      
      if (b) break;
      
      Arrays.fill(tree, 0);
      for (int i=0;i<meteors.size();i++) {
        query(meteors.get(i));
        
        C: for (int idx : mid.get(i+1)) {
          long now = 0;
          for (int range : having.get(idx)) {
            now += getValue(range);
            if (goal[idx] <= now) {
              right[idx] = i+1;
              continue C;
            }
          }
          
          left[idx] = i+1;
        }
      }
  
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i=1;i<=N;i++) {
      if (right[i] == queries+1) {
        bw.write("NIE\n");
      } else {
        bw.write(right[i]+"\n");
      }
    }
    bw.flush();
  }
  
  public static long[] tree;
  public static int start = 1;
  public static void query (Meteor meteor) {
    if (meteor.left <= meteor.right) {
      update(1, meteor.left, meteor.right, 1, start, meteor.amount);
    } else {
      update(1, meteor.left, M, 1, start, meteor.amount);
      update(1, 1, meteor.right, 1, start, meteor.amount);
    }
  }
  public static void update (int node, int s, int e, int left, int right, long value) {
    if (e < left || right < s) return;
    
    if (s <= left && right <= e) {
      tree[node] += value;
      return;
    }
    
    int mid = left + right >> 1;
    
    update(node << 1, s, e, left, mid, value);
    update(node << 1 | 1, s, e, mid+1, right, value);
  }
  
  public static long getValue (int idx) {
    long ans = 0;
    for (int i=idx+start-1;i!=0;i>>=1) {
      ans += tree[i];
    }
    return ans;
  }
}
