import java.util.*;
import java.io.*;

public class 백준_2217 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[N];
        int max = 0;

        for(int i = 0; i < N; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder());
        
        for(int i = 0; i < N; i++){
            int weight = ropes[i] * (i+1); // 로프가 견디는 무게 중량 x 현재 로프 수
            if(weight > max){
                max = weight;
            }
        }
        System.out.println(max);        
    }
}