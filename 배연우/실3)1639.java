import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] inputArr;
    public static void main(String[] Args) throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        inputArr = input.toCharArray();

        int max = 0;
        for (int i = 0; i < input.length()-1; i++) {
            for (int j = i+1; j < input.length(); j++) {
                if(isLucky(i,j))
                    max = Math.max(max, j-i+1);
            }
        }

        System.out.println(max);
    }

    static boolean isLucky(int i, int j) {
        if((j-i) % 2 == 0)
            return false;
        int left = 0;
        int right = 0;
        for (int k = 0; k < (j-i+1)/2; k++) {
            left += inputArr[i+k] - '0';
            right += inputArr[j-k] - '0';
        }
        return left == right;
    }
}