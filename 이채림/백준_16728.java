import java.io.*;
import java.lang.*;

public class 백준_16728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int score = 0;
        
        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            score = score + calScore(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
        }
        System.out.println(score);
    }
    public static int calScore(Double distance){
        if(distance <= 10){
            return 10;
        } else if(distance <= 30){
            return 9;
        }else if(distance <= 50){
            return 8;
        }else if(distance <= 70){
            return 7;
        }else if(distance <= 90){
            return 6;
        }else if(distance <= 110){
            return 5;
        }else if(distance <= 130){
            return 4;
        }else if(distance <= 150){
            return 3;
        }else if(distance <= 170){
            return 2;
        }else if(distance <= 190){
            return 1;
        }else if(distance > 190){
            return 0;
        }
        return 0;
    }
}
