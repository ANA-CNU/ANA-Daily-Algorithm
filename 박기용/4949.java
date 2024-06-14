import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        do {
            str = br.readLine();
            String[] arr = str.split("");
            Stack<String> stack = new Stack<>();
            boolean a = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("(") || arr[i].equals("[")) {
                    stack.push(arr[i]);
                } else if (arr[i].equals(")") || arr[i].equals("]")) {
                    if (stack.isEmpty()) {
                        a = false;
                    } else {
                        if (arr[i].equals(")") && stack.peek().equals("(") || arr[i].equals("]") && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            a = false;
                        }
                    }
                }
            }

            if ((stack.isEmpty() && a) && !str.equals(".")) {
                bw.write("yes");
            } else if (!str.equals(".")){
                bw.write("no");
            }
            bw.newLine();
        } while (!str.equals("."));
        bw.close();
    }
}
