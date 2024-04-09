import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = sc.nextInt();
        int d = sc.nextInt();

        int A = a*d + b*c;
        int B = b*d;

        if ( A > B ) {
            for ( int i = 2 ; i <= B ; ) {
                if ( A % i == 0 && B % i == 0 ) {
                    A /= i;
                    B /= i;
                }
                else
                i++;
            }
        }
        else if ( A < B ){
            for ( int i = 2 ; i <= A ; ) {
                if ( A % i == 0 && B % i == 0 ) {
                    A /= i;
                    B /= i;
                }
                else
                i++;
            }
        }
        else {
            A = 1;
            B = 1;
        }
        System.out.print(A + " " + B);
    }
}