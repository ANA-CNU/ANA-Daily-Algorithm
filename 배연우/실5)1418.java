import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] primeNumbers = new int[100_001];
    static ArrayList<Integer> primeNumberSet = new ArrayList<>();
    public static void main(String[] Args) throws IOException {
        //init primeNumbers
        for (int i = 0; i < 100_001; i++) {
            primeNumbers[i] = i;
        }
        primeNumbers[1] = 0;
        for (int i = 0; i < 100_001; i++) {
            int tar = primeNumbers[i];
            if(tar == 0) {
                continue;
            }
            for (int j = tar*2; j < 100_001; j+=tar) {
                primeNumbers[j] = 0;
            }
        }
        for (int i = 0; i < 100_001; i++) {
            if(primeNumbers[i] != 0)
                primeNumberSet.add(i);
        }
        //input
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        //special case
        if(N == 1 || K == 1) {
            System.out.println(1);
            return;
        }

        //calculate
        int cnt = 1;
        for (int i = 2; i <= N; i++) {
            int maxPrimeFactor = getMaxPrimeFactor(i);
            cnt += maxPrimeFactor <= K ? 1 : 0;
        }

        //output
        System.out.println(cnt);
    }

    static int getMaxPrimeFactor(int tar) {
        int retIndex = 0;
        int tmp = primeNumberSet.get(retIndex);
        while(tar / tmp != 0) {
            if(tar % tmp == 0)
                tar /= tmp;
            else {
                retIndex++;
                tmp=primeNumberSet.get(retIndex);
            }
        }

        return primeNumberSet.get(retIndex);
    }
}