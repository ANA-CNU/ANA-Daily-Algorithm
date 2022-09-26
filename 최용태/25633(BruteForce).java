import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer s=new StringTokenizer(br.readLine()," ");

        int[] sumOfArray=new int[N];
        int max=0;
        ArrayList<ArrayList<Integer>> array=new ArrayList<>();

        for(int i=0;i<N;i++){
            array.add(new ArrayList<>());
        }

        for(int i=0;i<N;i++){
            int inputValue=Integer.parseInt(s.nextToken());
            int currentBoxSize=0;

            while(currentBoxSize<N && inputValue>sumOfArray[currentBoxSize]){
                if(currentBoxSize>=i) {
                    array.get(currentBoxSize).removeAll(array.get(currentBoxSize));
                    array.get(currentBoxSize).add(inputValue);
                    sumOfArray[currentBoxSize] = inputValue;
                }
                currentBoxSize++;
            }

            while(currentBoxSize<N && inputValue<=sumOfArray[currentBoxSize]){
                array.get(currentBoxSize).add(inputValue);
                sumOfArray[currentBoxSize]+=inputValue;
                currentBoxSize++;
            }
        }

        for(int i=0;i<N;i++){
            max=Math.max(array.get(i).size(),max);
        }

        System.out.println(max);
    }
}