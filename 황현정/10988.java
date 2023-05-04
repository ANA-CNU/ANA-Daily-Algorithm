import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int n = word.length();
        boolean checked = true;

        for(int i=0; i<n; i++){
            if (word.charAt(i) != word.charAt(n-i-1)){
                checked = false;
                break;
            }
        }
        if (checked == true){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
