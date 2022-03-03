import java.util.*;
import java.util.stream.Stream;

public class Main_2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] arr = sc.nextLine().split(" ");
            Integer[] arr2 = Stream.of(arr).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            Collections.sort(Arrays.asList(arr2));
            System.out.println(arr2[7]);
        }
    }
}
