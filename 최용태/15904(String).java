import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Stack{
	int top=-1;
	char data[]=new char[4];
	
	void push(char c) {
		data[++top]=c;
	}
	
	char pop() {
		if(top==-1)
			return '!';
		else
			return data[top--];
	}
}

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack stack=new Stack();
		String str=br.readLine();
		String result="";
		char UCPC[]= {'U','C','P','C'};

		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
				case 'U':
					if(stack.top==-1)
						stack.push(str.charAt(i));
					break;
				case 'C':
					if(stack.top==0)
						stack.push(str.charAt(i));
					else if(stack.top==2)
						stack.push(str.charAt(i));
					break;
				case 'P':
					if(stack.top==1)
						stack.push(str.charAt(i));
					break;
			}
		}
		
		while(stack.top!=-1) {
			result+=stack.pop();
			System.out.println(result);
		}
		
		if(result.compareTo("CPCU")==0)
			System.out.println("I love UCPC");
		else
			System.out.println("I hate UCPC");
	}
}