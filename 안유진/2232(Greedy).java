import java.io.*;
import java.util.*;

public class Main {
    public static int sti(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sti(br.readLine());
        int arr[] = new int[N];

        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.value - o1.value;
            }
        });

        for(int i = 0; i < N; i++) {
            int temp = sti(br.readLine());
            q.add(new Pair(i, temp));
            arr[i] = temp;
        }

        boolean visited[] = new boolean[N];
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (!q.isEmpty()) {
            Pair current = q.remove();

            if(visited[current.index]){
                continue;
            }else{
                arrayList.add(current.index + 1);
            }

            int currentMax = current.value;
            int currentIndex = current.index;

            for(int i = currentIndex - 1; i >= 0; i--) {
                if(arr[i] < currentMax) {
                    currentMax = arr[i];
                    visited[i] = true;
                }else{
                    break;
                }
            }

            currentMax = current.value;
            for(int i = currentIndex + 1; i < N; i++) {
                if(arr[i] < currentMax) {
                    currentMax = arr[i];
                    visited[i] = true;
                }else{
                    break;
                }
            }
        }

        Collections.sort(arrayList);
        for(int temp : arrayList) {
            System.out.println(temp);
        }
    }
}
class Pair{
    int index;
    int value;
    Pair(int i, int v) {
        index = i;
        value = v;
    }
}
