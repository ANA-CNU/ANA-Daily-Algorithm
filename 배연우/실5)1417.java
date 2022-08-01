import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    public static void main(String[] Args) throws IOException {
        //input
        int cnt = getInt();
        arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = getInt();
        }

        //calculate BF
        //find O(n)
        cnt = 0;
        while(getBestIndex() != 0) {
            int tar = getBestIndex();
            arr[0]++;
            arr[tar]--;
            cnt++;
        }

        //output
        System.out.println(cnt);
    }

    static int getInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int getBestIndex() {
        int ret = arr.length-1;
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(arr[i] > arr[ret]) {
                ret = i;
            }
        }
        return ret;
    }
}