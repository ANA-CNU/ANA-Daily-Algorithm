import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 백준_1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nList = new int[N];

        for(int i = 0; i < N; i++){
            nList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nList);   

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] mList = new int[M];

        for(int i = 0; i < M; i++){
            mList[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < mList.length; i++){
            int low = 0;
            int high = nList.length-1;
            int target = mList[i];
            boolean check = false;
            while(low <= high){
                int middle = (low+high) / 2;

                if(nList[middle] > target){
                    high = middle - 1;
                }else if(nList[middle] < target){
                    low = middle + 1;
                }else{
                    check = true;
                    break;
                }
            }
            if(check==false){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }

    }
}
