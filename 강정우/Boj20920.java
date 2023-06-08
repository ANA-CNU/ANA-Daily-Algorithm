import java.io.*;
import java.util.*;
public class Boj20920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() >= size) {
                set.add(s);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, (a, b) -> {
            if (map.get(b) != map.get(a)) {
                return map.get(b) - map.get(a);
            } else if (b.length() != a.length()) {
                return b.length() - a.length();
            } else {
                return a.compareTo(b);
            }
        });


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : list) {
            bw.write(s + "\n");
        }
        bw.flush();
        br.close();
    }
}
