import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[M+1];

        for(int i = 0; i < M+1; i++){
            arr[i] = i;
        }
        arr[0] = 0; //소수아니면 0으로 바꿔줌
        for(int i = 2; i < M+1; i++){
            if(arr[i] == 0){
                continue; //소수가 아닐시 스킵
            }else{
                for(int j = i*2; j < M+1; j+=i){ //각 소수의 배수를 제거해주는중
                    arr[j] = 0;
                }
            }
        }

        for(int i = N; i < M+1; i++){
            if(arr[i] != 0 && arr[i] != 1){ //소수아닌건 0이니깐
                System.out.println(arr[i]);
            }
        }
    }
}
