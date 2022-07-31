import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Hashtable<Integer, String > hashtable = new Hashtable<>();
        Hashtable<String, Integer> hashtable1 = new Hashtable<>();

        for(int i = 1; i < N+1; i++){
            String s = br.readLine();
            hashtable.put(i, s);
            hashtable1.put(s, i);
        } //저장완료

        for(int i = 0; i < M; i++){ //정수와 문자열 구분
            String s = br.readLine();
            boolean isNumeric = true;
            for(int j = 0; j < s.length(); j++){
                if(!Character.isDigit(s.charAt(j))){
                    isNumeric = false;
                }
            }
            if(isNumeric){ //숫자인경우
                sb.append(hashtable.get(Integer.parseInt(s))).append('\n');
            }else{ //문자인경우
                sb.append(hashtable1.get(s)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
//첫글자 || 마지막글자 대문자 -> 해시충돌시 구별?
//M개이름 (숫자붙혀서 저장하기) 이후 N개 출력해야하는값들어옴 (저장해놓은테이블에서 출력)

//1. N과 M입력받기
//2. N크기의 해시테이블생성. 번호와 이름으로 저장하기(N만큼입력받으며)
//3. M만큼입력받으면서 바로바로 해시에서 매핑해서 stringBuilder에 저장
//4. 출력
//마지막글자 대문자인 조건 생각해보면서 하기
