import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int column = sc.nextInt();
        sc.nextLine();

        char[][] chessboard = new char[row][column];

        for (int i = 0; i < row; i++) {
            chessboard[i] = sc.nextLine().toCharArray();
        }

        int min1 = 65;
        int min2 = 65;

        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < column - 7; j++) {
                int count1 = 0;
                int count2 = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if ((k + l) % 2 == 0) {
                            if (chessboard[i + k][j + l] == 'B') {
                                count1++;
                            } else {
                                count2++;
                            }
                        } else {
                            if (chessboard[i + k][j + l] == 'W') {
                                count1++;
                            } else {
                                count2++;
                            }
                        }
                    }
                }
                min1 = Math.min(min1, count1);
                min2 = Math.min(min2, count2);
            }
        }

        int min = Math.min(min1, min2);

        System.out.println(min);
    }
}
