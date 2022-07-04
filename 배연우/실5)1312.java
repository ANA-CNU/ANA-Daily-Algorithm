import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] Args) throws IOException {
        //input
        int denominator, numerator, tar;
        st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        numerator = stoi();
        denominator = stoi();
        tar = stoi();

        //calculate
        numerator %= denominator;
        int ret = 0;
        for (int i = 0; i < tar; i++) {
            numerator *= 10;
            ret = numerator / denominator;
            numerator %= denominator;
        }

        //output
        System.out.println(ret);
    }
    static int stoi() {
        return Integer.parseInt(st.nextToken());
    }
}