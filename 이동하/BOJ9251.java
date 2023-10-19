import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String one = br.readLine();
        String two = br.readLine();
        char[] longer;
        char[] shorter;
        if (one.length() > two.length()) {
            longer = one.toCharArray();
            shorter = two.toCharArray();
        } else {
            longer = two.toCharArray();
            shorter = one.toCharArray();
        }
        int[][] dynamic = new int[longer.length+1][shorter.length+1];
        for (int i = 1; i <= longer.length; i++) {
            for (int j = 1; j < shorter.length+1; j++) {
                if (longer[i-1] == shorter[j-1]) {
                    dynamic[i][j] = dynamic[i-1][j-1];
                    dynamic[i][j]++;
                } else {
                    dynamic[i][j] = Math.max(dynamic[i][j-1],dynamic[i-1][j]);
                }
            }
        }
//        for (int i = 0; i < longer.length+1; i++) {
//            System.out.println(Arrays.toString(dynamic[i]));
//        }
        System.out.println(dynamic[dynamic.length-1][dynamic[0].length-1]);
    }
}