import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class B1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int c = 1;

        for(int i =0; i<input.length()-1; i++) {
            if(input.charAt(i)!=input.charAt(i+1)) {
                c++;
            }
        }
        System.out.println(c/2);
    }
}
