import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[M][2];

        int groupMin = 1000;
        int min = 1000;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if(arr[i][1] < min){
                min = arr[i][1];
            }
            if(arr[i][0] < groupMin){
                groupMin = arr[i][0];
            }
        }
        int group = N/6;
        int secondSum = 0;

        int firstSum = (group*groupMin) + (N-(group*6))*min;

        if(N == 6){
            secondSum = group*groupMin;
        }else{
            secondSum = (group+1)*groupMin;
        }

        int thirdSum = N*min;

        System.out.println(Math.min(Math.min(firstSum, secondSum),thirdSum));
    }
}
//3가지경우
//1. 묶음(적정최대량) + 낱개 가격
//2. 낱개포함안하고 묶음으로 다사는경우
//3. 낱개로만 사는경우