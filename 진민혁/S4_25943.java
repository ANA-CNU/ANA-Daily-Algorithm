import java.util.Scanner;
public class S4_25943 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		// 자갈 무게 입력받기
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		// 1번 자갈은 왼쪽, 2번 자갈은 오른쪽
		int leftsum = arr[0];
		int rightsum = arr[1];
		// 3번~N번 자갈을 올려놓기
		// 무게가 같거나 왼쪽이 가벼우면 왼쪽, 오른쪽이 가벼우면 오른쪽 
		for(int i=2; i<n; i++) {
			if(leftsum == rightsum) {
				leftsum += arr[i];
			}
			else if(leftsum>rightsum) {
				rightsum += arr[i];
			}
			else if(leftsum<rightsum) {
				leftsum += arr[i];
			}
		}
		//무게추 내림차순
		int weight[] = new int[] {100,50,20,10,5,2,1};
		int cnt = 0;
		
		if(leftsum > rightsum) {
			int abs = leftsum - rightsum;
			for(int i=0; i<weight.length; i++) {
				if(abs<weight[i])
					continue;
				if(abs>=weight[i]) {
					for(; ;) {
						abs -= weight[i];
						cnt ++;
						if(abs<weight[i])
							break;
					}
				}
			}
		}
		
		if(leftsum < rightsum) {
			int abs = rightsum - leftsum;
			for(int i=0; i<weight.length; i++) {
				if(abs>=weight[i]) {
					for(; ;) {
						abs -= weight[i];
						cnt ++;
						if(abs<weight[i])
							break;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
