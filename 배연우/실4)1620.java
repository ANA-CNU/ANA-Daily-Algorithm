import java.util.*;
import java.io.*;

public class Main {
    static Map<String, Integer> stoi = new HashMap<>();
    static Map<Integer, String> itos = new HashMap<>();

    public static void main(String[] Args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            stoi.put(str, i);
            itos.put(i, str);
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            try {
                int a = Integer.parseInt(input);
                System.out.println(itos.get(a));
            } catch (Exception e) {
                System.out.println(stoi.get(input));
            }
        }
    }
}