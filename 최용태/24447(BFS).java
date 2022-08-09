import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer> node[];
    public static int N;
    public static Queue q;

    public static class Queue {
        int front = 0;
        int rear = 0;
        int data[];
        int MAX_SIZE;

        Queue(int size) {
            data = new int[size];
            MAX_SIZE = size;
        }

        void enqueue(int i) {
            rear = (rear + 1) % MAX_SIZE;
            data[rear] = i;
        }

        int dequeue() {
            front = (front + 1) % MAX_SIZE;
            return data[front];
        }

        boolean isEmpty() {
            return (rear == front);
        }
    }

    public static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(s.nextToken());
        int E = Integer.parseInt(s.nextToken());
        int start = Integer.parseInt(s.nextToken());
        node = new ArrayList[N + 1];
        q = new Queue(E);
        for (int i = 0; i < N+1; i++) {
            node[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(ss.nextToken());
            int to = Integer.parseInt(ss.nextToken());

            node[from].add(to);
            node[to].add(from);
        }

        return start;
    }

    public static long BFS(int start) throws IOException {
        long order=1;
        long result=0;

        boolean visited[] = new boolean[N + 1];
        Queue Lvq=new Queue(q.MAX_SIZE);
        q.enqueue(start);
        Lvq.enqueue(0);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.dequeue();
            int currentLv=Lvq.dequeue();
            for (int i = 0; i < node[current].size(); i++) {
                int element = node[current].get(i);
                if (!visited[element]) {
                    order++;
                    visited[element] = true;
                    q.enqueue(element);
                    Lvq.enqueue(currentLv+1);
                    result+=order*(currentLv+1);
                }
            }

        }
        return result;
    }

    public static void run() throws IOException {
        System.out.println(BFS(input()));
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}