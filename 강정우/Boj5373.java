import java.io.*;
import java.util.*;
public class Boj5373 {
    static char[][][] c;
    static void rm(int color_idx){
        char tmp1,tmp2;
        tmp1 = c[color_idx][0][0];
        tmp2 = c[color_idx][0][1];
        c[color_idx][0][0] = c[color_idx][0][2];
        c[color_idx][0][1] = c[color_idx][1][2];
        c[color_idx][0][2] = c[color_idx][2][2];
        c[color_idx][1][2] = c[color_idx][2][1];
        c[color_idx][2][2] = c[color_idx][2][0];
        c[color_idx][2][1] = c[color_idx][1][0];
        c[color_idx][2][0] = tmp1;
        c[color_idx][1][0] = tmp2;
    }
    static void rp(int color_idx){
        char tmp1,tmp2;
        tmp1 = c[color_idx][0][0];
        tmp2 = c[color_idx][0][1];
        c[color_idx][0][0] = c[color_idx][2][0];
        c[color_idx][0][1] = c[color_idx][1][0];
        c[color_idx][2][0] = c[color_idx][2][2];
        c[color_idx][1][0] = c[color_idx][2][1];
        c[color_idx][2][2] = c[color_idx][0][2];
        c[color_idx][2][1] = c[color_idx][1][2];
        c[color_idx][0][2] = tmp1;
        c[color_idx][1][2] = tmp2;
    }
    static void r_p(int color_idx){
        char tmp1,tmp2,tmp3;
        switch (color_idx){
            case 0://확인
                tmp1 = c[2][0][0];
                tmp2 = c[2][0][1];
                tmp3 = c[2][0][2];
                c[2][0][0] = c[5][0][0];
                c[2][0][1] = c[5][0][1];
                c[2][0][2] = c[5][0][2];
                c[5][0][0] = c[3][0][2];
                c[5][0][1] = c[3][0][1];
                c[5][0][2] = c[3][0][0];
                c[3][0][0]= c[4][0][0];
                c[3][0][1]= c[4][0][1];
                c[3][0][2]= c[4][0][2];
                c[4][0][0] = tmp3;
                c[4][0][1] = tmp2;
                c[4][0][2] = tmp1;
                break;
            case 1://확인
                tmp1 = c[2][2][0];
                tmp2 = c[2][2][1];
                tmp3 = c[2][2][2];
                c[2][2][0] = c[4][2][2];
                c[2][2][1] = c[4][2][1];
                c[2][2][2] = c[4][2][0];
                c[4][2][0] = c[3][2][0];
                c[4][2][1] = c[3][2][1];
                c[4][2][2] = c[3][2][2];
                c[3][2][0]= c[5][2][2];
                c[3][2][1]= c[5][2][1];
                c[3][2][2]= c[5][2][0];
                c[5][2][0] = tmp1;
                c[5][2][1] = tmp2;
                c[5][2][2] = tmp3;
                break;
            case 2://확인
                tmp1 = c[0][0][0];
                tmp2 = c[0][1][0];
                tmp3 = c[0][2][0];
                c[0][0][0] = c[4][2][0];
                c[0][1][0] = c[4][1][0];
                c[0][2][0] = c[4][0][0];
                c[4][0][0] = c[1][0][0];
                c[4][1][0] = c[1][1][0];
                c[4][2][0] = c[1][2][0];
                c[1][0][0]= c[5][2][0];
                c[1][1][0]= c[5][1][0];
                c[1][2][0]= c[5][0][0];
                c[5][0][0] = tmp1;
                c[5][1][0] = tmp2;
                c[5][2][0] = tmp3;
                break;
            case 3://확인
                tmp1 = c[0][0][2];
                tmp2 = c[0][1][2];
                tmp3 = c[0][2][2];
                c[0][0][2] = c[5][0][2];
                c[0][1][2] = c[5][1][2];
                c[0][2][2] = c[5][2][2];
                c[5][0][2] = c[1][2][2];
                c[5][1][2] = c[1][1][2];
                c[5][2][2] = c[1][0][2];
                c[1][0][2]= c[4][0][2];
                c[1][1][2]= c[4][1][2];
                c[1][2][2]= c[4][2][2];
                c[4][0][2] = tmp3;
                c[4][1][2] = tmp2;
                c[4][2][2] = tmp1;
                break;
            case 4://확인
                tmp1 = c[0][0][0];
                tmp2 = c[0][0][1];
                tmp3 = c[0][0][2];
                c[0][0][0] = c[3][0][0];
                c[0][0][1] = c[3][1][0];
                c[0][0][2] = c[3][2][0];
                c[3][0][0] = c[1][0][2];
                c[3][1][0] = c[1][0][1];
                c[3][2][0] = c[1][0][0];
                c[1][0][0]= c[2][0][0];
                c[1][0][1]= c[2][1][0];
                c[1][0][2]= c[2][2][0];
                c[2][0][0] = tmp3;
                c[2][1][0] = tmp2;
                c[2][2][0] = tmp1;
                break;
            case 5://확인
                tmp1 = c[0][2][0];
                tmp2 = c[0][2][1];
                tmp3 = c[0][2][2];
                c[0][2][0] = c[2][2][2];
                c[0][2][1] = c[2][1][2];
                c[0][2][2] = c[2][0][2];
                c[2][0][2] = c[1][2][0];
                c[2][1][2] = c[1][2][1];
                c[2][2][2] = c[1][2][2];
                c[1][2][0]= c[3][2][2];
                c[1][2][1]= c[3][1][2];
                c[1][2][2]= c[3][0][2];
                c[3][0][2] = tmp1;
                c[3][1][2] = tmp2;
                c[3][2][2] = tmp3;
                break;
        }
    }
    static void r_m(int color_idx){
        char tmp1,tmp2,tmp3;
        switch (color_idx){
            case 0://
                tmp1 = c[2][0][0];
                tmp2 = c[2][0][1];
                tmp3 = c[2][0][2];
                c[2][0][0] = c[4][0][2];
                c[2][0][1] = c[4][0][1];
                c[2][0][2] = c[4][0][0];
                c[4][0][0] = c[3][0][0];
                c[4][0][1] = c[3][0][1];
                c[4][0][2] = c[3][0][2];
                c[3][0][0]= c[5][0][2];
                c[3][0][1]= c[5][0][1];
                c[3][0][2]= c[5][0][0];
                c[5][0][0] = tmp1;
                c[5][0][1] = tmp2;
                c[5][0][2] = tmp3;
                break;
            case 1://확인
                tmp1 = c[2][2][0];
                tmp2 = c[2][2][1];
                tmp3 = c[2][2][2];
                c[2][2][0] = c[5][2][0];
                c[2][2][1] = c[5][2][1];
                c[2][2][2] = c[5][2][2];
                c[5][2][0] = c[3][2][2];
                c[5][2][1] = c[3][2][1];
                c[5][2][2] = c[3][2][0];
                c[3][2][0]= c[4][2][0];
                c[3][2][1]= c[4][2][1];
                c[3][2][2]= c[4][2][2];
                c[4][2][0] = tmp3;
                c[4][2][1] = tmp2;
                c[4][2][2] = tmp1;
                break;
            case 2://확인
                tmp1 = c[0][0][0];
                tmp2 = c[0][1][0];
                tmp3 = c[0][2][0];
                c[0][0][0] = c[5][0][0];
                c[0][1][0] = c[5][1][0];
                c[0][2][0] = c[5][2][0];
                c[5][0][0] = c[1][2][0];
                c[5][1][0] = c[1][1][0];
                c[5][2][0] = c[1][0][0];
                c[1][0][0]= c[4][0][0];
                c[1][1][0]= c[4][1][0];
                c[1][2][0]= c[4][2][0];
                c[4][0][0] = tmp3;
                c[4][1][0] = tmp2;
                c[4][2][0] = tmp1;
                break;
            case 3://확인
                tmp1 = c[0][0][2];
                tmp2 = c[0][1][2];
                tmp3 = c[0][2][2];
                c[0][0][2] = c[4][2][2];
                c[0][1][2] = c[4][1][2];
                c[0][2][2] = c[4][0][2];
                c[4][0][2] = c[1][0][2];
                c[4][1][2] = c[1][1][2];
                c[4][2][2] = c[1][2][2];
                c[1][0][2]= c[5][2][2];
                c[1][1][2]= c[5][1][2];
                c[1][2][2]= c[5][0][2];
                c[5][0][2] = tmp1;
                c[5][1][2] = tmp2;
                c[5][2][2] = tmp3;
                break;
            case 4://확인
                tmp1 = c[0][0][0];
                tmp2 = c[0][0][1];
                tmp3 = c[0][0][2];
                c[0][0][0] = c[2][2][0];
                c[0][0][1] = c[2][1][0];
                c[0][0][2] = c[2][0][0];
                c[2][0][0] = c[1][0][0];
                c[2][1][0] = c[1][0][1];
                c[2][2][0] = c[1][0][2];
                c[1][0][0]= c[3][2][0];
                c[1][0][1]= c[3][1][0];
                c[1][0][2]= c[3][0][0];
                c[3][0][0] = tmp1;
                c[3][1][0] = tmp2;
                c[3][2][0] = tmp3;
                break;
            case 5://확인
                tmp1 = c[0][2][0];
                tmp2 = c[0][2][1];
                tmp3 = c[0][2][2];
                c[0][2][0] = c[3][0][2];
                c[0][2][1] = c[3][1][2];
                c[0][2][2] = c[3][2][2];
                c[3][0][2] = c[1][2][2];
                c[3][1][2] = c[1][2][1];
                c[3][2][2] = c[1][2][0];
                c[1][2][0]= c[2][0][2];
                c[1][2][1]= c[2][1][2];
                c[1][2][2]= c[2][2][2];
                c[2][0][2] = tmp3;
                c[2][1][2] = tmp2;
                c[2][2][2] = tmp1;
                break;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            c = new char[6][3][3];
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    c[0][j][k] = 'w';
                    c[1][j][k] = 'y';
                    c[2][j][k] = 'r';
                    c[3][j][k] = 'o';
                    c[4][j][k] = 'g';
                    c[5][j][k] = 'b';
                }
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                String move = st.nextToken();
                char color = move.charAt(0);
                char dir = move.charAt(1);
                int idx = -1;
                switch (color) {
                    case 'U':
                        idx = 0;
                        break;
                    case 'D':
                        idx = 1;
                        break;
                    case 'F':
                        idx = 2;
                        break;
                    case 'B':
                        idx = 3;
                        break;
                    case 'L':
                        idx = 4;
                        break;
                    case 'R':
                        idx = 5;
                        break;
                }
                if (dir == '+') {
                    if(idx==1||idx==4||idx==3){
                        rm(idx);
                    }else {
                        rp(idx);
                    }
                    r_p(idx);
                } else {
                    if(idx==1||idx==4||idx==3){
                        rp(idx);
                    }else {
                        rm(idx);
                    }
                    r_m(idx);
                }
            }
            for(int j=2;j>=0;j--){
                for(int k=0;k<3;k++){
                    System.out.print(c[0][k][j]);
                }
                System.out.println();
            }
        }
    }
}
