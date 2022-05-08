import java.util.*;

class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] Args) {
        //Get Values
        int N = s.nextInt();
        long[] arr = new long[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }

        //Get Final Value
        long ret = 0;
        for (int i = 0; i < N; i++) {
            sum -= arr[i];
            ret += sum * arr[i];
        }

        System.out.println(ret);
    }
}
