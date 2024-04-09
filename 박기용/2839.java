import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int weight = sc.nextInt();
        int first = weight;
        int box = 0;

        switch (weight % 15) {
            case 0:
            case 5:
            case 10:
                box = weight / 5;
                break;
            case 2:
            case 7:
            case 12:
                while (weight >= 17) {
                    weight -= 5;
                    box++;
                }
                box += 4;
                break;
            case 3:
            case 13:
                while (weight >= 8) {
                    weight -= 5;
                    box++;
                }
                box += 1;
                break;
            case 1:
            case 6:
            case 8:
            case 11:
                while (weight >= 10) {
                    weight -= 5;
                    box++;
                }
                box += 2;
                break;
            case 4:
            case 9:
            case 14:
                while (weight >= 14) {
                    weight -= 5;
                    box++;
                }
                box += 3;
                break;
            default:
                box = -1;
        }

        if (first == 1 || first == 2 || first == 4 || first == 7) {
            box = -1;
        }

        System.out.println(box);
    }
}
