package baekjoon;
import java.util.Scanner;
public class n1393 {
	static int xs, ys;
	static int R(int x, int y) {
		return (xs-x)*(xs-x)+(ys-y)*(ys-y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		xs = sc.nextInt();
		ys = sc.nextInt();
		int xe = sc.nextInt();
		int ye = sc.nextInt();
		int dx = sc.nextInt();
		int dy = sc.nextInt();
		int Min = 100000000;
		int gcd=1;
		for(int i=1; i<=dx && i<=dy ; i++) {
			if(dx%i==0 && dy%i==0) {
				gcd=i;
			}
		}
		if(dx==0&&dy!=0) {
			dy=1;
		}
		else if(dx!=0 && dy==0) {
			dx=1;
		}
		else {
			dx=dx/gcd;
			dy=dy/gcd;
		}
		while(true) {
			if(R(xe, ye)<Min) {
				Min=R(xe, ye);
			}
			else {
				break;
			}
			xe+=dx;
			ye+=dy;
		}
		xe-=dx;
		ye-=dy;
		System.out.println(xe+" "+ ye);
	}
}
