import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int arr[][] = new int[N][2];
        int store[] = new int[N];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i][0] = num;
            store[i] = num;
            arr[i][1] = i;
        }
        for(int j = 0; j < N; j++){
            for(int i = 0; i < N-1; i++){
                if(arr[i][0] > arr[i+1][0]){
                    int temp = arr[i][0];
                    arr[i][0] = arr[i+1][0];
                    arr[i+1][0] = temp;
                }
            }
        }

        for(int i = 0; i < N; i++){
            int num = store[i];
            for(int j = 0; j < N; j++){
                if(num == arr[j][0]){
                    if(arr[j][1] != -1){
                        sb.append(arr[j][1]).append(" ");
                        arr[j][1] = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
//1. N을 입력받고 N크기의 2차원배열생성
//2. 한쪽열에는 배열쭉입력받고 다음열(1)에는 인덱스입력받음
//3. 0번열정렬함
//4. 입력받았던 숫자를 비교해가면서 인덱스 몇번에있는지 sb에 추가