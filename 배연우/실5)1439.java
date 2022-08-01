import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] Args) throws IOException {
        char[] arr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        int curr = arr[0];
        int zero = 0;
        int one = 0;
        if(curr == '1')
            one++;
        else
            zero++;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != curr) {
                if(arr[i] == '1')
                    one++;
                else
                    zero++;
                curr = arr[i];
            }
        }
        System.out.println(Math.min(zero, one));
    }
}