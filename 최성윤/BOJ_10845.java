import java.util.*;
import java.io.*;
import java.lang.*;


public class Main {
    public static class ArrayQueue <E>{
        private E[] q;
        private int front, rear, size;
        public ArrayQueue(){
            q = (E[]) new Object[10001];
            front = rear = size = 0;
        }
        public void size(){
            System.out.println(size);
        }
        public boolean isEmpty(){
            return (size == 0);
        }
        public void push(E newItem){
            if((rear + 1) % q.length == front){
                resize(2 * q.length);
            }
            rear = (rear + 1) % q.length;
            q[rear] = newItem;
            size++;
        }
        public void resize(int newSize){
            Object [] t = new Object[newSize];
            for(int i = 1, j = front + 1; i < size + 1; i++, j++){
                t[i] = q[j % q.length];
            }
            front = 0;
            rear = size;
            q = (E[]) t;
        }
        public void empty(){
            if(isEmpty()) System.out.println(1);
            else System.out.println(0);

        }
        public void pop(){
            if(isEmpty()) System.out.println(-1);
            else {
                front = (front + 1) % q.length;
                E a = q[front];
                q[front] = null;
                System.out.println(a);
                size--;

            }

        }
        public void front(){
            if(isEmpty()) System.out.println(-1);
            else {
                E a = q[front + 1];
                System.out.println(a);
            }

        }
        public void back() {
            if(isEmpty()) System.out.println(-1);
            else {
                E b = q[rear];
                System.out.println(b);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();

        for (int i = 0; i < n ; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            switch (st.nextToken()){
                case "pop":
                    queue.pop();
                    break;
                case "push":
                    queue.push(Integer.valueOf(st.nextToken()));
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.empty();
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
            }
        }
        br.close();



    }
}
