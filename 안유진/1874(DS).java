import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //스택사이즈
        int n = Integer.parseInt(br.readLine());
        //현재 스택에 몇번까지들어갔나용
        int index = 1;
        int check = 0; //불가능여부체크
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i < n+1; i++){
            int current = Integer.parseInt(br.readLine()); //현재 수열
            if(current >= index){
                int currentindex = index;
                for(int j = currentindex; j <= current; j++){
                    stack.push(j);
                    sb.append("+").append('\n');
                    index++;
                }
            }
            if(current == index){
                sb.append("-").append('\n');
                stack.pop();
            }
            if(current < index){ //2개의경우. 바로 있냐 밑에있냐
                if(current == stack.peek()) { //위에있나 엿보기
                    stack.pop();
                    sb.append("-").append('\n');
                }else{
                    check = 1;
                }
            }
        }
        if(check != 1){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}
//1. n을 입력받음, n길이의 수열도 입력받음
//2. n크기의 스택을 생성한 후, 수열에서 하나씩 떼와서 수를 보고 현재 index(어디까지 넣었는지 확인)
// 보다 작으면 안에서 넣다 뺏다하고 크면 그 떼온수까지 스택에 순서대로 추가해줌
