import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();
        String[][] calendar = new String[12][];
        calendar[0] = new String[31]; calendar[1] = new String[28]; calendar[2] = new String[31]; calendar[3] = new String[30]; calendar[4] = new String[31]; calendar[5] = new String[30]; calendar[6] = new String[31]; calendar[7] = new String[31]; calendar[8] = new String[30]; calendar[9] = new String[31]; calendar[10] = new String[30]; calendar[11] = new String[31];
        int count = 1;

        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                switch (count%7) {
                    case 1:
                        calendar[i][j] = "MON";
                        break;
                    case 2:
                        calendar[i][j] = "TUE";
                        break;
                    case 3:
                        calendar[i][j] = "WED";
                        break;
                    case 4:
                        calendar[i][j] = "THU";
                        break;
                    case 5:
                        calendar[i][j] = "FRI";
                        break;
                    case 6:
                        calendar[i][j] = "SAT";
                        break;
                    case 0:
                        calendar[i][j] = "SUN";
                        break;
                }
                count++;
            }
        }

        System.out.println(calendar[month - 1][day - 1]);
    }
}
