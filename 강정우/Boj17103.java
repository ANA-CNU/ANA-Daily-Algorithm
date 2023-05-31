import java.util.*;

class Boj17103{
    static boolean[] chae(int n) {
    boolean[] arr = new boolean[n + 1];
    arr[0] = arr[1] = true;
    for (int i = 2; i * i <= n; i++) {
        if (!arr[i]) {
            for (int j = i * i; j <= n; j += i) arr[j] = true;
        }
    }
    return arr;
}

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxLimit = 1000000;
        boolean[] primeArr = chae(maxLimit);
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int sum = 0;
            for (int j = 2; j <= k / 2; j++) {
                if (!primeArr[j] && !primeArr[k - j]) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
