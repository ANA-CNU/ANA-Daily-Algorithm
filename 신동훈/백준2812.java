
import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ShinD on 2022-03-06.
 */
@BOJ
public class 백준2812 {
/**
 * 들어오면서 다 처리했다면, 맨 뒤에서부터 하나씩 지워
 *
 * 77541
 */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int removeCount = ints[1];

        List<Integer> collect = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).collect(Collectors.toList());

        Deque<Integer> deque = new ArrayDeque<>();



        for (int i = 0; i < collect.size(); i++){
            int inputNumber = collect.get(i);


            while (!deque.isEmpty()){
                if(removeCount == 0){
                    break;
                }
                Integer peek = deque.peekLast();
                if(peek < inputNumber){
                    deque.removeLast();
                    removeCount--;
                }else break;
            }
            deque.add(inputNumber);
        }
        while (removeCount > 0){
            deque.removeLast();
            removeCount--;
        }

        deque.forEach(i -> System.out.print(deque.removeFirst()));




    }




}
