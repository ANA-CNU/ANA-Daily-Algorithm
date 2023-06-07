package sec14;

import java.util.Scanner;

public class BT15649 {
    static int[] arr = new int[9];
    static boolean[] isVisit = new boolean[9];
    // 입력값 범위가 1~8이므로 사이즈를 9로 잡음
    static int a, b;

    public static void res(int cnt){ // cnt개까지 선택한 상황에서 다음 숫자를 선택
        if(cnt==b){ // 이미 b개 까지 선택했으면 출력
            for(int i=0; i<b; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= a; i++) { // 1부터 a까지의 수에 대해서
                if (!isVisit[i]) { // 해당 숫자를 이미 방문하지 않았으면
                    arr[cnt] = i;
                    isVisit[i] = true; // 선택한 목록에 추가하고 방문을 표시
                    res(cnt + 1); // 다음 숫자를 선택하러 넘김
                    isVisit[i] = false; // 탐색이 끝났으면 다시 방문을 지움
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();

        res(0); //0번째를 선택부터 시작
    }
}
