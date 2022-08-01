import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hororop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j) - 48;
            }
        }
        int num = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j <M; j++){
                for(int k = 1; k < Math.min(N,M); k++){ //변길이
                    //1개~둘중작은변까지
                    if(i + k < N && j + k < M &&(arr[i][j] == arr[i+k][j] && arr[i+k][j] == arr[i][j+k] && arr[i][j+k] == arr[i+k][j+k])){
                        int leng = k+1; //실길이는 k+1
                        if(leng*leng >  num){
                            num = leng*leng;
                        }
                    }
                }
            }
        }
        System.out.println(num);
    }
}

