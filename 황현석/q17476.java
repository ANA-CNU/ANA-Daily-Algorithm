import java.io.*;
import java.util.StringTokenizer;

class Node {
  long max, min = Long.MAX_VALUE, sum;
  
  public void setValue (int value) {
    sum = max = min = value;
  }
  
  public static Node makeNode (Node res, Node left, Node right) {
    res.max = Math.max(left.max, right.max);
    res.min = Math.min(left.min, right.min);
    
    res.sum = left.sum + right.sum;
    
    return res;
  }
}

class Seg {
  
  private Node[] tree;
  private long[] lazy;
  
  public int start = 1;
  Seg (int[] arr) {
    while(start < arr.length) start <<= 1;
    
    tree = new Node[start << 1];
    lazy = new long[start << 1];
  
    for (int i=0;i<tree.length;i++) tree[i] = new Node();
    
    for (int i=0;i<arr.length;i++) {
      tree[i + start].setValue(arr[i]);
    }
    
    for (int i=start >> 1; i != 0; i>>=1) {
      for (int j=i;j < i << 1 ; j++) {
        Node.makeNode(tree[j], tree[j << 1], tree[j << 1 | 1]);
      }
    }
  }
  
  public void addUpdate(int node, int s, int e, int left, int right, int value) {
    if (lazy[node] != 0) propagate(node, left, right);
    
    if (e < left || right < s) return;
    
    if (s <= left && right <= e) {
      lazy[node] += value;
      propagate(node, left, right);
      return;
    }
    
    int mid = left + right >> 1;
    
    addUpdate(node << 1, s, e, left, mid, value);
    addUpdate(node << 1 | 1, s, e, mid+1, right, value);
    
    Node.makeNode(tree[node], tree[node << 1], tree[node << 1 | 1]);
  }
  
  public long addQuery (int node, int s, int e, int left, int right) {
    if (lazy[node] != 0) propagate(node, left, right);
    if (e < left || right < s) return 0;
    
    if (s <= left && right <=e ) return tree[node].sum;
    
    int mid = left + right >> 1;
    return addQuery(node << 1, s, e, left, mid)
        + addQuery(node << 1 | 1, s, e, mid+1, right);
  }
  
  public void sqrtUpdate(int node , int s, int e, int left, int right) {
    if (lazy[node] != 0) propagate(node, left, right);
  
    if (e < left || right < s) return;
    
    if (s <= left && right <= e) {
      update(node, left, right);
      return;
    }
    
    int mid = left + right >> 1;
    sqrtUpdate(node << 1, s, e, left, mid);
    sqrtUpdate(node << 1 | 1, s, e, mid+1, right);
    
    Node.makeNode(tree[node], tree[node << 1], tree[node << 1 | 1]);
  }
  
  private void update (int node, int left, int right) {
    if (lazy[node] != 0) propagate(node, left, right);
    
    long mn = minus(tree[node].min);
    long mx = minus(tree[node].max);
    
    if (mn == mx) {
      lazy[node] += mn;
      propagate(node, left, right);
    } else {
      int mid = left + right >> 1;
      update(node << 1, left, mid);
      update(node << 1 | 1, mid+1, right);
      
      Node.makeNode(tree[node], tree[node << 1], tree[node << 1 | 1]);
    }
  }
  
  private void propagate (int node, int left, int right) {
    tree[node].min += lazy[node];
    tree[node].max += lazy[node];
    
    tree[node].sum += lazy[node] * (right - left + 1);
    
    if (node < start) {
      lazy[node << 1] += lazy[node];
      lazy[node << 1 | 1] += lazy[node];
    }
    
    lazy[node] = 0;
  }
  
  private long minus (long value) {
    long goal = (long) Math.sqrt(value);
    return goal - value;
  }
  
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int[] arr = new int[N];
    
    for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
    
    int Q = Integer.parseInt(br.readLine());
    
    Seg tree = new Seg(arr);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while(Q-->0) {
      st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int left = Integer.parseInt(st.nextToken()), right = Integer.parseInt(st.nextToken());
      
      if (M == 1) {
        int value = Integer.parseInt(st.nextToken());
        tree.addUpdate(1, left, right, 1, tree.start, value);
      } else if (M == 2) {
        tree.sqrtUpdate(1, left, right, 1, tree.start);
      } else {
        bw.write(tree.addQuery(1, left, right, 1, tree.start)+"\n");
      }
    }
    bw.flush();
    
  }
}
