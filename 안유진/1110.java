import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        String s = br.readLine();

        int arr[] = new int[2];

        if(s.length() == 1){
            arr[0] = 0;
            arr[1] = Integer.parseInt(s);
        }else{
            arr[0] = s.charAt(0) - 48;
            arr[1] = s.charAt(1) - 48;
        }

        while(true){
            int temp = arr[1] + arr[0];
            arr[0] = arr[1];
            arr[1] = temp%10;

            int newnum = arr[0]*10 + arr[1];

            arr[0] = newnum/10;
            arr[1] = newnum%10;

            count++;

            if(newnum == Integer.parseInt(s)){
                break;
            }
        }
        System.out.println(count);
    }
}
