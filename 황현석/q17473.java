import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
  int haveBit, max;
  int allBit = -1;
  
  public void setValue (int value) {
    haveBit = max = value;
    allBit &= value;
  }
  
  public static void makeNode (Node res, Node left, Node right) {
    res.max = Math.max(left.max, right.max);
    res.haveBit = left.haveBit | right.haveBit;
    res.allBit = left.allBit & right.allBit;
  }
}

class Seg {
  private final Node[] tree;
  private final int[] orLazy, andLazy;
  public static final int FULL = -1;
  
  public int start = 1;
  
  Seg (int[] arr) {
    while(start < arr.length) start<<=1;
    
    tree = new Node[start << 1];
    orLazy = new int[start << 1];
    andLazy = new int[start << 1];
  
    Arrays.fill(andLazy, FULL);
    
    for (int i=0;i<tree.length;i++) tree[i] = new Node();
    
    for (int i=0;i<arr.length;i++) tree[i + start].setValue(arr[i]);
    
    for (int i= start >> 1; i!=0;i >>= 1) {
      for (int j=i;j< i << 1;j++) {
        Node.makeNode(tree[j], tree[j << 1], tree[j << 1 | 1]);
      }
    }
  }
  
  private boolean tagCondition (Node node, int value) {
    //점점 비트의 모양이 같아지는 것을 이용 할 순 없을까? 그렇지 않으면, 최적화가 되질 않아..
    int sameBit = ~node.haveBit | node.allBit;
    return (sameBit & ~value) == ~value;
  }
  private boolean tagCondition2 (Node node, int value) {
    //점점 비트의 모양이 같아지는 것을 이용 할 순 없을까? 그렇지 않으면, 최적화가 되질 않아..
    int sameBit = ~node.haveBit | node.allBit;
    return (sameBit & value) == value;
  }
  
  public void updateAND (int node, int s, int e, int left, int right, int value) {
    if (orLazy[node] != 0 || andLazy[node] != FULL) propagate(node);
    if (e < left || right < s || (tree[node].haveBit & value) == tree[node].haveBit) return;
    
    if (s <= left && right <= e && (tagCondition(tree[node], value))) {
      andLazy[node] &= value;
      propagate(node);
      return;
    }
    
    int mid = left + right >> 1;
  
    updateAND(node << 1, s, e, left, mid, value);
    updateAND(node << 1 | 1, s, e, mid+1, right, value);
    Node.makeNode(tree[node], tree[node << 1], tree[node << 1 | 1]);
  }
  
  public void updateOR (int node, int s, int e, int left, int right, int value) {
    if (orLazy[node] != 0 || andLazy[node] != FULL) propagate(node);
    if (e < left || right < s || (tree[node].allBit & value) == value) return;
  
    if (s <= left && right <= e && tagCondition2(tree[node], value)) {
      orLazy[node] |= value;
      propagate(node);
      return;
    }
  
    int mid = left + right >> 1;
    
    updateOR(node << 1, s, e, left, mid, value);
    updateOR(node << 1 | 1, s, e, mid+1, right, value);
    
    Node.makeNode(tree[node], tree[node << 1], tree[node << 1 | 1]);
  }
  
  public int queryMAX (int node, int s, int e, int left, int right) {
    if (orLazy[node] != 0 || andLazy[node] != FULL) propagate(node);
    if (e < left || right < s) return 0;
  
    if (s <= left && right <=e) {
      return tree[node].max;
    }
    
    int mid = left + right >> 1;
  
    return Math.max(queryMAX(node << 1, s, e, left, mid)
        , queryMAX(node << 1 | 1, s, e, mid+1, right));
  }
  
  private void propagate (int node) {
    tree[node].max &= andLazy[node];
    tree[node].max |= orLazy[node];
    
    tree[node].haveBit &= andLazy[node];
    tree[node].haveBit |= orLazy[node];
    
    tree[node].allBit &= andLazy[node];
    tree[node].allBit |= orLazy[node];
    
    if (node < start) {
      andLazy[node << 1] &= andLazy[node];
      andLazy[node << 1 | 1] &= andLazy[node];
      orLazy[node << 1] &= andLazy[node];
      orLazy[node << 1 | 1] &= andLazy[node];
      
      orLazy[node << 1] |= orLazy[node];
      orLazy[node << 1 | 1] |= orLazy[node];
    }
    
    andLazy[node] = FULL;
    orLazy[node] = 0;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i=0;i<arr.length;i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    int Q = Integer.parseInt(br.readLine());
    
    Seg tree = new Seg(arr);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    while(Q-->0) {
      st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int left = Integer.parseInt(st.nextToken());
      int right = Integer.parseInt(st.nextToken());
      
      if (M == 1) {
        int value = Integer.parseInt(st.nextToken());
        tree.updateAND(1, left, right, 1, tree.start, value);
      } else if (M == 2) {
        int value = Integer.parseInt(st.nextToken());
        tree.updateOR(1, left, right, 1, tree.start, value);
      } else {
        bw.write(tree.queryMAX(1, left, right, 1, tree.start)+"\n");
      }
    }
  
    
    bw.flush();
  }
}
