import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        String result = "";
        for(;;) {
            if (n >= b){
                if (n%b >=0 && n%b < 10){
                    result += n%b;
                } else if (n%b >= 10 && n%b < 36){
                    result += (char)(n%b + 55);
                }
                n = n/b;
            }
            else if (n < b){
                if (n >=0 && n < 10){
                    result += n;
                } else if (n >= 10 && n < 36){
                    result += (char)(n + 55);
                }
                break;
            }
        }

        String new_result = "";
        for (int i=result.length()-1; i>=0; i--){
            new_result += result.charAt(i);
        }
        System.out.println(new_result);
    }
}
