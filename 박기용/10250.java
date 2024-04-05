import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] room = new int[num];

        for (int i = 0; i < num; i++) {
            int row = sc.nextInt();
            int column = sc.nextInt();
            int person = sc.nextInt();

            int[][] hotel = new int[row][column];

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    hotel[j][k] = k + 1;
                }
            }

            for (int j = row; j > 0; j--) {
                for (int k = 0; k < column; k++) {
                    hotel[j - 1][k] += (row - j + 1) * 100;
                }
            }

            if (person%row == 0) {
                room[i] = hotel[0][person/row - 1];
            } else {
                room[i] = hotel[row - person%row][person/row];
            }
        }

        for (int i = 0; i < room.length; i++) {
            System.out.println(room[i]);
        }
    }
}
