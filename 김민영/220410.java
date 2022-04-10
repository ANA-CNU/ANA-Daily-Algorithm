import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[][] arr=new char[5][15];
		for(int i=0;i<5;i++) {
			String input=br.readLine();
			for(int j=0;j<input.length();j++) {
				arr[i][j]=input.charAt(j);
			}
		}
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<5;j++) {
				if(arr[j][i]=='\0') {
					continue;	
				}
				else {
					System.out.print(arr[j][i]);
				}
				    
			}
		}
	}

}
