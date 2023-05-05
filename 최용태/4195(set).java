import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static HashMap<String, Integer> mapper;
    static HashMap<Integer, Integer> set_info;
    static HashMap<Integer, Integer> union_info;

    static int find(int c) {
        int cn = c;

        while (union_info.get(cn) != cn) {
            cn = union_info.get(cn);
        }

        return cn;
    }

    static long union(int from, int to) {
        int f1 = find(from);
        int f2 = find(to);
        int f = Math.min(f1, f2);
        int sum= set_info.get(f1) + set_info.get(f2);

        union_info.put(from,f);
        union_info.put(to,f);
        union_info.put(f1,f);
        union_info.put(f2,f);

        if(f1!=f2) {
            set_info.put(f1, sum);
            set_info.put(f2, sum);
        }

        return set_info.get(f);
    }

    static void update(String s) {
        if (!mapper.containsKey(s)) {
            int friends = mapper.size() + 1;
            mapper.put(s, friends);
            union_info.put(friends, mapper.get(s));
            set_info.put(friends, 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder writer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            mapper = new HashMap<>();
            union_info = new HashMap<>();
            set_info = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer s = new StringTokenizer(br.readLine(), " ");

                String f1 = s.nextToken();
                String f2 = s.nextToken();

                update(f1);
                update(f2);
                writer.append(union(mapper.get(f1), mapper.get(f2))).append("\n");
            }
        }
        System.out.println(writer);

    }
}