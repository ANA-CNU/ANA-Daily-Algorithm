import java.util.Scanner;


class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] Args) {
        int N = s.nextInt();
        int[][] list = new int[N][2];
        int[] rank = new int[N];
        for(int i = 0; i < N ; i++) {
            list[i][0] = s.nextInt();
            list[i][1] = s.nextInt();
            rank[i] = N+1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                boolean weight = list[i][0] >= list[j][0];
                boolean height = list[i][1] >= list[j][1];
                if(weight || height) {
                    rank[i]--;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(rank[i] +" ");
        }
    }
}