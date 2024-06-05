import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int[] arr = new int[count];
        int sum = 0;
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        if (sum > 0) {
            bw.write((int) ((double) sum / (double) count + 0.5) + "");
            bw.newLine();
        } else {
            bw.write((10 * sum / count - 5) / 10 + "");
            bw.newLine();
        }

        Arrays.sort(arr);

        if (count % 2 == 0) {
            bw.write((arr[count / 2] + arr[count / 2 + 1]) / 2 + "");
            bw.newLine();
        } else {
            bw.write(arr[count / 2] + "");
            bw.newLine();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (hashMap.getOrDefault(arr[i], 0) > max) {
                max = hashMap.getOrDefault(arr[i], 0);
                arrayList.clear();
                arrayList.add(arr[i]);
            } else if (hashMap.getOrDefault(arr[i], 0) == max && !arrayList.contains(arr[i])) {
                arrayList.add(arr[i]);
            }
        }
        if (arrayList.size() == 1) {
            bw.write(arrayList.get(0) + "");
            bw.newLine();
        } else {
            bw.write(arrayList.get(1) + "");
            bw.newLine();
        }

        bw.write(arr[count - 1] - arr[0] + "");
        bw.close();
    }
}
