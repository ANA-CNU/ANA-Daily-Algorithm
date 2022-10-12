import java.io.*;
import java.util.*;

class Load {
    int goal, num;
    Load (int goal, int num) {
        this.goal = goal;
        this.num = num;
    }
}

class HLD {
    class Segment {
        private int[] tree;
        int start = 1, end;
        Segment(ArrayList<Integer> al) {
            while(start < al.size()) start <<= 1;
            tree = new int[start << 1];
            end = al.size();
            
            Arrays.fill(tree, Integer.MAX_VALUE);
            
            for(int i=0;i<al.size();i++)
                nodesIdx[al.get(i)] = i+1;
        }
        
        private void propagate (int node) {
            if (node >= start) return;
            
            tree[node*2] = Math.min(tree[node*2], tree[node]);
            tree[node*2+1] = Math.min(tree[node*2+1], tree[node]);
            tree[node] = Integer.MAX_VALUE;
        }
        
        public void update(int node, int s, int e, int left, int right, int value) {
            if (e < left || right < s) return;
            //세그먼트 트리에 대해, 업데이트 쿼리 작성
            
            if (tree[node] != Integer.MAX_VALUE) propagate(node);
            
            if (s <= left && right <= e) {
                tree[node] = Math.min(tree[node], value);
                return;
            }
            
            int mid = left + right >> 1;
            update(node<<1, s, e, left, mid, value);
            update(node*2+1, s, e, mid+1, right, value);
        }
        
        public void set () {
            for (int i=1;i<start;i++) {
                propagate(i);
            }
        }
        
        public int getSub (int node) {
            return tree[start + nodesIdx[node] - 1];
        }
    }
    
    class Pair {
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int[] mychain, nextChain, chainDepth, level;
    public static int[] nodesIdx;
    Segment[] chaines;
    
    HLD(ArrayList<ArrayList<Load>> load, int size) {
        Queue<Pair> qu = new LinkedList<>();
        Stack<Integer> sts = new Stack<>();
        
        nodesIdx = new int[size+1];
        
        qu.offer(new Pair(1, 0));
        level = new int[size+1];
        
        while (!qu.isEmpty()) {
            Pair n = qu.poll();
            boolean s = true;
            
            for (Load go : load.get(n.x)) {
                if (go.goal != n.y) {
                    level[go.goal] = level[n.x] + 1;
                    qu.offer(new Pair(go.goal, n.x));
                    s = false;
                }
            }
            
            if (s) sts.push(n.x);
        }
        mychain = new int[size+1];
        nextChain = new int[sts.size()];
        chainDepth = new int[sts.size()];
        chaines = new Segment[sts.size()];
        Arrays.fill(mychain, -1);
        
        int cha = 0;
        while(!sts.isEmpty()) {
            int node = sts.pop();
            mychain[node] = cha;
            ArrayList<Integer> al = new ArrayList<>();
            
            qu.offer(new Pair(node, 0));
            
            while(!qu.isEmpty()) {
                Pair n = qu.poll();
                al.add(n.x);
                for (Load go : load.get(n.x)) {
                    if (level[go.goal] < level[n.x]) {
                        if (mychain[go.goal] == -1) {
                            mychain[go.goal] = cha;
                            qu.offer(new Pair(go.goal, n.x));
                        } else {
                            nextChain[cha] = go.goal;
                            chainDepth[cha] = chainDepth[mychain[go.goal]] + 1;
                        }
                        break;
                    }
                }
            }
            chaines[cha++] = new Segment(al);
        }
        
    }
    
    public void update (int n1, int n2, int value) {
        int lca = getLca(n1, n2);
        
        while(mychain[n1] != mychain[lca]) {
            chaines[mychain[n1]].update(1, nodesIdx[n1], chaines[mychain[n1]].end
                , 1, chaines[mychain[n1]].start, value);
            n1 = nextChain[mychain[n1]];
        }
        
        while(mychain[n2] != mychain[lca]) {
            chaines[mychain[n2]].update(1, nodesIdx[n2], chaines[mychain[n2]].end
                , 1, chaines[mychain[n2]].start, value);
            n2 = nextChain[mychain[n2]];
        }
        
        if (level[n1] > level[n2]) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        if (n1 == lca && n2 == lca) return;
        
        chaines[mychain[lca]].update(1, nodesIdx[n2], nodesIdx[lca]-1, 1
            , chaines[mychain[lca]].start, value);
    }
    
    public int getLca(int n1, int n2) {
        //n1, n2관계에 대해, 일반성을 유지하기 위해, 깊이를 바꾸어준다.
        if(chainDepth[mychain[n1]] > chainDepth[mychain[n2]]) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        
        while(chainDepth[mychain[n1]] != chainDepth[mychain[n2]]) {
            n2 = nextChain[mychain[n2]];
        }
        
        while(mychain[n1] != mychain[n2]) {
            n1 = nextChain[mychain[n1]];
            n2 = nextChain[mychain[n2]];
        }
        
        return level[n1] > level[n2] ? n2 : n1;
    }
}

public class Main {
    static class Line {
        int n1, n2, idx;
        long cost;
        boolean used;
        
        Line (int n1, int n2,int cost, int idx) {
            this.cost = cost;
            this.n1= n1;
            this.n2 = n2;
            this.idx = idx;
        }
    }
    public static ArrayList<ArrayList<Load>> load;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Line> lines = new ArrayList<>(M);
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
                , Integer.parseInt(st.nextToken()), i));
        }
        
        lines.sort(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return Long.compare(o1.cost, o2.cost);
            }
        });
        
        load = new ArrayList<>(N+1);
        for (int i=0;i<=N;i++) load.add(new ArrayList<>());
        for (int i=0;i<MAX;i++) parent[i] = i;
        answer = new long[M];
        long sum = 0;
        int connectedCount = 0;
        
        for (Line line : lines) {
            if (find(line.n1) != find(line.n2)) {
                union(line.n1, line.n2);
                line.used = true;
                sum += line.cost;
                connectedCount++;
                
                load.get(line.n1).add(new Load(line.n2, line.idx));
                load.get(line.n2).add(new Load(line.n1, line.idx));
            }
        }
        
        if (connectedCount != N-1) {
            for (int i=0;i<M;i++) bw.write(-1+"\n");
            bw.flush();
            return;
        }
        replaced = new int[M];
        dfs(1, 0);
        HLD hld = new HLD(load, N);
        
        for (Line line : lines) {
            if (!line.used) {
                answer[line.idx] = sum;
                hld.update(line.n1, line.n2, (int) line.cost);
            }
        }
        for (int i=0;i<hld.chaines.length;i++) hld.chaines[i].set();
        for (Line line : lines) {
            if (line.used) {
                int k = hld.chaines[hld.mychain[replaced[line.idx]]].getSub(replaced[line.idx]);
                answer[line.idx] = k == Integer.MAX_VALUE ? -1 : sum - line.cost + k;
            }
        }
        
        for(long e : answer) bw.write(e+"\n");
        bw.flush();
    }
    public static void dfs (int node, int prev) {
        for (Load go : load.get(node)) if (go.goal != prev) {
            replaced[go.num] = go.goal;
            dfs(go.goal, node);
        }
    }
    public final static int MAX = 100001;
    public static int[] parent = new int[MAX], replaced;
    public static long[] answer;
    public static int find (int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
    
    public static void union (int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        parent[p1] = p2;
    }
}
