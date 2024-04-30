import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        String[] arr = new String[count];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        String[][] lenarr = new String[50][20000];

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(arr[i + 1])) {
                arr[i] = null;
            }
        }

        for (int i = 1; i <= 50; i++) {
            int num = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != null)
                    if (arr[j].length() == i) {
                        lenarr[i - 1][num] = arr[j];
                        num++;
                    }
            }
        }

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < lenarr[i].length; j++) {
                if (lenarr[i][j] != null) {
                    System.out.println(lenarr[i][j]);
                }
            }
        }
    }
}
