import java.io.*;
import java.math.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v;
    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public int compareTo(Edge e) {
        if (u == e.u && v == e.v) return 0;
        else if (u == e.u) return v < e.v ? -1 : 1;
        return u < e.u ? -1 : 1;
    }
}

public class J2111 {
    static int V, E, dcnt = 0;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int dfsn[] = new int[20001];
    static Stack<Edge> st = new Stack<Edge>();
    static BigInteger ans = BigInteger.ONE;

    static int dfs(int pre, int cur) {
        int m = dfsn[cur] = ++dcnt;

        for (int next : adj.get(cur)) {
            if (pre == next) continue;

            if (dfsn[cur] > dfsn[next]) st.push(new Edge(cur, next));

            if (dfsn[next] > 0) m = Math.min(m, dfsn[next]);
            else {
                int temp = dfs(cur, next);
                m = Math.min(m, temp);
                if (temp >= dfsn[cur]) {
                    HashSet<Integer> tempBCC = new HashSet<>();
                    Edge cmpEdge = new Edge(cur, next);
                    int N = 1;

                    while (st.peek().compareTo(cmpEdge) != 0) {
                        tempBCC.add(st.peek().u);
                        tempBCC.add(st.peek().v);
                        ++N;
                        st.pop();
                    }
                    tempBCC.add(st.peek().u);
                    tempBCC.add(st.peek().v);
                    st.pop();

                    if (N == 1) continue;

                    if (N == tempBCC.size()) {
                        ans = ans.multiply(BigInteger.valueOf(N+1));
                    } else {
                        ans = BigInteger.ZERO;
                    }
                }
            }
        }

        return m;
    }

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());

        Arrays.fill(dfsn, 0);
        for (int i = 0; i < V+1; i++) {
            adj.add(new ArrayList<Integer>());
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < n; i++) {
                adj.get(arr[i-1]).add(arr[i]);
                adj.get(arr[i]).add(arr[i-1]);
            }
        }

        dfs(0, 1);
        for (int i = 1; i < V+1; i++) {
            if (dfsn[i] == 0) ans = BigInteger.ZERO;
        }
        System.out.println(ans);

        br.close();
    }
}