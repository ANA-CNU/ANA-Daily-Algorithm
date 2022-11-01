import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Trie {
  private Trie[] leaf = new Trie[2];
  private ArrayList<Integer> nums = new ArrayList<>();
  
  public static void update (Trie node, int depth, int num) {
    node.nums.add(num);
    if (depth == 30) return;
    
    int bit = (num & (1 << (29 - depth))) != 0 ? 1 : 0;
    
    if (node.leaf[bit] == null)
      node.leaf[bit] = new Trie();
    
    update(node.leaf[bit], depth+1, num);
  }
  
  public static void solve (Trie node, int depth) {
    if (node == null || depth == 30) return;
    
    
    if (node.leaf[0] != null && node.leaf[1] != null) {
      int min = Integer.MAX_VALUE;
      for (int value : node.leaf[0].nums) {
        min = Math.min(min,  value ^ tracking(node.leaf[1], depth+1, value));
      }
      Main.ans += min;
    }
    
    solve(node.leaf[0], depth+1);
    solve(node.leaf[1], depth+1);
  }
  
  public static int tracking (Trie node, int depth, int num)  {
    if (depth == 30) return node.nums.get(0);
  
    int bit = (num & (1 << (29 - depth))) != 0 ? 1 : 0;
    
    if (node.leaf[bit] == null) bit ^= 1;
    return tracking(node.leaf[bit], depth+1, num);
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
  
    StringTokenizer st = new StringTokenizer(br.readLine());
    Trie trie = new Trie();
    for (int i=0;i<N;i++) {
      int value = Integer.parseInt(st.nextToken() );
      Trie.update(trie, 0, value);
    }
    
    Trie.solve(trie, 0);
    System.out.println(ans);
  }
  public static long ans;
}
