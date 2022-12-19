import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] create(int size) {
        return new int[size];
    }

    public static void fillAndSort(int[] arr) throws IOException {
        StringTokenizer a = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(a.nextToken());
        Arrays.sort(arr);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        int ans=1000000001;
        int[] A = create(Integer.parseInt(s.nextToken()));
        int[] B = create(Integer.parseInt(s.nextToken()));
        int[] C = create(Integer.parseInt(s.nextToken()));

        fillAndSort(A);
        fillAndSort(B);
        fillAndSort(C);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    ans=Math.min(Math.abs(Math.max(Math.max(A[i],B[j]),C[k])-Math.min(Math.min(A[i],B[j]),C[k])),ans);
                }
            }
        }
        System.out.println(ans);
    }
}
