import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE; //부분합중 짧은것의 길이
        int sum = 0; //부분합이랑 구해야하는 S랑 비교하기위한 총합

        while (true){
            if(sum >= S){ //총합이 구해야하는 수보다 넘어가버리면 작은거부터 빼줌
                sum -= arr[left];
                int temp = right - left;
                if(temp < length){
                    length = temp;
                }
                left++; //현재 부분합이 M이상이면 left ++
            }else if(right == N){
                break;
            }else{
                sum += arr[right];
                right++; //아니라면 right ++
            }
        }

        if(length == Integer.MAX_VALUE){
            System.out.println(0); //변경이 이루어져지지 않으면 경우가없는거니까 0
        }else{
            System.out.println(length); //아니면 길이
        }
    }
}
//구간합은 arr[R] - arr[L-1]이다.
//
