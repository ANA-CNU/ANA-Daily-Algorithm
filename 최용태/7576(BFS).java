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
	static int[][] tomato;
	static Queue queue;
	static IntQueue lvqueue;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Location{
		int x=0;
		int y=0;
		Location(int newX,int newY){
			x=newX;
			y=newY;
		}
	}
	static class IntQueue{
		int front=0;
		int rear=0;
		int MAX_SIZE;
		int[] data;
		IntQueue(int size){
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
	static class Queue{
		int front=0;
		int rear=0;
		int MAX_SIZE;
		Location[] data;
		Queue(int size){
			data=new Location[size];
			MAX_SIZE=size;
		}
		void push(Location n) {
			rear=(rear+1)%MAX_SIZE;
			this.data[rear]=n;
		}
		Location deque() {
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
		int M = Integer.parseInt(s.nextToken());
		int N = Integer.parseInt(s.nextToken());
		queue=new Queue(N*M);
		lvqueue=new IntQueue(N*N);
		tomato=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				tomato[i][j]=Integer.parseInt(ss.nextToken());
			}
		}
	}
	static boolean check() {
		for(int i=0;i<tomato.length;i++) {
			for(int j=0;j<tomato[0].length;j++) {
				if(tomato[i][j]==0)
					return false;
			}
		}
		return true;
	}
	
	static void run() throws NumberFormatException, IOException {
		inputNode();
		int ans=search();
		if(check())
			System.out.println(ans);
		else
			System.out.println(-1);
	}
	
	static int search() {
		int count=BFS();
		return count;
	}
	
	static int BFS() {
		int height=tomato.length;
		int wide=tomato[0].length;
		int level=0;
		int maxCount=0;
		
		for(int i=0;i<tomato.length;i++) {
			for(int j=0;j<tomato[0].length;j++) {
				if(tomato[i][j]==1) {
					queue.push(new Location(i,j));
					tomato[i][j]=1;
					lvqueue.push(level);
				}
			}
		}
		
		while(queue.rear!=queue.front) {
			Location current=queue.deque();
			int currentLv=lvqueue.deque();
			int x=current.x;
			int y=current.y;
			
			if((x-1)>=0&&tomato[x-1][y]==0) {
				queue.push(new Location(x-1,y));
				tomato[x-1][y]=1;
				lvqueue.push(currentLv+1);
			}
			if((x+1)<height&&tomato[x+1][y]==0) {
				queue.push(new Location(x+1,y));
				tomato[x+1][y]=1;
				lvqueue.push(currentLv+1);
			}
			if((y-1)>=0&&tomato[x][y-1]==0) {
				queue.push(new Location(x,y-1));
				tomato[x][y-1]=1;
				lvqueue.push(currentLv+1);
			}
			if((y+1)<wide&&tomato[x][y+1]==0) {
				queue.push(new Location(x,y+1));
				tomato[x][y+1]=1;
				lvqueue.push(currentLv+1);
			}
			if(maxCount<currentLv)
				maxCount=currentLv;
		}
		return maxCount;
	}

	public static void main(String[] args) throws Exception {
		run();
	}
}
