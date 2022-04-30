import java.util.Scanner;


class Main {
    static Scanner s = new Scanner(System.in);
    static int[] cards;
    static int N, M;

    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] Args) {
        N = s.nextInt();
        M = s.nextInt();
        cards = new int[N];

        for(int i = 0; i < N; i++) {
            cards[i] = s.nextInt();
        }

        for(int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= M) {
                        MAX = Math.max(MAX, sum);
                    }
                }
            }
        }

        System.out.println(MAX);
    }
}