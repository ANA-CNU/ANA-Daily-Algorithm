import java.io.*;
import java.util.*;

public class Main {
    static char[][] a;
    static char[][] b;
    static int N;
    public static class Loc{
        int i=0;
        int j=0;
        Loc(int ii,int jj){
            i=ii;
            j=jj;
        }
    }
    public static class Q{
        int r=0;
        int f=0;
        Loc[] data;
        int MAX_SIZE;
        Q(int size){
            data=new Loc[size];
            MAX_SIZE=size;
        }

        void eq(Loc i){
            r=(r+1)%MAX_SIZE;
            data[r]=i;
        }

        Loc dq(){
            f=(f+1)%MAX_SIZE;
            return data[f];
        }

        boolean isEmpty(){
            return(f==r);
        }
    }
    public static void main(String[] args) throws IOException {
        search();
    }

    public static void search() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result_a=0;
        int result_b=0;
        char[] types={'R','G','B'};
        N = Integer.parseInt(br.readLine());
        a=new char[N][N];
        b=new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                a[i][j] = s.charAt(j);
                b[i][j] = a[i][j];
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                if(a[i][j]!='.') {
                    BFS_a(i, j);
                    result_a++;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                if(b[i][j]!='.') {
                    BFS_b(i, j);
                    result_b++;
                }
            }
        }

        System.out.println(result_a+" "+result_b);
    }

    public static void BFS_a(int I,int J) {
        char type=a[I][J];
        a[I][J]='.';
         Q q=new Q(N*N);
         q.eq(new Loc(I,J));

       while(!q.isEmpty()){
           Loc currentLoc=q.dq();

           if(currentLoc.i+1<N && a[currentLoc.i+1][currentLoc.j]==type){
               a[currentLoc.i+1][currentLoc.j]='.';
               q.eq(new Loc(currentLoc.i+1, currentLoc.j));
           }
           if(currentLoc.i-1>-1 && a[currentLoc.i-1][currentLoc.j]==type){
               a[currentLoc.i-1][currentLoc.j]='.';
               q.eq(new Loc(currentLoc.i-1, currentLoc.j));
           }
           if(currentLoc.j+1<N && a[currentLoc.i][currentLoc.j+1]==type){
               a[currentLoc.i][currentLoc.j+1]='.';
               q.eq(new Loc(currentLoc.i, currentLoc.j+1));
           }
           if(currentLoc.j-1>-1 && a[currentLoc.i][currentLoc.j-1]==type){
               a[currentLoc.i][currentLoc.j-1]='.';
               q.eq(new Loc(currentLoc.i, currentLoc.j-1));
           }
       }
    }

    public static void BFS_b(int I,int J) {
        char type_1=b[I][J];
        char type_2=b[I][J];
        b[I][J]='.';
        if(type_1=='G'){
            type_2='R';
        }else if(type_1=='R'){
            type_2='G';
        }

        Q q=new Q(N*N);
        q.eq(new Loc(I,J));

        while(!q.isEmpty()){
            Loc currentLoc=q.dq();

            if(currentLoc.i+1<N && (b[currentLoc.i+1][currentLoc.j]==type_1 ||  b[currentLoc.i+1][currentLoc.j]==type_2)){
                b[currentLoc.i+1][currentLoc.j]='.';
                q.eq(new Loc(currentLoc.i+1, currentLoc.j));
            }
            if(currentLoc.i-1>-1 && (b[currentLoc.i-1][currentLoc.j]==type_1 ||  b[currentLoc.i-1][currentLoc.j]==type_2)){
                b[currentLoc.i-1][currentLoc.j]='.';
                q.eq(new Loc(currentLoc.i-1, currentLoc.j));
            }
            if(currentLoc.j+1<N && (b[currentLoc.i][currentLoc.j+1]==type_1 ||  b[currentLoc.i][currentLoc.j+1]==type_2)){
                b[currentLoc.i][currentLoc.j+1]='.';
                q.eq(new Loc(currentLoc.i, currentLoc.j+1));
            }
            if(currentLoc.j-1>-1 && (b[currentLoc.i][currentLoc.j-1]==type_1 ||  b[currentLoc.i][currentLoc.j-1]==type_2)){
                b[currentLoc.i][currentLoc.j-1]='.';
                q.eq(new Loc(currentLoc.i, currentLoc.j-1));
            }
        }
    }
}

/**
 * ctrl + e // 작업창 전환
 * ctrl + alt + m // 메서드 추출
 * ctrl + alt + v // 변수타입 자동선언
 * ctrl + b // 출처?
 * <p>
 * ctrl alt o // 사용되는 import만 작성
 * ctrl alt l // 줄바꿈
 * shift f6 // 변수명 일괄 변경
 */
