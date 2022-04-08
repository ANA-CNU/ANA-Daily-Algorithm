import java.util.Arrays;
import java.util.Scanner;

public class 백준_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++){
            int a = sc.nextInt();
            arr[i] = a;
            sum += a;
        }
        boolean check = false;
        for(int i = 0; i < 9; i++){
            if(check){
                break;
            }
           for(int j = 0; j < 9; j++){
               if(i==j){
                   continue;
               }
               if(sum -arr[i] -arr[j] == 100){
                   arr[i] = -1;
                   arr[j] = -1;
                   check = true;
                   break;
               }
           }
        }

        Arrays.sort(arr);

        for(int i=0; i<9; i++) {
			if(arr[i]!=-1) {
				System.out.println(arr[i]);
			}
		}

        sc.close();
    }
}
