import java.util.*;
import java.io.*;

public class Planets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n--> 0){
            Set <Integer> set = new HashSet<>();
            Hashtable<String, Integer> hashtable = new Hashtable<>();

            String in = br.readLine();

            StringTokenizer st = new StringTokenizer(in, ",");
            int token = st.countTokens();

            for(int i = 0; i < token; i++){
                StringTokenizer temp = new StringTokenizer(st.nextToken(),":");
                String sKey = temp.nextToken();
                int cost = Integer.parseInt(temp.nextToken());

                hashtable.put(sKey, cost);
            }

            in = br.readLine();
            st = new StringTokenizer(in, "|");
            token = st.countTokens();

            for(int i = 0; i < token; i++){
                StringTokenizer temp = new StringTokenizer(st.nextToken(),"&");
                int tempToken = temp.countTokens();

                int max = hashtable.get(temp.nextToken());

                for(int j = 1; j < tempToken; j++){
                    max = Math.max(max, hashtable.get(temp.nextToken()));
                }

                set.add(max);
            }

            int min = 1001;
            for(int num : set){
                min = Math.min(min, num);
            }

            sb.append(min).append('\n');
        }
        System.out.println(sb);
    }
}
