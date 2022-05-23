import javax.swing.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

class Main {
    static Scanner s = new Scanner(System.in);
    static Stack<String> stack;
    public static void main(String[] Args) {

        StringArray st = new StringArray(s.nextLine());
        stack = new Stack<>();
        stack.push(st.nextToken());
        while(st.hasMoreTokens()) {

            String s = st.nextToken();
            if(s.equals("]")) {
                calculate("[", 3);
            } else if(s.equals(")")) {
                calculate("(", 2);
            } else {
                stack.push(s);
            }
        }
        finale();
    }

    static void exit() {
        System.out.println(0);
        System.exit(0);
    }

    static void calculate(String tar, int product) {
        int sum = 0;
        try {
            while(true) {
                String t = stack.pop();
                try {
                    sum += Integer.parseInt(t);
                } catch (Exception e) {
                    if(!t.equals(tar)) {
                        exit();
                    }
                    if(sum == 0) { stack.push(String.valueOf(product)); }
                    else { stack.push(String.valueOf(product * sum)); }
                    return;
                }
            }
        } catch (Exception e) {
            exit();
        }
    }

    static void finale() {
        try {
            int sum = 0;
            while(!stack.empty()) {
                sum+= Integer.parseInt(stack.pop());
            }
            System.out.println(sum);
        } catch (Exception e) {
            exit();
        }
    }
}

class StringArray {
    String[] value;
    int loc = 0;
    StringArray(String tar) {
        value = tar.split("");
    }

    String nextToken() {
        return value[loc++];
    }

    boolean hasMoreTokens() {
        return value.length != loc;
    }
}