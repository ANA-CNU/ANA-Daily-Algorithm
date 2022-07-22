import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 0;
        int check = 0;

        char arr[] = new char[51];

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            arr[i]= s.charAt(i);
        }

        if(s.length() == 1 || s.length() == 3){
            if(s.length() == 1){
                if(s.charAt(0) == '.'){
                    sb.append(".");
                }else{
                    check = 1;
                }
            }else{
                if(s.charAt(0) == '.' && s.charAt(1) =='.' && s.charAt(2) =='.'){
                    sb.append("...");
                }else{
                    check = 1;
                }
            }
        }else{
            arr[s.length()] = '*'; //끝나는지점표시
            while(arr[index] != '*'){
                int num = 0;
                int dotnum = 0;

                while(arr[index] == 'X'){
                    num++;
                    index++;
                }
                while(arr[index] == '.'){
                    dotnum++;
                    index++;
                }
                if(num % 2 == 0){
                    int left = num%4;
                    for(int i = 0; i < num-left; i++){
                        sb.append("A");
                    }
                    for(int i = 0; i < left; i++){
                        sb.append("B");
                    }
                    for(int i = 0; i <dotnum; i++){
                        sb.append(".");
                    }
                }else{
                    check = 1;
                }
            }
        }
        if(check != 1){
            System.out.println(sb);
        }else{
            System.out.println(-1);
        }
    }
}
