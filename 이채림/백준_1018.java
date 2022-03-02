import java.util.Scanner;

public class 백준_1018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] array = new int[50][50];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'W') {
					array[i][j] = 1;
				} else {
					array[i][j] = 2;
				}

			}
		}
		
		// 체스 정답 입력
		int[][] answer1 = new int[8][8];
		int[][] answer2 = new int[8][8];

		int[] pattern1 = { 1, 2, 1, 2, 1, 2, 1, 2 };
		int[] pattern2 = { 2, 1, 2, 1, 2, 1, 2, 1 };

		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) { // 짝수번째 인덱스
				answer1[i] = pattern1;
				answer2[i] = pattern2;
			} else {
				answer1[i] = pattern2;
				answer2[i] = pattern1;
			}
		}

		// 체스판 찾기
		
		int row = N-7;
		int col = M-7;
		int mini = 64;
		
		for(int k = 0; k < row; k++) {
			for(int p = 0; p < col; p++) {
				
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (array[i+k][j+p] != answer1[i][j]) {
							sum1 += 1;
							
						}
						if(array[i+k][j+p] != answer2[i][j]) {
							sum2 += 1;
						}
					}
				}
				int temp = Math.min(sum1, sum2);
				mini = Math.min(mini, temp);
			}
			
		}

		System.out.println(mini);

	}
}