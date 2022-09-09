import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Integer.parseInt(st.nextToken());   //낮
        double B = Integer.parseInt(st.nextToken());   //밤
        int V = Integer.parseInt(st.nextToken());   //높이

        int check = 0;

        double A_B = A-B;

        double day =  (V-B)/A_B;

        int result = (int )day;

        if(day-(int)day > 0){
            result++;
        }
        System.out.println(result);


    }
}
