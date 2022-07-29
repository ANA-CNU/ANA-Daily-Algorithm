import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	static int MAX_SIZE;
	static boolean[][] node;
	static int[] data;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static class Stack{
		int top=-1;
		void push(int item) {
			data[++top]=item;
		}
		
		int pop() {
			if(isEmpty())
				return -1;
			else
				return data[top--];
		}
		
		boolean isEmpty() {
			return (top==-1);
		}
	}
	public static class Queue{
		int front=0;
		int rear=0;

		void enque(int item) {
			rear=(rear+1)%MAX_SIZE;
			data[rear]=item;
		}
		
		int deque() {
			if(isEmpty())
				return -1;
			
			front=(front+1)%MAX_SIZE;
			return data[front];
		}
		
		boolean isEmpty() {
			return (rear==front);
		}
	}
	
	public static void run() throws IOException {
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int N=Integer.parseInt(s.nextToken());
		int T=Integer.parseInt(s.nextToken());
		int start=Integer.parseInt(s.nextToken());
		
		MAX_SIZE=N;
		data=new int[N];
		node=new boolean[N+1][N+1];
		
		inputNode(T);
		DFS(start);
		BFS(start);
		
		bw.flush();
	}
	
	public static void inputNode(int size) throws IOException{
		for(int i=0;i<size;i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			int from=Integer.parseInt(s.nextToken());
			int to=Integer.parseInt(s.nextToken());
			node[from][to]=true;
			node[to][from]=true;
		}
	}
	
	public static void BFS(int start) throws IOException {
		Queue queue=new Queue();
		int size=node.length;
		boolean visited[]=new boolean[size];
		
		visited[start]=true;
		queue.enque(start);
		while(!queue.isEmpty()) {
			int current=queue.deque();
			bw.write(current+" ");
			for(int i=1;i<size;i++) {
				if(!visited[i] && node[current][i]) {
					visited[i]=true;
					queue.enque(i);
				}
			}
		}
		bw.write("\n");
	}
	
	public static void DFS(int start) throws IOException {
		Stack stack=new Stack();
		int size=node.length;
		boolean visited[]=new boolean[size];
		
		visited[start]=true;
		stack.push(start);
		bw.write(start+" ");
		
		while(!stack.isEmpty()) {
			int current=data[stack.top];
			int i=1;
			
			for(i=1;i<size;i++) {
				if(!visited[i] && node[current][i]) {
					visited[i]=true;
					stack.push(i);
					bw.write(i+" ");
					break;
				}
			}
			if(i==size)
				stack.pop();
		}

		
		bw.write("\n");
	}
	

	
	public static void main(String[] args) throws Exception {
		run();
	}
}
