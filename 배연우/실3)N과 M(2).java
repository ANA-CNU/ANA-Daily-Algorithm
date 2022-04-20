import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    static int M, N;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        M = s.nextInt();
        N = s.nextInt();

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = M; i >= 1; i--) {
            stack.add(i);
        }
        while(!stack.empty()) {
            int tar = stack.pop();
            if(tar == 0) {
                ans.remove(ans.size()-1);
                continue;
            }

            ans.add(tar);

            if(ans.size() == N) {
                for (Integer an : ans) {
                    System.out.print(an + " ");
                }
                System.out.println();
            }

            stack.add(0);

            for(int i = M; i >= 1; i--) {
                if(tar < i) {
                    stack.add(i);
                }
            }

        }
    }
}