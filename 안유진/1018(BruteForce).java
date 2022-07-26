import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[][];
    static int min = 64;
    public static void check(int x, int y){ //떼어서 온 사각형 검사
        int count = 0;
        int seccount = 0;
        int Nend = x + 7;
        int Mend = y + 7;

        int checking = arr[x][y]; //첫번째 색 하양이냐 깜장이냐

        for(int i = x; i <= Nend; i++){
            for(int j = y; j <= Mend; j++){

                if(arr[i][j] != checking){
                    count++;
                }
                if(j != Mend){ //마지막칸이면 다음시작이 같아야해서 바꿔주지 X
                    if(checking == 0){ //한칸이동시마다 색바꿔줌
                        checking = 1;
                    }else{
                        checking = 0;
                    }
                }
            }
        }

        if(checking == 0){ //w 였다면 b로 시작하게 다시
            checking = 1;
        }else{ //b였다면 w로 시작하게 다시
            checking = 0;
        }

        for(int i = x; i <= Nend; i++){
            for(int j = y; j <= Mend; j++){

                if(arr[i][j] != checking){
                    seccount++;
                }
                if(j != Mend){
                    if(checking == 0){
                        checking = 1;
                    }else{
                        checking = 0;
                    }
                }
            }
        }
        min = Math.min(min, Math.min(seccount, count));
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        //W = 0, B= 1
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                if(s.charAt(j) == 'W'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }
        int newN = N-7; //전체에서 8칸제외한것만큼 경우의수
        int newM = M-7;

        for(int i = 0; i < newN ; i++){
            for(int j = 0; j < newM; j++){
                check(i, j);
            }
        }
        System.out.println(min);
    }
}
