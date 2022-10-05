import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
  public static int C;
  public static int[] color, parent = new int[100001], up = new int[100001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    
    color = new int[N+1];
    for (int i=0;i< parent.length;i++) parent[i] = i;
    load = new ArrayList<>(N+1);
    for (int i=0;i<=N;i++) load.add(new ArrayList<>());
    for (int i=0;i<hs.length;i++) {
      matches[i] = new HashSet<>();
      hs[i] = new HashSet<>();
    }
    
    st = new StringTokenizer(br.readLine());
    for (int i=1;i<color.length;i++) {
      color[i] = Integer.parseInt(st.nextToken());
      hs[i].add(color[i]);
      colorCount[color[i]]++;
    }
    
    min = Integer.MAX_VALUE;
    for (int i=1;i<=C;i++) min = Math.min(min, colorCount[i]);
    
    if (min <= 1) {
      System.out.println(0);
      return;
    }
    
    
    for (int i=1;i<N;i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
      load.get(n1).add(n2);
      load.get(n2).add(n1);
    }
    
    int j = dfs(1, 0);
    System.out.println(answer);
  }
  
  public static ArrayList<ArrayList<Integer>> load;
  public static HashSet<Integer>[] hs = new HashSet[100001], matches = new HashSet[100001];
  public static ArrayList<Integer> ans = new ArrayList<>();
  public static int answer;
  public static int find (int node) {
    if (parent[node] == node) return node;
    return parent[node] = find(parent[node]);
  }
  public static void union(int n1, int n2) {
    int p1 = find(n1);
    int p2 = find(n2);
    
    if (p1 == p2) return;
    
    if (hs[p1].size() > hs[p2].size()) {
      int temp = p1;
      p1 = p2;
      p2 = temp;
    }
    
    parent[p1] = p2;
    for (int e : hs[p1]) {
      if (hs[p2].contains(e)) {
        matches[n1].add(e);
      } else {
        hs[p2].add(e);
      }
    }
  }
  public static int dfs (int node, int prev) {
    int count = 0;
    int remainder = 0;
    
    for (int go : load.get(node)) if (go != prev) {
      int result = dfs(go, node);
      if (result != -1) {
        count++;
        remainder += result;
      } else {
        union(node, go);
      }
    }
    
  
    if (count == 1) {
      int last = min;
      eliminate(node, prev);
      if (hs[find(node)].size() == C || min != 0 || (last != 0)) {
        answer += remainder + 1;
        return 0;
      }
      return remainder+1;
    } else if (2 <= count) {
      eliminate(node, prev);
      answer += remainder+1;
      return 0;
    }
    
    if (hs[find(node)].size() == C) {
      eliminate(node, prev);
      if (min != 0) {
        answer++;
        return 0;
      }
      if (matches[node].size() == C) {
        answer++;
        return 0;
      }
      return 1;
    }
    return -1;
  }
  public static boolean[] eliminated = new boolean[100001];
  public static int[] colorCount = new int[50001];
  public static int min =1;
  public static void eliminate (int node, int prev) {
    if (eliminated[node]) return;
    
    for (int go : load.get(node)) if (go != prev && !eliminated[go]) {
      eliminate(go, node);
    }
    
    eliminated[node] = true;
    min = Math.min(--colorCount[color[node]], min);
  }
}
