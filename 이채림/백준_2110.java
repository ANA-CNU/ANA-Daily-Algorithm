import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2110 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] coordinates = new int[N];

        for(int i = 0; i < N; i++){
            coordinates[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(coordinates);

        // 이분탐색으로 거리를 줄여가면서
        // 설치가 가능한 공유기 개수를 세기
        int low = 1; // 최소 거리는 1
        int high = coordinates[N-1] - coordinates[0] + 1;
        
        while(low <= high){
            int mid = (low + high) / 2;

            if(countC(mid, N, coordinates) < C){    
                // 공유기 개수 적음. 공유기 개수 늘리려면 거리 좁혀야함
                high = mid - 1;
            } else {
                // 공유기 개수 많음. 공유기 개수 줄이려면 거리 넓혀야함
                low = mid + 1;
            }
        }
        System.out.println(low-1);
  
    }
    // 공유기 사이의 거리를 인자로 넣어줌
    // 설치 가능한 공유기 개수 반환
    
    public static int countC(int mid, int N, int[] coordinates){
        int count = 1;
        int lastHouse = coordinates[0];

        for(int i = 1; i < N; i++){
            if(coordinates[i] - lastHouse >= mid){
                count++;
                lastHouse = coordinates[i];
            }
        }
        return count;
    }
}
