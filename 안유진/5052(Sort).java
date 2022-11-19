import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t -- > 0){
            int n = Integer.parseInt(br.readLine());

            HashSet<String> hashSet = new HashSet<>();
            String arr[] = new String[n];
            boolean flag = true;

            for(int i = 0; i < n; i++) {
                String in = br.readLine();
                arr[i] = in;
            }

            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.compare(o1.length(), o2.length());
                }
            });

            for(int i = 0; i < n; i++){
                String temp = arr[i];
                String s = "";
                for(int j = 0; j < temp.length(); j++){
                    s += String.valueOf(temp.charAt(j));
                    if(hashSet.contains(s)){
                        flag = false;
                    }
                }
                if(flag) {
                    hashSet.add(temp);
                }else{
                    break;
                }
            }

            if(flag) {
                sb.append("YES").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }
}
