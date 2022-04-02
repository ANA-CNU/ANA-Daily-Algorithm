import java.util.Scanner;

public class Q_1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 0;
		n = sc.nextInt();
		double[] score = new double[n];
		double[] nscore = new double[n];
		double a = 0.0;
		double sum = 0;
		for (int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
		}
		double max = score[0];
		for (int i = 0; i < n; i++) {
			if (max < score[i]) {
				max = score[i];
			}
		}
		for (int i = 0; i < n; i++) {
			// nscore[i] = score[i] / max;
			a = (score[i] / max) * 100;
			sum += a;
		}
		//double result = Math.round(sum/n*100)/100.0; # 소수점 둘째짜리
		System.out.println(sum/n);
	}

}
