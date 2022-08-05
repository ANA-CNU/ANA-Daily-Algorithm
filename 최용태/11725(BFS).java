import java.util.*;
import java.io.*;

public class Main {
    public static int selected[];
    public static ArrayList<Integer> node[];
    public static Queue q;
    public static class Queue{
        int front=0;
        int rear=0;
        int data[];
        int MAX_SIZE;
        Queue(int size){
            MAX_SIZE=size;
            data=new int[MAX_SIZE];
        }
        void enque(int item){
            rear=(rear+1)%MAX_SIZE;
            data[rear]=item;
        }
        int deque(){
            if(isEmpty())
                return -1;

            front=(front+1)%MAX_SIZE;
            return data[front];
        }
        boolean isEmpty(){
            return (rear==front);
        }
   
    }

    @SuppressWarnings("unchecked")
	public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        selected=new int[N+1];
        node=new ArrayList[N+1];
        q=new Queue(N);

        for(int i=0;i<N+1;i++){
            node[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int from=Integer.parseInt(s.nextToken());
            int to=Integer.parseInt(s.nextToken());
            node[from].add(to);
            node[to].add(from);
        }
    }
    public static void BFS(int start){
        q.enque(start);
        while(!q.isEmpty()){
            int current=q.deque();
            for(int i=0;i<node[current].size();i++){
            	int value=node[current].get(i);
                if(selected[value]==0){
                    selected[value]=current;
                    q.enque(value);
                }
            }
        }
    }
    public static void search() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1;i<selected.length;i++){
            if(selected[i]==0)
                BFS(i);
        }

        for(int i=2;i<selected.length;i++)
            bw.write(selected[i]+"\n");

        bw.flush();
    }
    public static void run() throws IOException {
        input();
        search();
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}