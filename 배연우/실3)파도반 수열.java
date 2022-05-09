import java.util.Scanner;

class Main {
    static Scanner s = new Scanner(System.in);
    static long[] ans;
    public static void main(String[] Args) {
        int re = s.nextInt();
        for(long j = 0; j < re; j++) {
            int tar = s.nextInt();
            ans = tar < 5? new long[5] : new long[tar];
            for (int i = 0; i < 3; i++) {
                ans[i] = 1;
            }
            ans[3] = 2;
            ans[4] = 2;
            bf(tar - 1);
            System.out.println(ans[tar - 1]);
        }
    }

    static void bf(int tar) {
        if(tar<5) {
            return;
        }
        if(ans[tar-1]!=0 && ans[tar-5]!=0) {
            ans[tar] = ans[tar-1] + ans[tar-5];
            return;
        }
        bf(tar-1);
        bf(tar-5);
        ans[tar] = ans[tar-1] + ans[tar-5];
    }
}
