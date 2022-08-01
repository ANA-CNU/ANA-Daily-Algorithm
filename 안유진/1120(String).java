import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int count = 100; //최소값

        String A = st.nextToken();
        String B = st.nextToken();
        int lengDiff = B.length() - A.length(); //차이값을빼줘서 경우의수생성

        for(int i = 0; i < lengDiff+1; i++){
            int counting = 0;
            int start = i; //B에서 시작하는 지점을 달리함
            for(int j = 0; j < A.length(); j++){
                if(A.charAt(j) != B.charAt(start)){ //A길이만큼 B에서 일치불일치여부비교
                    counting++;
                }
                start++;
            }
            if(counting < count){
                count = counting;
            }
        }
        System.out.println(count);
    }
}
//1. 문자열을 2개 입력받고 길이차이값을구해줌
//2. 어짜피 차이나는건 다 맞다고 처리할테니
//3. 그냥 A와 B를 비교하는 스타트지점을 다르게해서 카운팅 후 차이값더해줌