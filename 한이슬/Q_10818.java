import java.util.*;

public class Q_10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		N = sc.nextInt();
		int[] num = new int[N]; // 배열 생성
		int max, min;
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt(); // 데이터 입력 및 배열에 저장
		}
		max = num[0]; // 최대값 초기 설정
		min = num[0]; // 최소값 초기 설정
		for (int i = 0; i < num.length; i++) {
			if (max < num[i]) { // 최대값 비교
				max = num[i]; // 최대값 할당
			}
			if (min > num[i]) { // 최소값 비교
				min = num[i]; // 최대값 할당
			}
		}
		System.out.printf("%d %d", min, max);
	}

}
