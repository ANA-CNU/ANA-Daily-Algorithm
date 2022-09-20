import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek21921 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean Im_Sad = true;
        st = new StringTokenizer(br.readLine());
        int sum   = 0;
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > 0) {
                Im_Sad = false;
            }
        }
        for(int i=0;i<X;i++){
            sum += arr[i];
        }
        int count = 1;
        if (Im_Sad) {
            System.out.println("SAD");
        } else {

            int max = sum;
            for (int i = X; i < N; i++) {

                sum += arr[i];
                sum -= arr[i-X];

                if (max < sum) {
                    max = sum;
                    count = 1;
                } else if (max == sum) {

                    count++;
                }


            }
            System.out.println(max+"\n"+count);
        }
    }
}
