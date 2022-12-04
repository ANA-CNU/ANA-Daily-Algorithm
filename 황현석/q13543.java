import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node  {
  Node parent, left, right;
  public static int[][] pascal;
  int value, size = 1;
  int[] answer = new int[11], prepare = new int[11];
  
  Node (int value) {
    this.value = value;
    prepare[0] = 1;
    update();
  }
  
  public void update () {
    size = 1;
    int order = left != null ? left.size+1 : 1;
    
    for (int i=1;i<11;i++) {
      prepare[i] = prepare[i-1] * order;
    }
    
    
    if (left != null) {
      size += left.size;
    }
    
    if (right != null) {
      size += right.size;
    }
    
    if (left == null && right == null) {
      for (int i=0;i<11;i++) {
        answer[i] = value;
      }
    } else if (left == null) {
      
      for (int i=0;i<11;i++) {
        answer[i] = value;
        
        for (int j=0;j<=i;j++) {
          answer[i] += right.answer[j] * pascal[i][j] * prepare[i-j];
        }
      }
      
      
    } else if (right == null) {
      for (int i=0;i<11;i++) {
        answer[i] = left.answer[i];
        answer[i] += value * cal(i, left.size+1);
      }
      
    } else {
      for (int i=0;i<11;i++) {
        answer[i] = left.answer[i];
        answer[i] += value * cal(i, left.size+1);
    
        for (int j=0;j<=i;j++) {
          answer[i] += right.answer[j] * pascal[i][j] * prepare[i- j];
        }
      }
    }
    
  }
  
  public long cal (long exp, long base) {
    long res = 1, mul = base;
    
    while(exp > 0) {
      if ((exp & 1) ==  1) {
        res *= mul;
      }
      
      mul *= mul;
      exp >>= 1;
    }
    
    return res;
  }
}

class Splay {
  Node root;
  private int size;
  public static int[][] pascal;
  
  Splay (int[] arr) {
    Node[] nodes = new Node[arr.length];
    size = arr.length;
    
    pascal = new int[12][12];
    pascal[0][0] = 1;
  
    for (int i=0;i<11;i++) {
      for (int j=0;j < i+1;j++) {
        pascal[i+1][j] += pascal[i][j];
        pascal[i+1][j+1] += pascal[i][j];
      }
    }
  
    Node.pascal = pascal;
  
    for (int i=0;i<arr.length;i++) {
      nodes[i] = new Node(arr[i]);
    }
    
    nodes[size-1].update();
    
    for (int i=arr.length-1;i>0;i--) {
      nodes[i].parent = nodes[i-1];
      nodes[i-1].right = nodes[i];
      
      nodes[i-1].update();
    }
    
    root = nodes[0];
  }
  
  public void rotate (Node a) {
    Node parent = a.parent;
    Node temp = null;
    
    if (a == parent.left) {
      temp = parent.left = a.right;
      
      a.right = parent;
    } else if (a == parent.right) {
      temp = parent.right = a.left;
      
      a.left = parent;
    }
    
    a.parent = parent.parent;
    parent.parent = a;
    
    if (temp != null) {
      temp.parent = parent;
    }
    
    if (a.parent != null) {
      if (a.parent.left == parent) {
        a.parent.left = a;
      } else {
        a.parent.right = a;
      }
    } else {
      root = a;
    }
  
    parent.update();
    a.update();
  }
  
  public void splay (Node a) {
    while(a.parent != null) {
      if (a.parent.parent != null) rotate((a.parent.left == a) == (a.parent.parent.left == a.parent) ? a.parent : a);
      rotate(a);
    }
  }
  
  public void insert (int idx, int value) {
    Node temp = new Node(value);
    if (idx == 0) {
      findKth(1);
      
      root.parent = temp;
      temp.right= root;
      
    } else if (idx == size) {
      findKth(size);
      
      root.parent = temp;
      temp.left = root;
    } else {
      //left : idx right : idx+1
      findKth(idx);
      
      temp.right = root.right;
      temp.right.parent = temp;
      
      temp.left = root;
      temp.left.parent = temp;
      
      root.right = null;
      root.update();
    }
    
    temp.update();
    root = temp;
  
    size++;
  }
  
  public void delete (int idx) {
    if (idx == 0) {
      findKth(idx+1);
      root = root.right;
      root.parent = null;
    } else if (idx == size-1) {
      findKth(size);
      root = root.left;
      root.parent = null;
    } else {
      findKth(idx+1);
      Node target = root;
      
      root = target.left;
      root.parent = null;
      
      findKth(idx);
      root.right = target.right;
      target.right.parent = root;
      
      root.update();
    }
  
    size--;
  }
  
  public void findKth (int order) {
    Node now = root;
    
    while(true) {
      if (now.right == null && now.left == null) break;
      
      if (now.left != null && now.right != null ) {
        if (now.left.size + 1 == order) break;
        
        if (now.left.size < order) {
          order -= now.left.size + 1;
          now = now.right;
        } else {
          now = now.left;
        }
      } else if (now.left == null) {
        if (order == 1) break;
        order--;
        now = now.right;
      } else {
        if (now.left.size + 1 == order) break;
        now = now.left;
      }
    }
    
    splay(now);
  }
  
  public int query (int left, int right , int k) {
    if (left == 0 && right == size-1) {
      return root.answer[k];
    } else if (left == 0) {
      findKth(right+2);
      return root.left.answer[k];
    } else if (right == size-1) {
      findKth(left);
      return root.right.answer[k];
    } else {
      findKth(left);
      
      Node original = root;
      
      root = root.right;
      root.parent = null;
      
      findKth(right - left + 2);
      
      int answer = root.left.answer[k];
      
      original.right = root;
      root.parent = original;
      
      root = original;
      root.update();
      
      return answer;
    }
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
  
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i=0;i<N;i++) {
      arr[i] = changer(Long.parseLong(st.nextToken()));
    }
    
    Splay tree = new Splay(arr);
    
    int M = Integer.parseInt(br.readLine());
  
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    while(M-->0) {
      st = new StringTokenizer(br.readLine());
      
      int m = Integer.parseInt(st.nextToken());
      if (m == 1) {
        int idx = Integer.parseInt(st.nextToken()), value = changer(Long.parseLong(st.nextToken()));
        
        tree.insert(idx, value);
      } else if (m == 2) {
        int idx = Integer.parseInt(st.nextToken());
        
        tree.delete(idx);
      } else if (m == 3) {
        int idx = Integer.parseInt(st.nextToken()), value = changer(Long.parseLong(st.nextToken()));
        
        tree.findKth(idx+1);
        tree.root.value = value;
        tree.root.update();
      } else {
        int left = Integer.parseInt(st.nextToken()), right = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        bw.write(f(tree.query(left, right, k))+"\n");
      }
    }
    
    bw.flush();
  }
  
  public static int changer (long k) {
    int res = 0;
    
    for (int i=0;i<32;i++) {
      if ((k & 1L << i) != 0) {
        res |= 1 << i;
      }
    }
    
    return res;
  }
  
  public static long f (int k) {
    long res = 0;
    for (int i=0;i<32;i++) {
      if ((k & 1 << i) != 0) {
        res |= 1L<<i;
      }
    }
    
    return res;
  }
}
