
import java.io.*;

import java.util.*;
public class B2_2908 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        String n = st.nextToken();
        String m = st.nextToken();

        String num1 = "";
        String num2 = "";

        for(int i =n.length()-1; i>=0; i--){

            num1 += n.charAt(i);

        }
        for(int i =m.length()-1; i>=0; i--){

            num2 += m.charAt(i);

        }

        int max = (Integer.parseInt(num1)<Integer.parseInt(num2)) ? Integer.parseInt(num2):Integer.parseInt(num1);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
