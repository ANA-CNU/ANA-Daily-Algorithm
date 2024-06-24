package havetostudy;

import java.io.*;
import java.util.*;

public class backjoon_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String mun = br.readLine();
        String bomb = br.readLine();
        String bombreverse = new StringBuffer(bomb).reverse().toString();
        int len = bomb.length();

        Deque<Character> de = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();

        int index = 0;
        for (int i = 0; i < mun.length(); i++) {
            de.push(mun.charAt(i));
            index = 0;
            if (de.peek() == bombreverse.charAt(index) && de.size() >= len){
                for (int j = 0; j < len; j++) {
                    char tempc = de.pop();
                    if (tempc == bombreverse.charAt(index)) {
                        temp.push(tempc);
                        index++;
                    }else {
                        de.push(tempc);
                        while (!temp.isEmpty()) {
                            de.push(temp.pop());
                        }
                        break;
                    }
                }
                if (index == len) {
                    temp.clear();
                }
            }
        }

        if (de.isEmpty()) {
            bw.write("FRULA\n");
        }else {
            while (!de.isEmpty()) {
                bw.write(de.pollLast());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

