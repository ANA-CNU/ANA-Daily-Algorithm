
import annotation.boj.BOJ;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by ShinD on 2022-03-04.
 */
@BOJ
public class 백준11653 {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        int input=sc.nextInt();


        int [] decimal = IntStream.rangeClosed(0,input).toArray();

        decimal[0]=0;
        decimal[1]=0;
        for (int i = 2; i * i <= input; i++){
            if(decimal[i] == 0 )continue;

            for (int j = i + i; j<= input; j+=i){
                decimal[j]=0;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (input > 1){

            for(int i = input; i>= 0; i--){
                if(decimal[i] != 0){
                    if(input % i == 0){
                        input = input/i;
                        list.add(i);
                    }
                }
            }
        }
        Collections.sort(list, Comparator.naturalOrder());

        list.forEach(System.out::println);



    }
}
