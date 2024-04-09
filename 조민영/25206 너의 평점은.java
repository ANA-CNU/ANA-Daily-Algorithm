import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        double hour_sum = 0;
        double score = 0;
        
        for ( int i = 0 ; i < 20 ; i++ ) {
            sc.next();
            double hour = sc.nextDouble();
            String grade = sc.next();
            
            if ( grade.charAt(0) == 'A' )
                score = 4.0;
            else if ( grade.charAt(0) == 'B' )
                score = 3.0;
            else if ( grade.charAt(0) == 'C' )
                score = 2.0;
            else if (grade.charAt(0) == 'D' )
                score = 1.0;
            
            if ( grade.charAt(0) == 'F' || grade.charAt(0) == 'P' )
                score = 0.0;
            else if ( grade.charAt(1) == '+' )
                score += 0.5;        

            if ( grade.charAt(0) != 'P' ) {
                hour_sum += hour;
                sum += score*hour;
            }
        }
        System.out.printf("%.6f",sum/hour_sum);
    }
}