import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
public class Main {

	public static void main(String[] args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int n=Integer.parseInt(s);
		double[] mass= {12.010,1.0080,16.000,14.01000};
		char[] symbol= {'C','H','O','N'};
		for(int i=0;i<n;i++) {
			double result=0.0;
			String tmp=br.readLine();
			int l=1;
			for(int j=0;j<tmp.length();j+=l) {
				
				for(int k=0;k<4;k++) {
					if(tmp.charAt(j)==symbol[k]) {
						if(j==tmp.length()-1) {
							result+=mass[k];
							l=1;
							break;
						}
						else if(tmp.charAt(j+1)>='0'&&tmp.charAt(j+1)<='9') {
							if(j+1==tmp.length()-1) {
								int t1=(int)(tmp.charAt(j+1)-'0');
								result+=mass[k]*t1;
								l=2;
							}
							else if(tmp.charAt(j+2)>='0'&&tmp.charAt(j+2)<='9') {
								l=3;
								int t=(int)(tmp.charAt(j+1)-'0')*10+(int)(tmp.charAt(j+2)-'0');
								result+=mass[k]*t;
							}
							else {
								int t1=(int)(tmp.charAt(j+1)-'0');
								result+=mass[k]*t1;
								l=2;
							}
						}
						else {
							result=result+mass[k];
							l=1;
						}
					}
				}
			}
			System.out.printf("%.3f\n",result);	
		}

	}

}
