import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Horororo {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < A; i++){ //A셋만들어줌
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < B; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!setA.contains(num)){ //A에 B원소포함안하면
                setA.add(num); //추가해주고
            }else{ //겹치면 지워줌
                setA.remove(num);
            }
        }
        System.out.println(setA.size());
    }
}
