import com.sun.jdi.Value;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static HashSet<Integer> notVisited=new HashSet<>();

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        notVisited.remove(start);

        while (!q.isEmpty()) {
            int here = q.poll();
            for (int i = 0; i < graph.get(here).size(); i++) {
                int there=graph.get(here).get(i);
                if(notVisited.contains(there)){
                    notVisited.remove(there);
                    q.offer(there);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        IntStream.range(0, N + 1).forEach(i ->{
            graph.add(new ArrayList<>());
            notVisited.add(i);
        });

        notVisited.remove(0);

        for (int i = 0; i < N - 2; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(s.nextToken());
            int e = Integer.parseInt(s.nextToken());

            graph.get(f).add(e);
            graph.get(e).add(f);
        }

        bfs(1);
        System.out.println(1+" "+notVisited.stream().findFirst().get());
    }
}

