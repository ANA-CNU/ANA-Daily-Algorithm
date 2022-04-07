import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine()); 

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            String sentence = sc.nextLine() + "\n"; 
            Stack<Object> stack = new Stack<>();

            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(j) == ' ' || sentence.charAt(j) == '\n') { 
                    while (!stack.empty()) { 
                        result.append(stack.pop()); 
                    }
                    result.append(sentence.charAt(j)); 
                } 
                else {
                    stack.add(sentence.charAt(j)); 
                }
            }
        }

        System.out.print(result.toString());

    }
}
