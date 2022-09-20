import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set <String> set = new HashSet<>();

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            String temp = "";
            temp += String.valueOf(s.charAt(i));
            set.add(String.valueOf(s.charAt(i)));
            for(int j = i + 1; j < s.length(); j++){
                temp += (String.valueOf(s.charAt(j)));
                set.add(temp);
            }
        }
        System.out.println(set.size());
    }
}
