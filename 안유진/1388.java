import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

       char arr[][] = new char[N][M];
       int total = 1;

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 1; i < M; i++){
            if(arr[0][i] == '-'){
                if(arr[0][i-1] != '-'){
                    total++;
                }
            }else{
                total++;
            }
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                char ch = arr[i][j];
                if(ch == '-'){
                    if(j == 0){
                        total++;
                    }else if(arr[i][j-1] != '-'){
                        total++;
                    }
                }else{
                    if(arr[i - 1][j] != '|'){
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }
}
