import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] in;
    public static void main(String[] Args) throws IOException {
        //input
        in = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();

        //select and test
        String best = "z".repeat(50);
        for (int i = 0; i < in.length-2; i++) {
            for (int j = i+1; j < in.length-1; j++) {
                String tar = getString(i,j);

                //compare
                if(tar.compareTo(best) < 0) {
                    best = tar;
                }
            }
        }

        //output
        System.out.println(best);
    }

    static String getString(int i, int j) {
        String first = flip(Arrays.copyOfRange(in, 0, i+1));
        String second = flip(Arrays.copyOfRange(in, i+1,j+1));
        String third = flip(Arrays.copyOfRange(in, j+1, in.length));
        return first+second+third;
    }

    static String flip(char[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int tar = arr.length -1 -i;
            char tmp = arr[i];
            arr[i] = arr[tar];
            arr[tar] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}