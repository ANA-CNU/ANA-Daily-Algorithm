package grap_my_hand;

import java.util.Scanner;

public class twentyone {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int tc=0; tc<T; tc++) {
			int N = scan.nextInt();	// 지원자 숫자
			int[][] arr = new int[N][2];	// 각 지원자의 서류, 면접 성적
			int count = N;			// 선발할 수 있는 신입사원의 최대 인원수
			
			for(int i=0; i<N; i++) {
				arr[i][0] = scan.nextInt();	
				arr[i][1] = scan.nextInt();
			}
			
			// 지원자 별로 서류 or 면접 심사 판단하기
			for(int i=0; i<N; i++) {
				boolean docu = true;	// 서류심사 판단
				boolean pt = true;		// 면접심사 판단
				
				for(int j=0; j<N; j++) {	// 서류심사 성적 판단
					if(arr[i][0] < arr[j][0]) {	// 자신보다 서류 성적이 떨어지는 인원이 있을경우(숫자가 더 클경우)
						docu = false;
						break;
					}
				}
				
				for(int j=0; j<N; j++) {	// 면접심사 성적 판단
					if(arr[i][1] < arr[j][1]) {	// 자신보다 면접 성적이 떨어지는 인원이 있을경우(숫자가 더 클경우)
						pt = false;
						break;
					}
				}
				
				// 서류, 면접 성적 모두 자신보다 떨어지는 인원이 없을경우 => 선발 X
				if(docu == true && pt == true) {
					count --;
				}
			}
			
			System.out.println(count);
		}
		
		scan.close();
	}

}
