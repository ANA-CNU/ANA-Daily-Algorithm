import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        boolean flag = false;
        boolean error = false;

        if(s.length() > 100){
            error = true;
        }

        if(s.charAt(0) >= 65 && s.charAt(0) <= 90){
            error = true;
        }
        if(s.charAt(s.length() - 1) == '_'){
            error = true;
        }
        if(s.charAt(0) == '_'){
            error = true;
        }
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '_'){
                flag = true;
            }
            if(s.charAt(i) == '_' && s.charAt(i + 1) == '_'){
                error = true;
                break;
            }
        }
        //c++인경우
        if(flag){
            String temp = s;
            StringTokenizer st = new StringTokenizer(temp, "_");
            int token = st.countTokens();
            for(int i = 0; i < token; i++){
                String now = st.nextToken();

                for(int j = 0; j < now.length(); j++){
                    if(now.charAt(j) >= 65 && now.charAt(j) <= 90){
                        error = true;
                        break;
                    }
                }

                if(i == 0){
                    sb.append(now);
                }else{
                    sb.append(String.valueOf(now.charAt(0)).toUpperCase());
                    for(int j = 1; j < now.length(); j++){
                        sb.append(String.valueOf(now.charAt(j)));
                    }
                }
            }
        }else{
            for(int i = 0; i < s.length() - 1; i++){
                if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                    sb.append(String.valueOf(s.charAt(i)).toLowerCase());
                }else{
                    sb.append(s.charAt(i));
                }
                if(s.charAt(i + 1) >= 65 && s.charAt(i + 1) <= 90){
                    sb.append("_");
                }
            }
            int leng = s.length();
            sb.append(String.valueOf(s.charAt(leng - 1)).toLowerCase());
        }

        if(error){
            System.out.println("Error!");
        }else{
            System.out.println(sb);
        }

    }
}
