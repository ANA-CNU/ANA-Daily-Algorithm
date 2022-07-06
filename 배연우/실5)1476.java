import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] Args) throws IOException {
        int E, S, M;
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        E = stoi(st)-1;
        S = stoi(st)-1;
        M = stoi(st)-1;
        int ret = 0;
        int Et = 0, St = 0, Mt = 0;

        while(E != Et || S != St || M != Mt) {
            Et++;
            St++;
            Mt++;
            ret++;
            Et %= 15;
            St %= 28;
            Mt %= 19;
        }

        System.out.println(ret+1);
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}