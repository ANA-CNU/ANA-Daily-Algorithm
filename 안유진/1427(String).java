import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int arr[] = new int[10];

        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i) - 48;
            arr[num]++;
        }

        for(int i = 9; i > 0; i--){
            if(arr[i] != 0){
                int number = arr[i];
                for(int j = 0; j < number; j++){
                    sb.append(i);
                }
            }
        }
        if(arr[0] != 0){
            for(int i = 0; i < arr[0]; i++){
                sb.append(0);
            }
        }
        System.out.println(sb);
    }
}
