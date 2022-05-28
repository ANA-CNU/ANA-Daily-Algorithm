import java.lang.reflect.Executable;
import java.util.*;
import java.io.*;

public class Main {
    static Set<String> set = new HashSet<>();
    public static void main(String[] Args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String input = br.readLine();

        char[] chars = new char[input.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = input.charAt(i);
        }

        for (int i = 1; i <= chars.length; i++) {
            for (int j = 0; j <= chars.length - i; j++) {
                set.add(new String(Arrays.copyOfRange(chars, j, j+i)));
            }
        }

        System.out.println(set.size());
    }
    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}