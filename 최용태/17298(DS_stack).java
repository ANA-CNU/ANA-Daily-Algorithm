import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String anum = br.readLine();
		StringTokenizer an = new StringTokenizer(anum, " ");
		Stack s = new Stack(N);
		Stack is = new Stack(N);
		int[] a=new int[N];
		
		int prev = Integer.parseInt(an.nextToken());
		int start = 1;
		
		a[0]=-1;
		is.push(0);
		s.push(prev); // 첫번째 요소 추가

			for (int i = 1; i < N; i++) {
				int current = Integer.parseInt(an.nextToken());
				a[i]=-1;
				if(current>prev) {
					while(true) {
						int idx=is.pop();
						int poppedNum=s.pop();
						if(idx==-1 || poppedNum>=current) {
							if(poppedNum>=current) {
								s.top++;
								is.top++;
							}
							break;
						}
						a[idx]=current;
					}
				}
				s.push(current);
				is.push(i);
				prev=current;
			}
			
			for (int i = 0; i < N; i++) {
				bw.write(a[i]+" ");
			}
			bw.flush();
	}
}

class Stack {
	int top = -1;
	int[] data;

	Stack() {
	}

	Stack(int size) {
		data = new int[size];
	}

	void push(int item) {
		data[++top] = item;
	}

	int pop() {
		if (top == -1)
			return -1;

		return data[top--];
	}
}
