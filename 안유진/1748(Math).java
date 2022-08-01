import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        String s = br.readLine();
        int N = Integer.parseInt(s);
        int leng = s.length();

        for(int i = 0; i < leng-1; i++){
            double number = Math.pow(10, i);
            sum+=(9 * number) * (i+1);
            N -= number * 9;
        }
        sum += N * leng;

        System.out.println(sum);
    }
}
//1. N을 입력받아줌.
//2. N의 자리수(Length)를 확인해준다
//3. 자리수 - 1만큼 for문을 돌려가며 각 자리수별길이를 더하고 마지막에 남은수 자리수곱해서길이더해줌
//한자리수(9개) 2자리(90개) 세자리(900개) . ..
