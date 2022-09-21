import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;

    static boolean rec_multipleOf3 (String input){
        if(input.length() == 1){
            if(input.charAt(0) == '3' || input.charAt(0) == '6' || input.charAt(0) == '9'){
                return true;
            }
            else
                return false;
        }

        String nextString = "";
        int nextInt = 0;
        for(int i =0; i< input.length();i++){
            nextInt += Integer.parseInt(""+input.charAt(i));
        }
        nextString = Integer.toString(nextInt);
        count++;
        return rec_multipleOf3(nextString);
    }

    public static void main(String[] args) throws IOException{

        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));

        String x = bufReader.readLine();

        boolean result = rec_multipleOf3(x);

        System.out.println(count);
        if(result == true){
            System.out.println("YES");
        }
        else
            System.out.println("NO");
        bufReader.close();
    }

}
