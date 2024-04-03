import java.util.*;

public class Main16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result = a*b*c;
        int[] zenine = new int[10];
        String res = Integer.toString(result);
        int[] eachres = new int[res.length()];
        double[] sq = new double[res.length()];

        for (double j = 0; j < res.length(); j++) {
            int g = (int) j;
            sq[g] = Math.pow(10, j);
        }

        for (int i = 0; i < res.length(); i++) {
            int g = (int) sq[i];
            eachres[i] = result/g%10;
        }

        for (int i = 0; i < res.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (eachres[i] == j) {
                    zenine[j]++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(zenine[i]);
        }
    }
}
