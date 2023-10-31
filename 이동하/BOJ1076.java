import java.util.*;
import java.io.*;

public class BOJ1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long first = 0;
        long second = 0;
        long third = 0;
        for (int i = 0; i < 3; i++) {
            String color = br.readLine();
            if (i == 0) {
                if (color.equals("black")) {
                    first = 0;
                } else if (color.equals("brown")) {
                    first = 1;
                } else if (color.equals("red")) {
                    first = 2;
                } else if (color.equals("orange")) {
                    first = 3;
                } else if (color.equals("yellow")) {
                    first = 4;
                } else if (color.equals("green")) {
                    first = 5;
                } else if (color.equals("blue")) {
                    first = 6;
                } else if (color.equals("violet")) {
                    first = 7;
                } else if (color.equals("grey")) {
                    first = 8;
                } else if (color.equals("white")) {
                    first = 9;
                }
            } else if (i == 1) {
                if (color.equals("black")) {
                    second = 0;
                } else if (color.equals("brown")) {
                    second = 1;
                } else if (color.equals("red")) {
                    second = 2;
                } else if (color.equals("orange")) {
                    second = 3;
                } else if (color.equals("yellow")) {
                    second = 4;
                } else if (color.equals("green")) {
                    second = 5;
                } else if (color.equals("blue")) {
                    second = 6;
                } else if (color.equals("violet")) {
                    second = 7;
                } else if (color.equals("grey")) {
                    second = 8;
                } else if (color.equals("white")) {
                    second = 9;
                }
            } else {
                if (color.equals("black")) {
                    third = 1;
                } else if (color.equals("brown")) {
                    third = 10;
                } else if (color.equals("red")) {
                    third = 100;
                } else if (color.equals("orange")) {
                    third = 1000;
                } else if (color.equals("yellow")) {
                    third = 10000;
                } else if (color.equals("green")) {
                    third = 100000;
                } else if (color.equals("blue")) {
                    third = 1000000;
                } else if (color.equals("violet")) {
                    third = 10000000;
                } else if (color.equals("grey")) {
                    third = 100000000;
                } else if (color.equals("white")) {
                    third = 1000000000;
                }
            }
        }
        System.out.println((first*10 + second)*third);
    }
}