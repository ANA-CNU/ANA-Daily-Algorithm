import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0;
        String b;
        
        
        while (sc.hasNext()) {
            b = sc.next();
            if (b.equals("")){
                break;
            }
            a++;
        }
        System.out.println(a);
    }
}
