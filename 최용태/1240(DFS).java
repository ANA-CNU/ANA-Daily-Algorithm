import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class NodeType {
	int adj = 0;
	int[] edge = new int[1001];
	int v;
	static final int INF = 10001;

	NodeType(int vertex) {
		this.v = vertex;
		this.init();
	}

	void init() {
		for (int i = 1; i < 1001; i++) {
			edge[i] = INF;
		}
	}
}

class Stack {
	int top = -1;
	int[] data = new int[1000];

	void push(int item) {
		this.data[++top] = item;
	}

	void pop() {
		if (top != -1)
			this.top--;
	}
	int peek(){
		if (top == -1)
			return -1;
		else
			return this.data[this.top];
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static NodeType[] node;
	static Stack stack = new Stack();

	public static void main(String[] args) throws IOException {
		StringTokenizer S = getToken();
		int N = Integer.parseInt(S.nextToken());
		int M = Integer.parseInt(S.nextToken());
		node = new NodeType[N + 1];

		for (int i = 1; i < N + 1; i++) {
			node[i] = new NodeType(i);
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer SS = getToken();
			int start = Integer.parseInt(SS.nextToken());
			int end = Integer.parseInt(SS.nextToken());
			int w = Integer.parseInt(SS.nextToken());

			node[start].edge[end] = w;
			node[end].edge[start] = w;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer SS = getToken();
			int start = Integer.parseInt(SS.nextToken());
			int end = Integer.parseInt(SS.nextToken());
			bw.write(DFS(start,end,N+1)+"\n");
			stack.top=-1;
		}

		bw.flush();
	}

	public static StringTokenizer getToken() throws IOException {
		String buf = br.readLine();
		StringTokenizer b = new StringTokenizer(buf, " ");

		return b;
	}

	public static int DFS(int start, int end, int size) {
		int result = 0;
		int from = start;
		boolean visited[]=new boolean[size+1];
		
		visited[start]=true;
		stack.push(start);
		
		while (stack.top != -1){
			int v=1;
			
			for ( v = 1; v < size; v++) {
				if (node[from].edge[v] != NodeType.INF&&!visited[v]) {
					stack.push(v);
					visited[v]=true;
					from = v;
					break;
				}
			}
			
			if(v==size) {
				stack.pop(); // from으로 회귀
				from=stack.peek();
			}
			
			else if (from == end)
				break;
		}
		
		for(int i=stack.top;i>0;i--) {
			result+=node[stack.data[i]].edge[stack.data[i-1]];
		}
		
		return result;
	}

}