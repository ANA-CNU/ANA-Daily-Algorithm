import java.util.*;
import java.io.*;

public class Main {
    static TreeSet<String> notListened = new TreeSet<>();
    static TreeSet<String> notListenedAndSaw = new TreeSet<>();
    public static void main(String[] Args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            notListened.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            boolean isListened = notListened.remove(str);
            if(isListened) {
                notListenedAndSaw.add(str);
            }
        }

        int size = notListenedAndSaw.size();
        System.out.println(size);
        for(int i = 0; i < size; i++) {
            String tar = notListenedAndSaw.first();
            System.out.println(tar);
            notListenedAndSaw.remove(tar);
        }
    }
}