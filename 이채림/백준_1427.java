import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 백준_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < st.length(); i++){
            arr.add(Character.getNumericValue(st.charAt(i)));
        }

        Collections.sort(arr, Comparator.reverseOrder());

        for(int i = 0; i < st.length(); i++){
            System.out.print(arr.get(i));
        }
    }
   
}
