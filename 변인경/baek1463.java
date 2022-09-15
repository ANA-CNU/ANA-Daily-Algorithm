import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baek1463 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int count = 0;
        while (true){
            //3나누기
            //2나누기
            if(a == 1){
                break;
            }


            if( a % 2 == 0){
                a /= 2;
            }
            else if(a % 3 ==0){
                a /= 3;
            }
            else {
                a-=1;
                count++;

            }

        }
    }
}
