import java.io.*;
import java.util.*;
public class Boj1083{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int s = Integer.parseInt(br.readLine());
        int move = 0;
        int changeidx = 0;
        while (move < s && changeidx < n - 1) {
            int maxnum = arr.get(changeidx);
            int max = -1;
            int idx = changeidx + 1;
            int count = 1;
            while (move + count <= s && idx < n) {
                int num = arr.get(idx);
                if (num > maxnum) {
                    maxnum = num;
                    max = idx;
                }
                count++;
                idx++;
            }
            if (max != -1) {
                arr.remove(max);
                arr.add(changeidx, maxnum);
                move += max - changeidx;
            }
            changeidx++;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
