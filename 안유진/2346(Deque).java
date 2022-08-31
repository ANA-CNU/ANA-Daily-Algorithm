import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    private int x;
    private int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Deque<Pair> deque = new ArrayDeque<>();

        for(int i = 1; i < N+1; i++){
            int temp = Integer.parseInt(st.nextToken());
            deque.addLast(new Pair(temp, i));
        }

        int num = deque.peekFirst().getX();
        int y = deque.peekFirst().getY();
        deque.removeFirst();

        for(int i = 0; i < N-1; i++){
            sb.append(y).append(" ");

            if(num > 0){ //양수인경우
                num -= 1;
                while (num --> 0){
                    Pair p = deque.removeFirst();
                    deque.addLast(p);
                }
            }else{
                num = -(num);
                while (num --> 0){
                    Pair p = deque.removeLast();
                    deque.addFirst(p);
                }
            }

            num = deque.peekFirst().getX();
            y = deque.peekFirst().getY();
            deque.removeFirst();
        }
        sb.append(y);
        System.out.println(sb);
    }
}
//1. N을 입력받음
//2. N개의 정수를 입력받으며 몇번째인지 순서와 함께 해시테이블에 저장
//3. 덱에 저장한다음에 맨앞수를기준으로
//3-1. 양수 : removeFirst -> addLast
//3-1. 음수 : removeLast -> addFirst
//4. 맨앞원소제거후 해시테이블에서 순서를 sb에 append후 출력

