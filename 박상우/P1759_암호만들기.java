import java.io.*;
import java.util.*;

public class Main {
	static int L,C;
	static char[] alpha;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void dfs(int x, int len, int a, int b, String s)throws IOException{
	    if(len == L){ 
	        if(a >= 1 && b >= 2) bw.write(s+"\n");
	        return;
	    }
	    for(int i = x; i < C; i++){
	        StringBuilder sb = new StringBuilder(s);
	        sb.append(alpha[i]);
	        if(alpha[i]== 'a' ||  alpha[i]== 'e' || alpha[i]== 'i' || alpha[i]== 'o' || alpha[i]== 'u'){   
	            dfs(i+1, len+1, a+1, b,sb.toString());
	        }else{   
	            dfs(i+1, len+1, a, b+1,sb.toString());
	        }
	    }
	}
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    L = Integer.parseInt(st.
	    nextToken());
	    C = Integer.parseInt(st.nextToken());
	    alpha = new char[C];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < C; i++){
	        alpha[i] = st.nextToken().charAt(0);
	    }
	    Arrays.sort(alpha);
	    dfs(0,0,0,0,"");
	    
	    bw.flush();
	    bw.close();
	    br.close();
	}
}