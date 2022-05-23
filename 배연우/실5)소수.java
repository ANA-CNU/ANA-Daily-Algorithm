import java.util.Scanner;

class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int M = s.nextInt();
        int N = s.nextInt();
        int[] arr = new int[N+1];
        /* Rule : arr[x] == 0 => NULL */
        //배열에 값 넣기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        //걸러내기
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0 || arr[i] == 1) {
                continue;
            }
            for (int j = i*2; j <= N; j+=i) {
                arr[j] = 0;
            }
        }

        //최솟값과 합 구하기
        int sum = 0;
        int min = 0;
        for (int i = M; i <= N; i++) {
            if(arr[i] != 0 && arr[i] != 1) {
                sum += arr[i];
                if(min == 0) {
                    min = arr[i];
                }
            }
        }

        if(min == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}