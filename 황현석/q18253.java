import java.io.*;
import java.util.*;

class Query {
  int n1, m1;
  int n2, m2;
  
  long answer = Long.MAX_VALUE;
  
  Query (int a, int b,int c,int d) {
    n1= a-1;
    m1 = b-1;
    n2 = c-1;
    m2 = d-1;
  }
  
}

class Pair {
  int x, y;
  long weight;
  Pair (int x, int y, long weight) {
    this.x = x;
    this.y = y;
    this.weight = weight;
  }
}

public class Main {
  public static long[][] value = new long[5][100001];
  
  public static int N, M;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    for (int i=0;i<N;i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0;j<M;j++) value[i][j] = Integer.parseInt(st.nextToken());
    }
    
    int testcase = Integer.parseInt(br.readLine());
    ArrayList<Query> queries = new ArrayList<>(testcase);
    
    for (int i=0;i<testcase;i++) {
      st = new StringTokenizer(br.readLine());
      queries.add(new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
          , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    
    
    dnc(0, M-1, queries);
  
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (Query query : queries) {
      if (query.answer < 0) throw new IllegalArgumentException();
      bw.write(query.answer+"\n");
    }
    bw.flush();
  }
  public static long[][] dp = new long[5][100001];
  public static void dnc (int left, int right, ArrayList<Query> list) {
    if (list.isEmpty()) return;
    int mid = left + right >> 1;
    
    
    ArrayList<Query> l = new ArrayList<>(), r = new ArrayList<>();
    
    for (Query query : list) {
      if (query.m1 < mid && query.m2 < mid) {
        l.add(query);
      } else if (query.m1 > mid && query.m2 > mid) {
        r.add(query);
      }
    }
    
    for (int i=0;i<N;i++) {
      dijkstra(i, mid, left, right);
      
      for (Query query : list) {
        query.answer = Math.min(query.answer, dp[query.n1][query.m1] + dp[query.n2][query.m2] + value[i][mid]);
      }
    }
    
    if (left == right) return;
    
    dnc(left, mid, l);
    dnc(mid+1, right, r);
    
  }
  public static PriorityQueue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {
    @Override
    public int compare(Pair o1, Pair o2) {
      return Long.compare(o1.weight, o2.weight);
    }
  });
  
  public static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
  
  public static void dijkstra (int n, int m, int left, int right) {
    for (int i=0;i<N;i++) {
      for (int j=left;j<=right;j++) {
        dp[i][j] = (long) 1E18;
      }
    }
    
    dp[n][m] = 0;
    qu.offer(new Pair(n, m, 0));
    
    while(!qu.isEmpty()) {
      Pair now = qu.poll();
      if (now.weight > dp[now.x][now.y]) continue;
      
      for (int i=0;i<4;i++) {
        int x = now.x + dx[i];
        int y = now.y + dy[i];
        
        if (x == -1 || x == N || y < left || y > right) continue;
        
        if (dp[x][y] > now.weight + value[x][y]) {
          dp[x][y] = now.weight + value[x][y];
          qu.offer(new Pair(x, y, dp[x][y]));
        }
      }
    }
    
    
  }
}
