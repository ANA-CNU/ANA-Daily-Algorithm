
import java.util.*;
import java.io.*;

class Max {
    static int total;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());

        int zero = 0;

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if(temp < 0) {
                minus.add(temp);
            }else if(temp > 0){
                plus.add(temp);
            }else{
                zero++;
            }
        }

        if(!minus.isEmpty()) {
            while (true) {
                if(minus.size() == 1){
                    if(zero < 1){
                        total += (minus.remove());
                    }
                    break;
                }

                int first = minus.remove();
                int second = minus.remove();

                total += (first * second);

                if(minus.isEmpty()){
                    break;
                }
            }
        }

        if(!plus.isEmpty()) {
            while (true) {
                if(plus.size() == 1){
                    total += (plus.remove());
                    break;
                }

                int first = plus.remove();
                int second = plus.remove();

                if(first == 1 || second == 1){
                    total += first;
                    total += second;
                }else{
                    total += (first * second);
                }

                if(plus.isEmpty()){
                    break;
                }
            }
        }

        System.out.println(total);
    }
}
