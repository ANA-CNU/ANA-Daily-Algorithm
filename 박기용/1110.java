import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int result = num;
        int cycle = 0;

        do {
            String to_s = Integer.toString(num);
            String[] split = to_s.split("");

            if (to_s.length() == 1) {
                int i10 = Integer.parseInt(to_s) * 10;
                int i1 = Integer.parseInt(to_s);
                num = i1 + i10;
            } else {
                int i10 = Integer.parseInt(split[1]) * 10;
                int i1 = (Integer.parseInt(split[0]) + Integer.parseInt(split[1])) % 10;
                num = i1 + i10;
            }

            cycle++;
        } while (num != result) ;

        System.out.println(cycle);
    }
}
