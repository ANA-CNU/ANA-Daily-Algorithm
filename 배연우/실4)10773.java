import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        Stack<Integer> st = new Stack<>();
        int N = stoi();
        for (int i = 0; i < N; i++) {
            int tmp = stoi();
            if(tmp == 0) {
                st.pop();
                continue;
            }
            st.push(tmp);
        }

        int sum = 0;
        while(!st.empty()) {
            sum+=st.pop();
        }
        System.out.println(sum);
    }

    static int stoi() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}