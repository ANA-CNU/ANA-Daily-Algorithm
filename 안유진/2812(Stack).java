import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        String s = br.readLine();

        for(int i = 0; i < N; i++) {
            int current = s.charAt(i) - '0';

            while (!stack.isEmpty() && stack.peek() < current && K > 0){
                stack.pop();
                K--;
            }

            stack.push(current);
        }

        if(K != 0){
            while (K > 0){
                stack.pop();
                K--;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>(stack);
        for(int i = 0; i < arrayList.size(); i++){
            bw.write(arrayList.get(i).toString());
        }

        bw.newLine();
        bw.flush();
    }
}
