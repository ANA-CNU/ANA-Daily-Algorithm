import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek11441_again {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[input+1];

        for(int i=1;i<=input;i++){

            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        while(M-- >0){
            st = new StringTokenizer(br.readLine());
            int i= Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(arr[j]-arr[i-1]);
        }
    }
}
