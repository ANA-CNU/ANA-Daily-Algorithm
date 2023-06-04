import java.util.*;

public class Boj2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (int num : arr) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                map.put(num, count);

                if (maxCount < count) {
                    maxCount = count;
                }
            } else {
                map.put(num, 1);

                if (maxCount < 1) {
                    maxCount = 1;
                }
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        int a = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxCount)) {
                list.add(entry.getKey());
                a++;
            }
        }
        Collections.sort(list);
        System.out.println(Math.round(sum/n));
        System.out.println(arr[(n + 1) / 2 - 1]);
        if (a!=1) {
            System.out.println(list.get(1));
        } else
            System.out.println(list.get(0));
        System.out.println(arr[n - 1] - arr[0]);
    }
}
