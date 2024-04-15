import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int floor = sc.nextInt() + 1;
            int room = sc.nextInt();

            int[][] apartment = new int[floor][room];

            for (int j = 0; j < room; j++) {
                apartment[0][j] = j + 1;
            }

            for (int j = 1; j < floor; j++) {
                for (int k = 0; k < room; k++) {
                    for (int l = 0; l <= k; l++) {
                        apartment[j][k] += apartment[j - 1][l];
                    }
                }
            }

            System.out.println(apartment[floor - 1][room - 1]);
        }
    }
}
