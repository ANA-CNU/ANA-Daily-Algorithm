import java.util.Scanner;

class Divisor extends Exception{
    Divisor(String msg){
        super(msg);
    }
}

public class codingTest {

    static void pf(int n, int m) throws Exception {
        try {
            if(n==m) {
                throw new Exception(m+"");
            }else if(n%m==0) {
                pf(n / m, m);
            }else {
                pf(n, m + 1);
            }
        }catch(Exception e) {
            Divisor divisor = new Divisor(e.getMessage());
            divisor.initCause(e);
            throw divisor;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();
        int divisor = 1;
        String result = "";
        System.out.print(number+" = ");

        while(true) {
            try {
                pf(number,2);
            }catch(Exception e) {
                divisor = Integer.parseInt(e.getCause().getMessage());
                result = e.getCause().getMessage() + " * " + result;
            }
            number /= divisor;
            if(number==1) {
                break;
            }
        }
        for(int i=0; i<result.length()-3; i++) {
            System.out.print(result.charAt(i));
        }
    }
}