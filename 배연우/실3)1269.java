import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] Args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = stoi(st);
        int B = stoi(st);
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) {
            aSet.add(stoi(st));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            bSet.add(stoi(st));
        }

        Set<Integer> a_b = new HashSet<>(aSet);
        Iterator iterB = bSet.iterator();
        for(int i = 0; i < B; i++) {
            a_b.remove(iterB.next());
        }

        Set<Integer> b_a = new HashSet<>(bSet);
        Iterator iterA = aSet.iterator();
        while(iterA.hasNext()) {
            b_a.remove(iterA.next());
        }

        Set<Integer> finalSet = new HashSet<>(a_b);
        Iterator iterB_A = b_a.iterator();
        while(iterB_A.hasNext()) {
            finalSet.add((Integer)iterB_A.next());
        }

        System.out.println(finalSet.size());
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}