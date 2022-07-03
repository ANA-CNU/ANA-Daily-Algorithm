import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] Args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        ArrayList<Integer> s = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            s.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(s);
        int n = Integer.parseInt(br.readLine());


        //calculate
        if(s.contains(n)) {
            System.out.println(0);
            return;
        }

        int ns=0, nb=0;
        for(int i : s) {
            if(i < n) {
                ns = i;
            }
            if(i > n) {
                nb = i;
                break;
            }
        }

        System.out.println((n-ns) * (nb-n) - 1);
    }
}