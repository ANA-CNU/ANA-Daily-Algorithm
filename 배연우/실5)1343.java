import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] Args) throws IOException {
        char[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        boolean[] field = new boolean[input.length];
        for (int i = 0; i < input.length; i++) {
            field[i] = input[i] == 'X';
        }

        for (int i = 0; i < field.length - 3; i++) {
            boolean A = true;
            for (int j = i; j < i+4; j++) {
                if (!field[j]) {
                    A = false;
                    break;
                }
            }
            if(A) {
                for (int j = i; j < i+4; j++) {
                    field[j] = false;
                    input[j] = 'A';
                }
            }
        }


        for (int i = 0; i < field.length - 1; i++) {
            boolean B = true;
            for (int j = i; j < i+2; j++) {
                if(!field[j]) {
                    B = false;
                    break;
                }
            }
            if(B) {
                for (int j = i; j < i+2; j++) {
                    field[j] = false;
                    input[j] = 'B';
                }
            }
        }

        for (boolean b : field) {
            if (b) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : input) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}