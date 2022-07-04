import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] Args) throws IOException {
        int t = sc.nextInt();
        sc.nextLine();
        int cnt = 0;
        for (int i = 0; i < t; i++) {
            cnt += fun();
        }
        System.out.println(cnt);
    }

    static int fun() {
        char[] input = sc.nextLine().toCharArray();
        char pre = input[0];
        int cnt = 0;
        ArrayList<Character> list = new ArrayList<>();
        list.add(input[0]);
        for (char c : input) {
            if (c == pre)
                continue;
            if (list.contains(c))
                return 0;
            list.add(c);
            pre = c;
        }
        return 1;
    }
}