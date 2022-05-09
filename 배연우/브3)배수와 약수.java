import java.util.*;

class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] Args) {
        while(true) {
            int a = s.nextInt();
            int b = s.nextInt();

            if(a == b && a == 0) {
                return;
            }

            if(a % b == 0) {
                System.out.println("multiple");
            } else if(b%a == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }
    }
}
