import java.util.HashSet;
import java.util.Scanner;

public class Main_14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();

        int n = Integer.parseInt(sc.nextLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            int cowNum = Integer.parseInt(input.split(" ")[0]);
            int locationNum = Integer.parseInt(input.split(" ")[1]);

            if (locationNum == 0) {
                if (right.contains(cowNum)) {
                    right.remove(cowNum);
                    left.add(cowNum);
                    count++;
                } else {
                    left.add(cowNum);
                }
            } else {
                if (left.contains(cowNum)) {
                    left.remove(cowNum);
                    right.add(cowNum);
                    count++;
                } else {
                    right.add(cowNum);
                }
            }
        }

        System.out.println(count);
    }
}
