package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        String[] str = br.readLine().split("");

        for(String b : str){
            left.push(b);
        }
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if(a.equals("P")){//왼쪽에 추가
                left.push(st.nextToken());
            }else if(a.equals("L") && left.size()>0){//왼쪽 한칸
                right.push(left.pop());
            }else if(a.equals("B") && left.size()>0){//왼쪽 삭제
                left.pop();
            }else if(a.equals("D") && right.size()>0){//D 오른쪽 한칸
                left.push(right.pop());
            }
        }
        StringBuilder sb = new StringBuilder();

        int rSize = right.size();
        int lSize = left.size();
        for(int i = 0; i < lSize; i++){
            sb.append(left.pop());
        }
        sb = sb.reverse();
        for(int i = 0; i < rSize; i++){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
