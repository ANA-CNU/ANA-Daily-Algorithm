import java.io.*;
import java.util.*;

public class Bronze {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(),"*");

        String first = st.nextToken();
        String second = st.nextToken();

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();

            if(temp.length() < first.length() + second.length()) {
                sb.append("NE").append('\n');
                continue;
            }

            String tempFirst = "";
            for(int j = 0; j < first.length(); j++) {
                tempFirst += String.valueOf(temp.charAt(j));
            }

            if(!first.equals(tempFirst)){
               sb.append("NE").append('\n');
               continue;
            }

            String tempSecond = "";
            int start = temp.length() - second.length();
            for(int j = start; j < temp.length(); j++) {
                tempSecond += String.valueOf(temp.charAt(j));
            }

            if(second.equals(tempSecond)){
                sb.append("DA").append('\n');
            }else{
                sb.append("NE").append('\n');
            }
        }
        System.out.println(sb);
    }
}

