package _2022_2학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1543 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String str = br.readLine();

        int size = doc.length();
        int size2 = str.length();

        doc = doc.replace(str, "");
        System.out.println((size - doc.length()) / size2);
    }
}

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        char[] doc = br.readLine().toCharArray();
//        char[] ch = br.readLine().toCharArray();
//
//        int index = 0;
//        int result = 0;
//
//        for (int i = 0; i < doc.length; i++) {
//            if(doc[i] == ch[index]){
//                index ++;
//            }else{
//                i = i - index + 1;
//                index = 0;
//                if(i == doc.length) break;
//                if(doc[i] == ch[index]){
//                    index++;
//                }
//            }
//            if(index == ch.length){
//                result++;
//                index = 0;
//            }
//        }
//        System.out.println(result);
