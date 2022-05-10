import java.util.*;

class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] Args) {
        int a = s.nextInt();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a; i++) {
            int tar = s.nextInt();
            if(min > tar) {
                min = tar;
            }
            if(max < tar) {
                max = tar;
            }
        }

        System.out.println(min * max);
    }
}
