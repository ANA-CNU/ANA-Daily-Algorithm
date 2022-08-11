import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       int T = Integer.parseInt(br.readLine());

       while (T --> 0){
           StringTokenizer st = new StringTokenizer(br.readLine()," ");
           int N = Integer.parseInt(st.nextToken());
           int M = Integer.parseInt(st.nextToken()); //찾아야할원소가 처음에 어디위치한지

           st = new StringTokenizer(br.readLine()," ");

           Deque<Point> q = new LinkedList<Point>();

           int find = 0; //찾아야할 원소가 무엇인지(index말고 value)
           for(int i = 0; i < N; i++){
               int temp = Integer.parseInt(st.nextToken());
               if(i == M){//index동일할시 value 저장
                   find = temp;
               }
               q.addLast(new Point(temp,  i)); //i는 몇번째인지 표기하기 위함
           }

           //queue에 모든 원소 저장완
           int count = 0;
           while(true){
               boolean checked = false;

               if(N == 1){
                   break;
               }

               Point a = new Point(q.remove());
               int num = a.x;
               int index = a.y;

               for(Point temp : q){ //전체살피면서 뒤에 더 큰 중요도가있나확인
                   if(num < temp.x){
                       checked = true;
                   }
               }

               if(checked){
                   q.addLast(new Point(num, index));
               }else{
                   if(num == find && index == M){
                       break;
                   }
                   count++;
               }
           }
           sb.append(count + 1).append('\n');
       }
        System.out.println(sb);
    }
}
