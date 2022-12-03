import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            int leng = temp.length() - 1;

            for(int j = 0; j < temp.length(); j++) {
                String key = String.valueOf(temp.charAt(j));
                if(!hashMap.containsKey(key)){
                    hashMap.put(key, (int) Math.pow(10, leng - j));
                }else{
                    hashMap.put(key, (int) (hashMap.get(key) + (Math.pow(10, leng - j))));
                }
            }
        }

        for(String key : hashMap.keySet()) {
            priorityQueue.add(hashMap.get(key));
        }

        int num = 9;
        long total = 0;
        while (!priorityQueue.isEmpty()) {
            int temp = priorityQueue.remove();
            total += ((long) temp * num);
            num--;
        }

        System.out.println(total);
    }
}
