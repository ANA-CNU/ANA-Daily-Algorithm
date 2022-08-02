import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Bronze {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String s = "";
        int count = 0;
        while(!s.equals("*") && count < 101){
            s = br.readLine();
            count++;

            int check = 0;
            int num = s.length();
            for(int i = 1; i < num; i++){ // 1, 2, 3
                int leng = num-i;

                HashSet<String> set = new HashSet<>();
                for(int j = 0; j < leng; j++){
                    //중복확인 해시맵에 넣어버리고 개수를 배열전체원소개수랑 비교해서 차이나면 false?
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.charAt(j)).append(s.charAt(j+i));
                    set.add(sb.toString());
                }

                if(leng != set.size()){
                    check = 1;
                    break;
                }
            }
            if(!s.equals("*")){
                if(check == 1){
                    answer.append(s).append(" is NOT surprising.").append('\n');
                }else{
                    answer.append(s).append(" is surprising.").append('\n');
                }
            }
        }
        System.out.println(answer);
    }
}
//1. 문자열 길이 확인
//2. 경우의 수 확인 ( ex, 4의 길이를 가진 문자열은 1의차이, 2의차이 3의차이 경우 크게 3개
//2-1 1의차이에서는 0,1 1,2 2,3 가능 (3개)
//전체경우는 전체길이 -1.
//ZGBG 뒤에서 카운팅해도 문제 x 3,2 2,1 1,0 (i시작을 leng-1)
