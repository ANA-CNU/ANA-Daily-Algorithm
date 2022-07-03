import java.util.Scanner;

public class Main {
    public static void main(String[] Args) {
        int n=new Scanner(System.in).nextInt();
        char[] a=Integer.toBinaryString(n).toCharArray();
        int r=0;
        for(char c:a) {
            if(c=='1')r++;
        }
        System.out.println(r);
    }
}