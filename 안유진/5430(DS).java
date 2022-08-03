import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Horororo {
    static Deque<Integer> temp;
    static boolean front;

    public static void R(){
        front = !front;
    }

    public static void D(){
        if(front){
            temp.removeFirst();
        }else{
            temp.removeLast();
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            boolean checked = true; //중간에 오류없이 함수 다 수행되었나 확인
            String func = br.readLine();

            int n = Integer.parseInt(br.readLine()); //원소개수

            temp = new ArrayDeque<>();
            front = true;

            String num = br.readLine();
            StringTokenizer st = new StringTokenizer(num, "[],");

            for(int j = 0; j < n; j++){
                temp.add(Integer.parseInt(st.nextToken()));
            }

            for(int j = 0; j < func.length(); j++){
                char function = func.charAt(j);
                if(function == 'R'){
                    R();
                }else if(function == 'D'){
                    if(n == 0){
                        checked = false;
                        break;
                    }else{
                        D();
                        n--;
                    }
                }
            }
            if((checked)){
                if(n == 0){
                    sb.append("[]").append('\n');
                }else if((front)){
                    sb.append("[");
                    for(int j = 0; j < n-1; j++){
                        int tp = temp.removeFirst();
                        sb.append(tp).append(",");
                    }
                    sb.append(temp.getFirst()).append("]").append('\n');
                }else{
                    sb.append("[");
                    for (int j = 0; j < n-1; j++) {
                        int tp = temp.removeLast();
                        sb.append(tp).append(",");
                    }
                    sb.append(temp.getLast()).append("]").append('\n');
                }
            }else{
                sb.append("error").append('\n');
            }
        }
        System.out.println(sb);
    }
}
