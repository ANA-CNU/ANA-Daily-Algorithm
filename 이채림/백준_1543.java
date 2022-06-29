import java.io.*;

public class 백준_1543 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String find = br.readLine();

        int N = text.length()-find.length()+1;

        int result = 0;

        int i = 0;

        while(i < N){
            String temp = text.substring(i, i+find.length());
            
            if(find.equals(temp)){
                i = i + find.length();
                result += 1;
            }else{
                i = i+1;
            }
        }   
        

        System.out.println(result);
    }
}
