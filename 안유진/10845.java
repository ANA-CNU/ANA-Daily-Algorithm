import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Horororo {
    static class que{
        int arr[] = new int[10001];

        int front = -1;
        int rear = -1;

        public void push(int X){
            rear+=1;
            arr[rear] = X;
        }
        public int pop(){
            if(front == rear){
                return -1;
            }else{
                front+=1;
                return arr[front];
            }
        }
        public int size(){
            if(front == -1){
                return rear+1;
            }else{
                return rear-front;
            }
        }
        public int emptycheck(){
            if(front == rear){
                return 1;
            }else{
                return 0;
            }
        }
        public int front(){
            if(rear == front){
                return -1;
            }else{
                return arr[front+1];
            }
        }
        public int back(){
            if(rear == front){
                return -1;
            }else{
                return arr[rear];
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        que q = new que();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String s = st.nextToken();

            if(st.hasMoreTokens()){
                int x = Integer.parseInt(st.nextToken());
                q.push(x);
            }else{
                switch (s) {
                    case "pop":
                        sb.append(q.pop()).append('\n');
                        break;
                    case "size":
                        sb.append(q.size()).append('\n');
                        break;
                    case "empty":
                        sb.append(q.emptycheck()).append('\n');
                        break;
                    case "front":
                        sb.append(q.front()).append('\n');
                        break;
                    case "back":
                        sb.append(q.back()).append('\n');
                        break;
                }
            }
        }
        System.out.println(sb);
    }
}
