import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] Args) throws IOException {
        char[] arr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[arr.length-1-i]);
        }
        System.out.println(sb);
    }
}