import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int x, y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Seg {
    class Node {
        private long max, left, right, sum;

        Node (long value) {
            left = right = sum = value;
            max = Math.max(0, value);
        }

        public void set (long value) {
            left = right = sum = value;
            max = Math.max(0, value);
        }
    }

    public Node mkNode (Node res, Node left, Node right) {
        res.max = Math.max(left.max, right.max);
        res.max = Math.max(res.max, left.right + right.left);
        res.sum = left.sum + right.sum;
        res.left = Math.max(left.left, left.sum + right.left);
        res.right = Math.max(right.right, right.sum + left.right);
        return res;
    }

    private Node[] tree;
    private int start = 1;

    Seg (int size) {
        while(start < size) start <<= 1;
        tree = new Node[start << 1];
        for (int i=0;i<tree.length;i++) tree[i]=  new Node(0);
    }

    public void clear () {
        for (int i=0;i<tree.length;i++) tree[i].set(0);
    }

    public void update (int idx, int value) {
        tree[start + idx - 1].set(tree[start + idx -  1].sum + value);
        for (int i=start + idx - 1>> 1;i!=0;i>>=1)
            mkNode(tree[i], tree[i << 1], tree[i << 1 | 1]);
    }

    public long getAnswer () {
        return tree[1].max;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> xs = new HashSet<>(), ys = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        Pair[] plus = new Pair[N];
        for (int i=0;i<N;i++) {
            StringTokenizer st=  new StringTokenizer(br.readLine());
            plus[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            xs.add(plus[i].x); ys.add(plus[i].y);
        }

        int M = Integer.parseInt(br.readLine());
        Pair[] minus = new Pair[M];
        for (int i=0;i<M;i++) {
            StringTokenizer st=  new StringTokenizer(br.readLine());
            minus[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            xs.add(minus[i].x); ys.add(minus[i].y);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int P = Integer.parseInt(st.nextToken()), PM = Integer.parseInt(st.nextToken());


        ArrayList<Integer> sortX = new ArrayList<>(xs), sortY = new ArrayList<>(ys);
        Collections.sort(sortX);
        Collections.sort(sortY);

        HashMap<Integer, Integer> comX = new HashMap<>(), comY = new HashMap<>();
        for (int i=0;i<sortX.size();i++) comX.put(sortX.get(i), i+1);
        for (int i=0;i<sortY.size();i++) comY.put(sortY.get(i), i+1);

        ArrayList<ArrayList<Pair>> points = new ArrayList<>(2100);
        for (int i=0;i<2100;i++) points.add(new ArrayList<>());

        for (int i=0;i<plus.length;i++) {
            plus[i].x = comX.get(plus[i].x);
            plus[i].y = comY.get(plus[i].y);
            points.get(plus[i].y).add(new Pair(plus[i].x, P));
        }

        for (int i=0;i<minus.length;i++) {
            minus[i].x = comX.get(minus[i].x);
            minus[i].y = comY.get(minus[i].y);
            points.get(minus[i].y).add(new Pair(minus[i].x, -PM));
        }

        Seg tree= new Seg(3000);

        long ans = 0;

        for (int i=0;i<points.size();i++) {
            tree.clear();
            for (int j=i;j<points.size();j++) {
                for (Pair query : points.get(j)) {
                    tree.update(query.x, query.y);
                }
                ans = Math.max(tree.getAnswer(), ans);
            }
        }
        System.out.println(ans);
    }
}
