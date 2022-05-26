import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Character> list = new ArrayList<>();
    static {
        list.add('U');
        list.add('C');
        list.add('P');
        list.add('C');
    }

    public static void main(String[] Args) throws IOException {
        String s = br.readLine();
        for (int i = 0; i < s.length() && list.size() != 0; i++) {
            char tar = list.get(0);
            if(tar == s.charAt(i))
                list.remove(0);
        }

        if(list.size() == 0) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}