import java.util.*;
public class Boj10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int k = sc.nextInt();
        for(int i=0; i<k;i++){
            int n = sc.nextInt();
            if(n==0){
                stack.pop();
            }else{
                stack.push(n);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
