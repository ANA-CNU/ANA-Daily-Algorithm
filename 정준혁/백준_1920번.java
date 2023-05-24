package 하루하나;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_1920번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int ans = 0;
            int st = 0, end = n - 1;
            int x = sc.nextInt();
            while (st <= end) {
                int mid = (st + end) / 2;
                if (a[mid] == x) {
                    ans = 1;
                    break;
                }
                if (a[mid] > x) end = mid - 1;
                else st = mid + 1;
            }
            System.out.println(ans);
        }
    }
}
