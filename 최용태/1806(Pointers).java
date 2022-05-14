import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = sc.nextInt();
		int least = 111111;
		int start=1;
		int end=1;
		int s=0;
		int[] a = new int[N+1];
		int[] p = new int[N+1];
		
		
		for (int i = 1; i < N+1; i++) {
			a[i] = sc.nextInt();
			p[i]=p[i-1]+a[i];
			s+=a[i];
		}
		if(s<result)
			System.out.println(0);
		else {
		while (end < N+1 && start < N+1) {
			int sum = 0;
			sum += p[end]-p[start-1];
				
			if (sum >= result) {
				int count=end-(start-1);
				if(count<least)
					least=count;
				start++;
			}
			else if (sum < result)
				end++;
		}

		System.out.println(least);
		}
	}
}