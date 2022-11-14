import java.io.*;
import java.util.StringTokenizer;

class Node {
  Node left, right;
  long s, e, mid;
  Line line;
  
  Node() {
  
  }
  
  Node(long s, long e) {
    this.s = s;
    this.e = e;
    mid = s + e >> 1;
  }
  
  public void summonNode() {
    left = new Node(s, mid);
    right = new Node(mid+1, e);
    
    left.line = right.line = line;
  }
  
}

class Line {
  long a, b;
  Line (long a, long b) {
    this.a = a;
    this.b = b;
  }
  
  public long function(long x) {
    return a * x + b;
  }
  
  public static int compare (Line o1, Line o2, long x) {
    return Long.compare(o1.function(x), o2.function(x));
  }
}

class Lichao {
  public static long MAX = 1000000000;
  Node top;
  Lichao () {
    top = new Node(0, MAX);
  }
  
  public long query (Node node, long x) {
    if (node.s == node.e) return node.line.function(x);
    
    if (x <= node.mid) {
      if (node.left == null) {
        return node.line.function(x);
      } else {
        return Math.min(node.line.function(x), query(node.left, x));
      }
    } else {
      if (node.right == null) {
        return node.line.function(x);
      } else {
        return Math.min(node.line.function(x), query(node.right, x));
      }
    }
  }
  public void update(Node node, Line line) {
    if (node.line == null) {
      node.line = line;
      return;
    }
    
    boolean L = node.line.function(node.s) >= line.function(node.s);
    boolean R = node.line.function(node.e) >= line.function(node.e);
    
    boolean M = node.line.function(node.mid) >= line.function(node.mid);
    
    if (L && R) {
      node.line = line;
      return;
    } else if (L == R) {
      return;
    }
    
    if (node.left == null) node.summonNode();
    update(node.left, line);
    update(node.right, line);
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int N = Integer.parseInt(br.readLine());
    
    st = new StringTokenizer(br.readLine());
    long[] prefix = new long[N];
    for (int i=1;i<prefix.length;i++) {
      prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
    }
    
    long[] speed = new long[N], ready = new long[N];
    
    for (int i=0;i<N-1;i++) {
      st = new StringTokenizer(br.readLine());
      ready[i] = Integer.parseInt(st.nextToken());
      speed[i] = Integer.parseInt(st.nextToken());
    }
    
    Lichao tree = new Lichao();
    tree.update(tree.top, new Line(speed[0], ready[0]));
    
    long ans = 0;
    for (int i=1;i<N;i++) {
      ans = tree.query(tree.top, prefix[i]);
      tree.update(tree.top, new Line(speed[i], -speed[i] * prefix[i] + ready[i] + ans));
    }
    
    System.out.println(ans);
  }
}
