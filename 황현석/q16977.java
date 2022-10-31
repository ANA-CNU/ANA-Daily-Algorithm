import java.io.*;
import java.util.*;

class Node {
  int sum = 1;
  int left, right, answer;
  Node (int v) {
    this.left = this.right = this.answer = v;
  }
  
  public static Node mk (Node res, Node l, Node r) {
    res.sum = l.sum + r.sum;
    res.left = l.left;
    if (l.left == l.sum)
      res.left += r.left;
    res.right = r.right;
    if (r.right == r.sum)
      res.right += l.right;
    
    res.answer = Math.max(l.answer, r.answer);
    res.answer = Math.max(res.answer, l.right + r.left);
    
    return res;
  }
}

class Seg {
  Node[] tree;
  int start = 1, size;
  Seg (int size) {
    while(start < size) start <<= 1;
    tree = new Node[start << 1];
    
    this.size = size;
    
    for (int i=0;i<tree.length;i++) tree[i] = new Node(1);
    
    for (int i=start>>1;i!=0;i>>=1) {
      for (int j=i;j < i<<1;j++) {
        Node.mk(tree[j], tree[j << 1], tree[j << 1 | 1]);
      }
    }
  }
  
  public void update (int idx) {
    idx = idx + start - 1;
    tree[idx].left = tree[idx].right = tree[idx].answer = 0;
    
    while((idx >>= 1) != 0) {
      Node.mk(tree[idx], tree[idx << 1], tree[idx << 1 | 1]);
    }
  }
  public void clear () {
    for (int i=start;i<start+size;i++) {
      tree[i].left = tree[i].right = tree[i].answer = 1;
    }
    
    for (int i=start>>1;i!=0;i>>=1) {
      for (int j=i;j < i<<1;j++) {
        Node.mk(tree[j], tree[j << 1], tree[j << 1 | 1]);
      }
    }
    
  }
  
  public Node query (int node, int s, int e, int left, int right) {
    if (e < left || right < s) return new Node(0);
    
    if (s <= left && right <= e) {
      return tree[node];
    }
    
    int mid = left + right >> 1;
    return Node.mk(new Node(0), query(node << 1, s, e, left, mid)
        , query(node << 1 | 1, s, e, mid+1, right));
  }
}

class Query {
  int left, right, width;
  
  Query (int left, int right, int width) {
    this.left = left;
    this.right = right;
    this.width = width;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
  
    HashSet<Integer> hs = new HashSet<>();
    int[] height = new int[N] ;
    
    hs.add(0);
    StringTokenizer st= new StringTokenizer(br.readLine());
    for (int i=0;i<height.length;i++) {
      height[i] = Integer.parseInt(st.nextToken());
      hs.add(height[i]);
    }
    
    Seg tree = new Seg(N);
  
    ArrayList<Integer> sort = new ArrayList<>(hs);
    Collections.sort(sort);
    HashMap<Integer, Integer> compress = new HashMap<>();
    for (int i=0;i<sort.size();i++) {
      compress.put(sort.get(i), i);
    }
    
    int queries = Integer.parseInt(br.readLine());
    
    int[] left = new int[queries], right = new int[queries];
    int max = sort.get(sort.size()-1);
    
    Arrays.fill(right, sort.size());
    Arrays.fill(left, -1);
    
    ArrayList<ArrayList<Integer>> mid = new ArrayList<>();
    for (int i=0;i<sort.size()+100;i++) {
      mid.add(new ArrayList<>());
    }
    
    ArrayList<ArrayList<Integer>> popList = new ArrayList<>();
    for (int i=0;i<sort.size()+100;i++) popList.add(new ArrayList<>());
    
    for (int i=0;i<height.length;i++) {
      popList.get(compress.get(height[i])).add(i+1);
    }
    
    Query[] q = new Query[queries];
    for (int i=0;i<queries;i++) {
      st = new StringTokenizer(br.readLine());
      q[i] = new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
          , Integer.parseInt(st.nextToken()));
    }
    
    while(true) {
      tree.clear();
      for (ArrayList<Integer> m : mid) m.clear();
      
      boolean b = true;
      for (int i=0;i<queries;i++) {
        if (left[i] + 1 == right[i]) continue;
        b = false;
        mid.get(left[i] + right[i] >> 1).add(i);
      }
      
      if (b) break;
      
      for (int i=0;i<sort.size();i++) {
        for (int idx : mid.get(i)) {
          Node n = tree.query(1, q[idx].left, q[idx].right, 1, tree.start);
          if (n.answer >= q[idx].width) {
            left[idx] = i;
          } else {
            right[idx] = i;
          }
        }
        
        for (int idx : popList.get(compress.get(sort.get(i)))) {
          tree.update(idx);
        }
      }
    }
  
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i=0;i<queries;i++) {
      bw.write(sort.get(left[i])+"\n");
    }
    bw.flush();
    
    
  }
}
