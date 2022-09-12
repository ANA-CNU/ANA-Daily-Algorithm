import java.io.*;
import java.util.StringTokenizer;

public class S2_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){

            arr[i] = Integer.parseInt(st2.nextToken());

        }

        int cur = arr[0];
        int max = cur;


        for(int j = 1; j < N; j++){

            cur = Math.max(0,cur)+arr[j]; // cur(이전까지의 최대합)이 음수라면 최대합에 포함시키는게 불리하므로 비교후 더함
            max = Math.max(cur,max); //새로운 최대합과 이전의 최대합 비교

        }

        bw.write(max+"");



        bw.flush();
        bw.close();
    }
}
