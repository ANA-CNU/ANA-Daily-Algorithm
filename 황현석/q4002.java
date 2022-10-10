import java.io.*;
import java.util.*;

public class Main {
  public static int M;
  public static int[] money = new int[100001], leader = new int[100001], parent = new int[100001];
  public static ArrayList<ArrayList<Integer>> load = new ArrayList<>(100001);
  public static PriorityQueue<Integer>[] pq = new PriorityQueue[100001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int root = -1;
    
    for (int i=0;i<pq.length;i++) pq[i] = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i=0;i<100001;i++) load.add(new ArrayList<>());
    for (int i=0;i<parent.length;i++) parent[i] = i;
    
    for (int i=1;i<=N;i++) {
      st = new StringTokenizer(br.readLine());
      int boss = Integer.parseInt(st.nextToken());
      money[i] = Integer.parseInt(st.nextToken());
      if (money[i] <= M)
        pq[i].offer(money[i]);
      leader[i] = Integer.parseInt(st.nextToken());
      
      if (boss == 0) root = i;
      else load.get(boss).add(i);
    }
    dfs(root, -1);
    
    System.out.println(answer);
    
  }
  public static int find (int node) {
    if (parent[node] == node) return node;
    return parent[node] = find(parent[node]);
  }
  public static void union (int n1, int n2) {
    int p1 = find(n1);
    int p2 = find(n2);
    
    if (pq[p1].size() > pq[p2].size()) {
      int temp = p1;
      p1 = p2;
      p2 = temp;
    }
    parent[p1] = p2;
    pq[p2].addAll(pq[p1]);
    money[p2] += money[p1];
    
    while(money[p2] > M) {
      money[p2] -= pq[p2].poll();
    }
  }
  
  public static long answer = 0;
  
  public static void dfs (int node, int prev) {
    for (int go : load.get(node)) {
      dfs(go, node);
      union(node, go);
    }
    
    answer = Math.max(answer, pq[find(node)].size() * (long) leader[node]);
  }
}
