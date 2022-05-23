import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] memArr;
    static int[] arr;
    public static void main(String[] Args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memArr = new int[N][];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[N-i-1]=Integer.parseInt(st.nextToken());
        }
        memArr[0] =new int[]{arr[0]};
        bottomUp(1);

        int maxArrLength = 0;
        for (int i = 0; i < N; i++) {
            maxArrLength = Math.max(maxArrLength, memArr[i].length);
        }

        System.out.println(maxArrLength);
    }

    static void bottomUp(int index) {
        if(index == arr.length) {
            return;
        }
        int maxIndex = 0;
        int maxCnt = 0;
        for (int i = 0; i < index; i++) {
            if(memArr[i].length < maxCnt) {
                continue;
            }
            if(memArr[i][memArr[i].length-1] >= arr[index]) {
                continue;
            }
            maxCnt = memArr[i].length;
            maxIndex = i;
        }
        int[] retArr = new int[maxCnt+1];
        memArr[index] = retArr;
        System.arraycopy(memArr[maxIndex], 0, retArr, 0, memArr[maxIndex].length);
        retArr[maxCnt] = arr[index];
        bottomUp(index+1);
    }
}