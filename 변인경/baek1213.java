package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] arr = new char[input.length()];
        char[] resultArr = new char[input.length() / 2];
        boolean flag = true;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.charAt(i);
        }

        Arrays.sort(arr);
        int index = 0;
        if (input.length() % 2 == 1) {
            //홀수
            char rest_Piece = 0;
            boolean one_chance = true;
            for (int i = 0; i < arr.length-1; i += 2) {

                if (one_chance) {
                    if (arr[i] != arr[i + 1]) {
                        rest_Piece = arr[i];
                        one_chance = false;
                        if (arr[i + 1] != arr[i + 2]) {
                            flag = false;
                            break;
                        } else {
                            i += 1;
                        }
                    }
                } else {
                    if (arr[i] != arr[i + 1]) {

                        flag = false;
                        break;
                    }
                }
                index = i;
                resultArr[k] = arr[i];
                k++;


            }
            if (one_chance) {
                rest_Piece = arr[arr.length - 1];

            }
            if (flag) {
                for (char c : resultArr) {
                    System.out.print(c);
                }
                System.out.print((char) rest_Piece);
                for (int i = resultArr.length - 1; i >= 0; i--) {
                    System.out.print(resultArr[i]);
                }
            } else {

                System.out.println("I'm Sorry Hansoo");
            }


        } else {
            for (int i = 0; i < arr.length - 1; i += 2) {
                if (arr[i] != arr[i + 1]) {
                    flag = false;
                }
                resultArr[k] = arr[i];
                k++;
            }
            if (flag) {
                for (int i = 0; i < resultArr.length; i++) {
                    System.out.print(resultArr[i]);
                }
                for (int i = resultArr.length - 1; i >= 0; i--) {
                    System.out.print(resultArr[i]);
                }

            } else {
                System.out.println("I'm Sorry Hansoo");
            }
        }
    }
}
