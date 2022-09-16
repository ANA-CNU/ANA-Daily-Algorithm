import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baek1038 {
    static List<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        if(input<=10){
            System.out.println(input);
        }
        else if(input > 1022){
            System.out.println(-1);
        }
        else{

            for(int i=0;i<10;i++){
                Calculate(i,1);
            }
            Collections.sort(list);
            System.out.println(list.get(input));
        }

    }

    private static void Calculate(long number, int index) {
        if(index > 10){
            return;
            //9876543210 이 마지막 이므로
        }
        list.add(number);
        for(int i=0;i<10;i++){
            if(number%10>i){

                Calculate((number*10)+i, index+1);
            }
        }

        return;
    }
}
