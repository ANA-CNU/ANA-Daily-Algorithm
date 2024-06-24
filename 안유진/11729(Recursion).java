import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Pair> arrayList;
    public static void move(int current, int source, int dest, int aux) {
        if(current == 1) {
            arrayList.add(new Pair(source, dest));
        }else{
            move(current - 1, source, aux, dest);
            arrayList.add(new Pair(source, dest));
            move(current - 1, aux, dest, source);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList<>();

        move(N, 1, 3, 2);

        System.out.println(arrayList.size());

        StringBuilder sb = new StringBuilder();
        for(Pair p : arrayList) {
            sb.append(p.from).append(" ");
            sb.append(p.to).append('\n');
        }

        System.out.println(sb);
    }
}

class Pair{
    int from;
    int to;
    Pair(int f, int t) {
        from = f;
        to = t;
    }
}

