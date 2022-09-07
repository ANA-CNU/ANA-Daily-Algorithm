import java.io.*;
import java.util.Stack;

public class S4_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        boolean check = true;

        while(true){
            String input = br.readLine();


            if(input.equals(".")) break;

            Stack<Character> open = new Stack<Character>();

            for(int i = 0; i<input.length(); i++){
                char a = input.charAt(i);
                if(a == '(' || a =='['){
                    open.add(a);
                }

                else if(a == ')') {
                    if(open.isEmpty() || open.peek() != '('){
                        check = false;
                        break;
                    }else
                        open.pop();
                }
                else if(a == ']'){
                    if(open.isEmpty() || open.peek() != '['){
                        check = false;
                        break;
                    }else
                        open.pop();
                }
            }

            if(open.isEmpty() && check == true) bw.write("yes\n");
            else bw.write("no\n");




            check = true;





        }

        bw.flush();
        bw.close();
    }
}
