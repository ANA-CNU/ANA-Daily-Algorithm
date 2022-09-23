import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)){ //절댓값같으면
                    return o1 - o2;
                }else{
                    return -1;
                }
            }
        });

        while (N --> 0){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(priorityQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(priorityQueue.remove());
                }
            }else{
                priorityQueue.add(temp);
            }
        }
    }
}
