import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class 백준_18870 {
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[]  coordinates = new int[N];
		int[] sortArr = new int[N];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		String[] temp = br.readLine().split(" ");
		
        for(int i = 0 ; i < N; i++) {
			coordinates[i] = Integer.parseInt(temp[i]);
		}
		sortArr = coordinates.clone();

		Arrays.sort(sortArr);
		
		int cnt = 0;
		
		for(int a: sortArr) {
			if(!map.containsKey(a)) {
			map.put(a, cnt);
            cnt++;
			}
			
		}
		
		for(int key: coordinates) {
			sb.append(map.get(key)).append(" ");
		}
        
        System.out.println(sb.toString());
		
	}
}
