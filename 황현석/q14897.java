import java.io.*;
import java.util.*;

class Query {
    int left, right, idx;
    int start;
    Query(int l, int r, int i) {
        left = l;
        right = r;
        idx = i;
        start = left/ 400;
    }
}

public class Main {
    public static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hs.add(arr[i]);
        }

        ArrayList<Integer> press = new ArrayList<>(hs);
        Collections.sort(press);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0;i<press.size();i++) hm.put(press.get(i), i+1);

        for (int i=0;i<arr.length;i++) arr[i] = hm.get(arr[i]);

        num = new int[press.size()+10];

        int M = Integer.parseInt(br.readLine());
        int[] answer = new int[M];
        ArrayList<Query> queries = new ArrayList<>(M);
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            queries.add(new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }

        queries.sort(new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                if (o1.start == o2.start) return Integer.compare(o1.right, o2.right);
                return Integer.compare(o1.start, o2.start);
            }
        });
        int start = -1, l = -1, r = -1;

        for (Query query : queries) {
            if (start != query.start) {
                start = query.start;

                Arrays.fill(num, 0);
                v = 0;

                for (int i= query.left-1;i< query.right;i++) {
                    add(arr[i]);
                }
                answer[query.idx] = v;
            } else {
                for (int i=r;i< query.right;i++) {
                    add(arr[i]);
                }

                if (l < query.left) {
                    for (int i=l-1;i< query.left-1;i++) {
                        pop(arr[i]);
                    }
                } else {
                    for (int i= query.left-1;i<l-1;i++) {
                        add(arr[i]);
                    }
                }
                answer[query.idx] = v;

            }
            l = query.left;
            r = query.right;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int e : answer) bw.write(e+"\n");
        bw.flush();
    }
    public static int v;
    public static void add (int n) {
        if (num[n]++ == 0) {
            v++;
        }
    }

    public static void pop (int n) {
        if (num[n]--==1) {
            v--;
        }
    }
}
