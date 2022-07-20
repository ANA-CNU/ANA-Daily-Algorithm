import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Naong {
    static int re(int N, int count){
        if(N == 1 || N == 0){
            return count;
        }else{
            return (Math.min(re(N/3, count+1+(N%3)), re(N/2, count+1+(N%2))));
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        System.out.println(re(N, 0));
    }
}
//항상 2로나누던 3으로나누던 +1한게 카운트수
// 4일때 4 -> 2 -> 1 (4%2 +1)
// 7일때 7 -> 3 -> 1 || 7 -> 2 -> 1(1빼는거)
// 9일때 9 -> 4 -> 2 -> 1 || 9 -> 3 -> 1