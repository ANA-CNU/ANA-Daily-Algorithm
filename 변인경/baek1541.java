import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] minus = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;
        for(int i=0;i<minus.length;i++){
            String [] word =  minus[i].split("\\+");

            int temp = 0;
            for(int j=0;j< word.length;j++){
                int a = Integer.parseInt(word[j]);
                temp += a;
            }
            if(sum==Integer.MAX_VALUE){
                sum = 0;
                sum += temp;
            }
            else{
                sum -= temp;
            }
        }
        System.out.println(sum);

    }
}
