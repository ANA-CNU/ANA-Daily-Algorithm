import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int tst = s.nextInt();

        for (int i = 0; i < tst; i++) {
            tur[] arr = new tur[2];
            for (int j = 0; j < 2; j++) {
                int x = s.nextInt();
                int y = s.nextInt();
                int r = s.nextInt();
                arr[j] = new tur(x,y,r);
            }

            if(arr[0].x == arr[1].x && arr[0].y == arr[1].y) {
                if(arr[0].r == arr[1].r) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
                continue;
            }

            int max = Math.max(arr[0].r, arr[1].r);
            double d = Math.sqrt(Math.pow(arr[0].x - arr[1].x,2) +
                    Math.pow(arr[0].y - arr[1].y, 2));
            if(d < max) {
                //원의 중심이 안에 있다.
                int min = Math.min(arr[0].r, arr[1].r);
                if(d + min > max) {
                    System.out.println(2);
                } else if(d + min == max) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(d == max) {
                System.out.println(2);
            } else {
                //원의 중심이 밖에 었다.
                int sum = arr[0].r + arr[1].r;
                if(d < sum) {
                    System.out.println(2);
                } else if(d == sum) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}

class tur{
    int x;
    int y;
    int r;

    public tur(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
