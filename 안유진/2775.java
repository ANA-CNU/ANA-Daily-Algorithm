import java.util.*;
import java.io.*;

public class Bronze {
    public static int sti(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = sti(br.readLine());


        for(int i = 0; i<T; i++){
            int k = sti(br.readLine());
            int n = sti(br.readLine())-1;

            int arr[][] = new int[k+1][14];
            //인덱스는 0~13
            for(int j = 1; j<15; j++){
                arr[0][j-1] = j;
                //0번째칸에는 1저장
                //1씩증가시켜가면서 arr[0][13] = 14
            }

            for(int j = 1; j<k+1; j++){
                //1번째줄부터 k까지 행
                for(int x = 0; x<14; x++){
                    //열 0~13번째까지
                    if(x == 0){
                        arr[j][x] = arr[j-1][x];
                    }else{
                        arr[j][x] = arr[j][x-1]+arr[j-1][x];
                    }
                }
            }

            sb.append(arr[k][n]).append('\n');
        }
        System.out.println(sb);
    }
}
