import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
  boolean left = true, right = true, poo = true;
  int answer, len = 1, leftLen = 1, rightLen = 1;
  
  public static Node makeNode (Node res, Node left, Node right){
    if (left == null) return right;
    if (right == null) return left;
    
    res.len = left.len + right.len;
    res.left = left.left;
    res.right = right.right;
    
    res.answer = left.answer + right.answer;
    res.poo = left.poo && right.poo && left.right != right.left;
    
    if (!left.poo && !right.poo){
      if (left.right != right.left) {
        res.answer += left.rightLen + right.leftLen >> 1;
      } else {
        res.answer += left.rightLen >> 1;
        res.answer += right.leftLen >> 1;
      }
    } else if (left.poo != right.poo && left.right == right.left) {
      if (!left.poo) {
        res.answer += left.rightLen >> 1;
      } else {
        res.answer += right.leftLen >> 1;
      }
    }
    
    if (right.poo && left.right != right.left) {
      res.rightLen = left.rightLen + right.len;
    } else {
      res.rightLen = right.rightLen;
    }
    
    if (left.poo && left.right != right.left) {
      res.leftLen = left.len + right.leftLen;
    } else {
      res.leftLen = left.leftLen;
    }
    
    return res;
  }
}

class Seg {
  private Node[] tree;
  public int start = 1;
  
  Seg (int[] arr) {
    while(start < arr.length) start <<= 1;
    
    tree = new Node[start << 1];
    for (int i=0;i<tree.length;i++) tree[i] = new Node();
    
    for (int i=start>>1;i!=0;i>>=1) {
      for (int j=i;j< i << 1;j++) {
        Node.makeNode(tree[j], tree[j << 1], tree[j << 1 | 1]);
      }
    }
  }
  
  public void update (int idx) {
    idx += start;
    tree[idx].left = tree[idx].right = false;
    
    for (int i = idx >> 1;i!=0;i>>=1) {
      Node.makeNode(tree[i], tree[ i << 1], tree[i << 1 | 1]);
    }
  }
  
  public Node Query (int node, int s, int e, int left, int right) {
    if (e < left || right < s) return null;
    
    if (s <= left && right <= e) return tree[node];
    
    int mid = left + right >> 1;
    return Node.makeNode(new Node(), Query(node << 1, s, e, left, mid)
        , Query(node << 1 | 1, s, e, mid+1, right));
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N << 1];
    
    st = new StringTokenizer(br.readLine());
    
    for (int i=0;i<N;i++) {
      arr[i] = arr[i + N] = Integer.parseInt(st.nextToken());
    }
  
    ArrayList<ArrayList<Integer>> query = new ArrayList<>();
    for (int i=0;i < M+100;i++) query.add(new ArrayList<>());
    
    for (int i=0;i<arr.length;i++) {
      query.get(arr[i]).add(i);
    }
    
    Seg tree = new Seg(arr);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    for (int i=1;i<=M;i++) {
      long answer = 0;
      
      if (query.get(i).isEmpty()) {
        bw.write("-1 ");
        continue;
      }
      
      for (int j=0;j + 1 < query.get(i).size();j++) {
        int left = query.get(i).get(j), right= query.get(i).get(j+1);
        if (left >= N) break;
        
        if (left + 1 == right) continue;
        
        Node q = tree.Query(1,left+2, right, 1, tree.start);
        answer += right - left - 1;
        answer += q.answer;
        
        if (q.poo) answer += q.len >> 1;
        else {
          answer += q.leftLen >> 1;
          answer += q.rightLen >> 1;
        }
        
        if (right >= N) break;
      }
      
      bw.write(answer+" ");
      
      for (int idx : query.get(i)) tree.update(idx);
    }
    bw.flush();
  }
}
