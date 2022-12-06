import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
  int value, size = 1;
  Node p, l, r;
  boolean re;
  
  Node (int value) {
    this.value = value;
  }
  
  public void propagate () {
    if (re){
      Node temp = r;
      r = l;
      l = temp;
      
      if (r != null) r.re ^= true;
      if (l != null) l.re ^= true;
    }
    
    re = false;
  }
  
  public void update () {
    size = 1;
    if (l != null) size += l.size;
    if (r != null) size += r.size;
  }
}

class Splay {
  
  private Node[] nodes;
  private int[] visit = new int[100001];
  private int check = 1;
  
  Splay (Node[] nodes) {
    this.nodes = nodes;
  }
  public boolean isRoot (Node a) {
    return a.p == null || (a.p.l != a && a.p.r != a);
  }
  
  public void rotate (Node a) {
    Node parent = a.p, temp = null;
    
    parent.propagate(); a.propagate();
    
    if (a.p.l == a) {
      parent.l = temp = a.r;
      a.r = parent;
    } else {
      parent.r = temp = a.l;
      a.l = parent;
    }
    
    if (temp != null) temp.p = parent;
    
    a.p = parent.p;
    parent.p = a;
  
    if (a.p != null) {
      if (a.p.l == parent) {
        a.p.l = a;
      } else if (a.p.r == parent) {
        a.p.r = a;
      }
    }
  
    parent.update();
    a.update();
  }
  
  public void splay (Node a) {
    while(!isRoot(a)) {
      if (!isRoot(a.p)) rotate((a.p.p.l == a.p) == (a.p.l == a) ? a.p : a);
      rotate(a);
    }
  }
  
  public Node access (Node a) {
    splay(a);
    a.r = null;
    a.update();
    
    Node res = a;
    
    while(a.p != null) {
      res = a.p;
      splay(res);
      res.r = a;
      
      res.update();
      splay(a);
    }
    
    return res;
  }
  
  public Node root (Node a) {
    access(a);
    while(a.l != null) a = a.l;
    access(a);
    return a;
  }
  
  public void link (Node child, Node parent) {
    access(child); access(parent);
    child.l = parent;
    parent.p = child;
    child.update();
  }
  
  public void cut (Node a) {
    access(a);
    if (a.l != null) a.l.p = null;
    a.l = null;
    a.update();
  }
  
  public void makeRoot (Node a) {
    access(a);
    a.re ^= true;
    a.propagate();
  }
  
  public void connect (Node a, Node b) {
    makeRoot(a);
    link(a, b);
  }
  
  public int lca (Node a, Node b) {
    access(a); access(b);
    
    splay(a);
    
    return a.p != null ? a.p.value : a.value;
  }
  
  public void inOrder (Node now) {
    access(now);
    iinOrder(now);
  }
  
  public void iinOrder (Node now) {
    if (now.l != null) iinOrder(now.l);
    System.out.println(now.value);
    if (now.r != null) iinOrder(now.r);
  }
  
  
}

public class Main {
  public static Node[] nodes;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
    nodes = new Node[N+1];
    for (int i=0;i<N+1;i++) {
      nodes[i] = new Node(i);
    }
    
    Splay tree = new Splay(nodes);
  
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while(Q-->0) {
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      
      if (m == 1) {
        int child = Integer.parseInt(st.nextToken()), parent = Integer.parseInt(st.nextToken());
//        tree.connect(nodes[parent], nodes[child]);
        tree.connect(nodes[child], nodes[parent]);
//        tree.link(nodes[child], nodes[parent]);
        
      } else if (m == 2) {
        int v = Integer.parseInt(st.nextToken());
        tree.cut(nodes[v]);
      } else {
        int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
        bw.write(tree.lca(nodes[n1], nodes[n2])+"\n");
      }
    }
    bw.flush();
    
  }
}
