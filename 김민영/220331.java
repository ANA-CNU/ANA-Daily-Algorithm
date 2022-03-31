import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		char[] wordarr=word.toCharArray();
		int count=0;
		for(int i=0;i<wordarr.length-1;i++){
		if(wordarr[i]==' '&&wordarr[i+1]!=' '||wordarr[i]==' '&&wordarr[i-1]!=' '){
			count++;
		   }
		}
		if(wordarr[0]==' ') {
			System.out.println(count);
		}
		else {
			System.out.println(count+1);
		}
		
		
    }
}
