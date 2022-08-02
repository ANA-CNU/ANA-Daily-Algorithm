import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean node[][];
	
	public static class Queue{
		int front=0;
		int rear=0;
		int[] data;
		int MAX_SIZE;
		Queue(int size){
			data=new int[size];
			MAX_SIZE=size;
		}
		
		boolean isEmpty() {
			return (rear==front);
		}
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
	}
	
	public static void input() throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		node=new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			int from=Integer.parseInt(s.nextToken());
			int to=Integer.parseInt(s.nextToken());
			node[from][to]=true;
			node[to][from]=true;
		}
		
	}
	
	public static int search() throws NumberFormatException, IOException {
		boolean visited[]=new boolean[node.length];
		Queue q=new Queue(visited.length);
		int count=0;
		q.enque(1);
		visited[1]=true;
		
		while(!q.isEmpty()) {
			int current=q.deque();
			for(int i=1;i<visited.length;i++) {
				if(!visited[i] && node[current][i]) {
					visited[i]=true;
					q.enque(i);
					count++;
				}
			}
		}
		return count;
	}
	public static void run() throws NumberFormatException, IOException {
		input();
		int ans=search();
		System.out.println(ans);
	}
	public static void main(String[] args) throws Exception {
		run();
	}
}
