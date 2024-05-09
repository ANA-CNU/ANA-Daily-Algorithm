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
        } // 입력값을 다 넣기

        int min1 = 65;

        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < column - 7; j++) {
                int count = 0;
                for (int k = 0; k < 8; k += 2) {
                    for (int l = 0; l < 8; l += 2) {
                        if (chessboard[i + k][j + l] == 'B') {
                            count++;
                        }
                    }
                }
                for (int k = 1; k < 8; k += 2) {
                    for (int l = 0; l < 8; l += 2) {
                        if (chessboard[i + k][j + l] == 'W') {
                            count++;
                        }
                    }
                }
                for (int k = 0; k < 8; k += 2) {
                    for (int l = 1; l < 8; l += 2) {
                        if (chessboard[i + k][j + l] == 'W') {
                            count++;
                        }
                    }
                }
                for (int k = 1; k < 8; k += 2) {
                    for (int l = 1; l < 8; l += 2) {
                        if (chessboard[i + k][j + l] == 'B') {
                            count++;
                        }
                    }
                }
                min1 = Math.min(min1, count);
            }
        }

        int min2 = 65;

        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < column - 7; j++) {
                int count = 0;
                for (int k = 0; k < 8; k += 2) {
                    for (int l = 0; l < 8; l += 2) {
                        if (chessboard[i + k][j + l] == 'W') {
                            count++;
                        }
                    }
                }
                for (int k = 1; k < 8; k += 2) {
                    for (int l = 0; l < 8; l += 2) {
                        if (chessboard[i + k][j + l] == 'B') {
                            count++;
                        }
                    }
                }
                for (int k = 0; k < 8; k += 2) {
                    for (int l = 1; l < 8; l += 2) {
                        if (chessboard[i + k][j + l] == 'B') {
                            count++;
                        }
                    }
                }
                for (int k = 1; k < 8; k += 2) {
                    for (int l = 1; l < 8; l += 2) {
                        if (chessboard[i + k][j + l] == 'W') {
                            count++;
                        }
                    }
                }
                min2 = Math.min(min2, count);
            }
        }

        int min = Math.min(min1, min2);

        System.out.println(min);
    }
}
