import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int check = 0;
        int same = 0;

        int leng = s.length();
        int last = leng-1;

        for(int i = 0; i < leng/2; i++){
            if(s.charAt(i) != s.charAt(last)){
                check = 1;
            }
            last--;
        }

        for(int i = 0; i < leng-1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                same = 1;
            }
        }

        if(same == 0){
            System.out.println(-1);
        }else if(check == 1){
            System.out.println(leng);
        }else if(check == 0){
            System.out.println(leng - 1); //펠린드롬
        }
    }
}
//1. 펠린드롬이냐 -> 맞다면 체길이  - 1
//2. 아니라면 전체문자열 길이 출력
//3. 알파벳전부 동일하면 -1
//1-1. 펠린드롬일려면? 대칭쳌
