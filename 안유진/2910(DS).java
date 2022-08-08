import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Triplet implements Comparable<Triplet>{
    int value;
    int frequency;
    int index;

    public Triplet(int v, int f, int i) {
        value = v;
        frequency = f;
        index = i;
    }

    @Override
    public int compareTo(Triplet t) {
        if (frequency == t.frequency) {
            return index - t.index;
        }
        return t.frequency - frequency;
    }
}

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, Integer> location = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!frequency.containsKey(num)){
                frequency.put(num, 1);
            }else{
                frequency.put(num, frequency.get(num) + 1);
            }

            if(!location.containsKey(num)){
                location.put(num, i);
            }
        }
        ArrayList<Triplet> s = new ArrayList<>();
        for (int v : frequency.keySet()) {
            int f = frequency.get(v);
            int i = location.get(v);
            Triplet t = new Triplet(v, f, i);
            s.add(t);
        }

        Collections.sort(s);
        for (Triplet t : s) {
            for (int i = 0; i < t.frequency; i++) {
                sb.append(t.value).append(" ");
            }
        }
        System.out.println(sb);
    }
}
