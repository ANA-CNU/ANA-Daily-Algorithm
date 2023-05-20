package 하루하나;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_2822번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] list = new int[8];
		int[] index = new int[5];
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
		}
		for (int i = 0; i < list.length; i++) {
			int tmp = 0;
			for (int k = 0; k < list.length; k++) {
				if (list[i] == list[k]) {
					tmp++;
				}
				if (list[i] > list[k]) {
					tmp++;
				}
			}
			if (tmp == 8) {
				sum += list[i];
				index[0] += i + 1;
			}
			if (tmp == 7) {
				sum += list[i];
				index[1] += i + 1;
			}
			if (tmp == 6) {
				sum += list[i];
				index[2] += i + 1;
			}
			if (tmp == 5) {
				sum += list[i];
				index[3] += i + 1;
			}
			if (tmp == 4) {
				sum += list[i];
				index[4] += i + 1;
			}
		}
		Arrays.sort(index);
		System.out.println(sum);
		for (int i = 0; i < index.length; i++) {
			System.out.print(index[i] + " ");
		}
	}
}
