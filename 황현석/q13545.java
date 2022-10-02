import java.io.*;
import java.util.*;

class Query {
    int left, right, idx;
    int mos;
    Query (int left, int right, int idx) {
        this.left = left;
        this.right = right+1;
        this.idx = idx;
        mos = left / 400;
    }
}

public class Main {
    public static int N, start = 1;
    public static int[] origin, prefix;
    public static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        origin = new int[N]; prefix = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(start < 200050) start <<= 1;
        tree = new int[start << 1];

        for (int i=0;i<N;i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            prefix[i+1] = prefix[i] + origin[i];
        }
        for (int i=0;i<prefix.length;i++) prefix[i] += 100000;

        int M = Integer.parseInt(br.readLine());
        ArrayList<Query> queries = new ArrayList<>(M);

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            queries.add(new Query(Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken()), i));
        }

        queries.sort(new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                if (o1.mos == o2.mos) return Integer.compare(o1.right, o2.right);
                return Integer.compare(o1.mos, o2.mos);
            }
        });
        int mos=-1, l = -1, r = -1;
        for (int i=0;i<decks.length;i++) decks[i] = new LinkedList<>();
        int[] answer = new int[queries.size()];

        for (Query query : queries) {
            if (mos != query.mos) {
                mos = query.mos;
                clear();

                for (int i=query.left-1;i< query.right;i++) {
                    add(prefix[i], i);
                }
                answer[query.idx] = tree[1];
            } else {
                for (int i=r;i<query.right;i++) {
                    add(prefix[i], i);
                }

                if (l < query.left) {
                    for (int i=l-1;i<query.left-1;i++) {
                        pop(prefix[i], i);
                    }
                } else {
                    for (int i=l-2;i>=query.left-1;i--) {
                        add(prefix[i], i);
                    }

                }

                answer[query.idx] = tree[1];
            }

            l = query.left;
            r = query.right;
        }

        BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
        for (int e : answer) bw.write(e+"\n");
        bw.flush();

    }
    public static Deque<Integer>[] decks = new Deque[200050];
    public static void update(int idx, int num) {
        idx = idx + start;
        tree[idx] = num;
        while((idx >>= 1) != 0) {
            tree[idx] = Math.max(tree[idx<<1], tree[idx*2+1]);
        }
    }

    public static void clear () {
        Arrays.fill(tree, 0);
        for (Deque<Integer> d : decks) d.clear();
    }
    public static void add (int num, int idx) {
        if (decks[num].isEmpty()) {
            decks[num].offer(idx);
        } else {
            if (decks[num].peekLast() < idx) {
                decks[num].offerLast(idx);
            } else {
                decks[num].offerFirst(idx);
            }
            update(num, decks[num].peekLast() - decks[num].peekFirst());
        }

    }
    public static void pop (int num, int idx) {
        if (decks[num].size() == 1) {
            decks[num].clear();
        } else {
            if (decks[num].peekLast() == idx) {
                decks[num].pollLast();
            } else decks[num].pollFirst();

            update(num, decks[num].peekLast() - decks[num].peekFirst());
        }
    }
}
