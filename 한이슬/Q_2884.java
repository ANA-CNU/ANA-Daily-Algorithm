import java.util.* ;

public class Q_2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in) ;
		int H = 0 ;
		int M = 0 ;
		H = sc.nextInt() ;
		M = sc.nextInt() ;
		if (H==0 && M >= 45) {
			System.out.println(H);
			System.out.println(M-45);
		} else if (H!=0 && M>=45) {
			System.out.println(H);
			System.out.println(M-45);
		} else if (H==0 && M<45) {
			System.out.println("23");
			System.out.println(M+15);
		} else {
			System.out.println(H-1);
			System.out.println(M+15);
		}
	}

}
