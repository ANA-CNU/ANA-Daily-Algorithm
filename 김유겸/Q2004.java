package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int countTwo = twoNum(n) - twoNum(n-m) - twoNum(m);
        int countFive = fiveNum(n) - fiveNum(n-m) - fiveNum(m);

        System.out.println(Math.min(countTwo, countFive));
    }
    static int twoNum(int num){
        int count = 0;
        while(num >= 2){
            count += num / 2;
            num /= 2;
        }
        return count;
    }
    static int fiveNum(int num){
        int count = 0;
        while(num >= 5){
            count += num / 5;
            num /= 5;
        }
        return count;
    }
}
