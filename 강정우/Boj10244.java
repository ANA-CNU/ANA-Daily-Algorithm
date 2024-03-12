import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boj10244 {
    static int n;
    static Set<Integer> set;
    static List<Integer> arr;

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while (n != 0) {
            arr = new ArrayList<>();
            set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(br.readLine()));
                set.add(arr.get(i));
            }
            while(arr.size()>1){
                Set<Integer> tmp = new HashSet<>();
                for(int i=0; i<arr.size()-1; i++){
                    int gcd = gcd(arr.get(i), arr.get(i+1));
                    set.add(gcd);
                    tmp.add(gcd);
                }
                arr = new ArrayList<>(tmp);
            }
            System.out.println(set.size());
            n = Integer.parseInt(br.readLine());
        }
    }
}
