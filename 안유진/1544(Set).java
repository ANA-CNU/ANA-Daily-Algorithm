import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Rulu {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        String arr[] = new String[N];

        int count = 0;
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
            if(!set.contains(arr[i])){
                count++;
            }
            for(int j = 0; j < arr[i].length(); j++){
                StringBuilder temp = new StringBuilder();
                for(int k = j; k < arr[i].length(); k++){
                    temp.append(arr[i].charAt(k));
                }
                for(int k = 0; k < j; k++){
                    temp.append(arr[i].charAt(k));
                }
                set.add(temp.toString());
            }
        }
        System.out.println(count);
    }
}
