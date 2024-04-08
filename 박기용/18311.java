import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int course = sc.nextInt();
        long move = sc.nextLong();
        long[] eachcourse = new long[course];

        for (int i = 0; i < course; i++) {
            eachcourse[i] = sc.nextLong();
        }

        int whatcourse = 0;

        for (int i = 0; i < course; i++) {
            move -= eachcourse[i];
            if (move == 0) {
                if (i == course - 1) {
                    whatcourse = i + 1;
                } else {
                    whatcourse = i + 2;
                }
                break;
            }

            if (move < 0) {
                whatcourse = i + 1;
                break;
            }
        }

        if (move > 0) {
            for (int i = course; i > 0; i--) {
                move -= eachcourse[i - 1];
                if (move == 0) {
                    if (i == 1) {
                        whatcourse = i;
                    } else {
                        whatcourse = i - 1;
                    }
                    break;
                }

                if (move < 0) {
                    whatcourse = i;
                    break;
                }
            }
        }

        System.out.println(whatcourse);
    }
}
