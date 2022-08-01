import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] kebin;
	static Queue queue;
	static Queue lvqueue;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Queue{
		int front=0;
		int rear=0;
		int MAX_SIZE;
		int[] data;
		Queue(int size){
			data=new int[size];
			MAX_SIZE=size;
		}
		void push(int n) {
			rear=(rear+1)%MAX_SIZE;
			this.data[rear]=n;
		}
		int deque() {
			front=(front+1)%MAX_SIZE;
			return this.data[front];
		}
		void init() {
			front=0;
			rear=0;
		}
	}
	
	static class Stack{
		int top=-1;
		int[] data;
		Stack(int size){
			data=new int[size];
		}
		void push(int n) {
			this.data[++this.top]=n;
		}
		int pop() {
			if(this.top==-1)
				return -1;
			else
				return this.data[this.top--];
		}
	}
	
	static void inputNode() throws NumberFormatException, IOException {
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(s.nextToken());
		int T = Integer.parseInt(s.nextToken());
		queue=new Queue(N);
		lvqueue=new Queue(N);
		kebin=new boolean[N+1][N+1];
		
		for (int i = 0; i < T; i++) {
			StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
			int from=Integer.parseInt(ss.nextToken());
			int to=Integer.parseInt(ss.nextToken());
			
			kebin[from][to]=true;
			kebin[to][from]=true;
		}
	}
	static void run() throws NumberFormatException, IOException {
		inputNode();
		int ans=search();
		System.out.println(ans);
	}
	static int search() {
		int least=99999;
		int leastIdx=-1;
		for(int i=1;i<kebin.length;i++) {
			int cmp=BFS(i);
			if(cmp<least) {
				leastIdx=i;
				least=cmp;
			}
			lvqueue.init();
			queue.init();
		}
		return leastIdx;
	}
	
	static int BFS(int start) {
		boolean visited[]=new boolean[kebin.length];
		int size=kebin.length;
		int level=0;
		int count=0;
		visited[start]=true;
		queue.push(start);
		lvqueue.push(level);
		while(queue.rear!=queue.front) {
			int current=queue.deque();
			int currentLv=lvqueue.deque();
			count+=currentLv;
			for(int i=1;i<size;i++) {
				if(kebin[current][i] && !visited[i]) {
					visited[i]=true;
					queue.push(i);
					lvqueue.push(currentLv+1);
				}
			}
		}
		System.out.println(start+": "+count);
		return count;
	}

	public static void main(String[] args) throws Exception {
		run();
	}
}
