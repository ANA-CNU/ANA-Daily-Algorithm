import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Line {
  int n1, n2, w;
  boolean same;
  Line (int n1, int n2, int w) {
    this.n1 = n1;
    this.n2 = n2;
    this.w = w;
    same = n1 == n2;
  }
}

public class Main {
  public static int a, b, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    int[][] height = new int[a][b];
    for (int i=0;i<a;i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0;j<b;j++) {
        height[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  
    ArrayList<Line> lines = new ArrayList<>(a*b*3);
    
    for (int i=0;i<a;i++) {
      for (int j=0;j<b;j++) {
        for (int g =0;g<2;g++) {
          int x = i + dx[g];
          int y = j + dy[g];
          
          if (x == -1 || x == a || y == -1 || y == b) continue;
          lines.add(new Line(encode(i, j), encode(x, y), Math.max(height[i][j], height[x][y])));
        }
      }
    }
    
    lines.sort(new Comparator<Line>() {
      @Override
      public int compare(Line o1, Line o2) {
        return Integer.compare(o1.w, o2.w);
      }
    });
    
    ArrayList<Line> temp = new ArrayList<>();
    for (int i=0;i<parent.length;i++) parent[i] = i;
    
    for (Line l : lines) {
      if (union(l.n1, l.n2)) temp.add(l);
    }
    
    lines = temp;
    int N = a*b;
    
    ArrayList<Line> queries = new ArrayList<>();
    for (int i=0;i<M;i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken()) - 1, y1 = Integer.parseInt(st.nextToken())-1;
      int x2 = Integer.parseInt(st.nextToken()) - 1, y2 = Integer.parseInt(st.nextToken())-1;
      Line line = new Line(encode(x1, y1), encode(x2, y2), Math.max(height[x1][y1], height[x2][y2]));
      queries.add(line);
    }
    
    int[] left = new int[M], right = new int[M];
    Arrays.fill(right, lines.size()+1);
    
    ArrayList<ArrayList<Integer>> mid = new ArrayList<>();
    for (int i=0;i<(lines.size() << 1);i++) mid.add(new ArrayList<>());
    
    while(true) {
      for(ArrayList<Integer> a : mid) a.clear();
      for (int i=0;i<parent.length;i++) parent[i] = i;
      
      boolean is = false;
      for (int i=0;i<M;i++) {
        if (left[i] + 1 == right[i]) continue;
        is = true;
        mid.get(left[i] + right[i] >> 1).add(i);
      }
      
      if (!is) break;
      
      for (int i=0;i<lines.size();i++) {
        union(lines.get(i).n1, lines.get(i).n2);
        for (int q : mid.get(i+1)) {
          if (find(queries.get(q).n1) != find(queries.get(q).n2)) {
            left[q] = i+1;
          } else {
            right[q] = i+1;
          }
        }
      }
    }
  
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i=0;i<M;i++) {
      if (queries.get(i).same) {
        bw.write(queries.get(i).w+"\n");
        continue;
      }
      bw.write(Math.max(lines.get(right[i]-1).w, queries.get(i).w) +"\n");
    }
    bw.flush();
    
    
    
  }
  public static int[] dx = {0, 1}, dy = {1,0};
  public static int encode (int x, int y) {
    return x * b + y;
  }
  public static int[] parent = new int[300000];
  public static int find (int node) {
    if (parent[node] == node) return node;
    return parent[node] = find(parent[node]);
  }
  
  public static boolean union (int n1, int n2) {
    int p1 = find(n1);
    int p2 = find(n2);
    if(p1 == p2) return false;
    parent[p1] = p2;
    return true;
  }
}
