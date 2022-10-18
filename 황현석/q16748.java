package Solving;

import java.io.*;
import java.util.*;

class Cmp implements Comparator<Integer> {
  
  @Override
  public int compare(Integer o1, Integer o2) {
    return Integer.compare(Main.level[o2], Main.level[o1]);
  }
}

public class Main {
  public static int start = 1, MAX = 100001;
  public static HashMap<Integer, Integer>[] tree;
  public static int[] answer = new int[MAX], in = new int[MAX], out = new int[MAX], level = new int[MAX];
  public static int[] nodeColor = new int[MAX], colorCount = new int[MAX];
  public static ArrayList<ArrayList<Integer>> load;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    
    while(start < N) start <<= 1;
    tree = new HashMap[start << 1];
    for (int i=0;i<tree.length;i++) tree[i] = new HashMap<>();
    
    load = new ArrayList<>(N+1);
    for (int i=0;i<=N;i++) load.add(new ArrayList<>());
    
    for (int i=1;i<N;i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
      
      load.get(n1).add(n2);
      load.get(n2).add(n1);
    }
    
    Cmp cmp = new Cmp();
    for (int i=0;i<pq.length;i++) pq[i] = new PriorityQueue<>(cmp);
    
    dfs(1, 0);
    for (int i=1;i<dp.length;i++) {
      for (int j=1;j<=N;j++) {
        dp[i][j] = dp[i-1][dp[i-1][j]];
      }
    }
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    Arrays.fill(answer, -1);
    for (int i=1;i<=N;i++) {
      //색깔을 바로 넣고 시작.
      int color = Integer.parseInt(st.nextToken());
      add(i, color);
    }
    
    int queries = Integer.parseInt(br.readLine());
    while(queries-->0) {
      st = new StringTokenizer(br.readLine());
      char m = st.nextToken().charAt(0);
      if (m == 'U') {
        int node = Integer.parseInt(st.nextToken()), color = Integer.parseInt(st.nextToken());
        if (nodeColor[node] == color) continue;
        
        poll(node, nodeColor[node]);
        add(node, color);
        
      } else {
        
        int color = Integer.parseInt(st.nextToken());
        bw.write(answer[color]+"\n");
      }
    }
    bw.flush();
  }
  
  public static int count;
  public static int getAnswer (int node, int color) {
    boolean outside = findNot(node, color);
    boolean inside = find(1, in[node], out[node], 1, start, color);
    
    if (outside && inside) return 0;
    if (outside) {
      int left = node, right = 1;
      
      int colorlca = colorCount[color] == 1 ? getLow(color) : colorLca(color);
      
      while(true) {
        int mid = left;
        int dist = level[left] - level[right] >> 1;
        for (int i=27;i>=0;i--) {
          if ((dist & 1 << i) != 0) mid = dp[i][mid];
        }
        
        if (find(1, in[mid], out[mid], 1, start, color)) {
          right = mid;
        } else {
          left = mid;
        }
        
        if (level[left] - level[right] == 1) {
          // answer에 level[node] - level[right] 가 일단 들어가는건 팩트
          int ans = level[node] - level[right];
          if (in[right] < in[colorlca] && in[colorlca] <= out[right])
            ans += level[colorlca] - level[right];
          return ans;
        }
      }
    } else if (inside){
      int colorlca = colorCount[color] == 1 ? getLow(color) : colorLca(color);
      return level[colorlca] - level[node];
    }
    
    return 0;
    
  }
  public static void add (int node, int color) {
    if (colorCount[color] == 0) {
      answer[color] = 0;
    } else
      answer[color] += getAnswer(node, color);
    colorCount[color]++;
    nodeColor[node] = color;
    pq[color].offer(node);
    
    int idx = in[node] -1 + start;
    while(idx != 0) {
      if (tree[idx].containsKey(color)) {
        tree[idx].put(color, tree[idx].get(color)+1);
      } else {
        tree[idx].put(color, 1);
      }
      idx >>= 1;
    }
  }
  public static void poll (int node, int color) {
    int idx = in[node] -1 + start;
    nodeColor[node] = -1;
    while(idx != 0) {
      int value = tree[idx].get(color);
      if (value == 1) {
        tree[idx].remove(color);
      } else {
        tree[idx].put(color, value-1);
      }
      idx >>= 1;
    }
  
    if (colorCount[color]-- == 1) {
      answer[color] = -1;
    } else
      answer[color] -= getAnswer(node, color);
    
  }
  public static int[][] dp = new int[28][MAX];
  public static void dfs (int node, int prev) {
    in[node] = ++count;
    level[node] = level[prev] + 1;
    for (int go : load.get(node)) if (go != prev) {
      dfs(go, node);
      dp[0][go] = node;
    }
    out[node] = count;
  }
  public static boolean find (int node, int s, int e, int left, int right, int color) {
    if (e < left || right < s) return false;
    
    if (s <= left && right <= e) return tree[node].containsKey(color);
    
    int mid = left + right >> 1;
    return find(node<< 1, s, e, left, mid, color)
        | find(node*2+1, s, e, mid+1, right, color);
  }
  public static boolean findNot (int node, int color) {
    return find(1, 1, in[node]-1, 1, start, color)
        | find(1, out[node]+1, start, 1, start, color);
  }
  public static PriorityQueue<Integer>[] pq = new PriorityQueue[MAX];
  public static int colorLca (int color) {
    int left = getLow(color);
    int right = 1;
    
    if (colorCount[color] == 1) return left;
    
    while(true) {
      int mid = left;
      int dist = level[left] - level[right] >> 1;
      for (int i=27;i>=0;i--) {
        if ((dist & 1 << i) != 0) mid = dp[i][mid];
      }
      
      if (count(1, in[mid], out[mid], 1, start, color) == colorCount[color]) {
        right = mid;
      } else {
        left = mid;
      }
      
      if (level[left] - level[right] == 1) {
        return right;
      }
    }
    
  }
  public static int count (int node, int s, int e, int left, int right, int color) {
    if (e < left || right < s) return 0;
    
    if (s <= left && right <= e) {
      return tree[node].getOrDefault(color, 0);
    }
    
    int mid = left + right >> 1;
    return count(node*2, s, e, left, mid, color) + count(node*2+1, s, e, mid+1, right, color);
  }
  public static int getLow (int color) {
    while(true) {
      if (nodeColor[pq[color].peek()] != color) pq[color].poll();
      else break;
    }
    return pq[color].peek();
  }
  public static int getLca (int n1, int n2) {
    if (level[n1] > level[n2]) {
      int temp = n1;
      n1 = n2;
      n2 = temp;
    }
    
    int dist = level[n2] - level[n1];
    for (int i=27;i>=0;i--) {
      if ((dist& 1 << i) != 0) n2 = dp[i][n2];
    }
  
    for (int i=27;i>=0;i--) {
      if (dp[i][n1] != dp[i][n2]) {
        n1 = dp[i][n1];
        n2 = dp[i][n2];
      }
    }
    
    return n1 == n2 ? n1 : dp[0][n1];
  }
}
