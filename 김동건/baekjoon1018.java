/*M과N크기 보드,  8*8 p체스판을 칠해야함.  
보드를 잘라 8*8로. 검흰 번갈아서 있어야.
옆자리는 다른 색이어야.
다시칠 필요 가장 적은 8*8을 구해야. 
기준점을 최 좌측 > 0부터 n-7, m-7 지점까지 전체 돌아야.
각 기준점마다 8*8 검사.
*/

import java.io.*;
import java.util.*;
public class Main{
  public static int N;
  public static int M;
  public static int min = 64;

  public static int toInt(char c){
    if(c == 'W')
    return 1;
    return 0;
  }

  public static int inTest(int x, int y, int num){
    int count = 0;
    for(int i = x; i< x+8; i++){
      for(int j = y; j<y+8; j++){
        if((i+j)%2== 1){
          if(arr[i][j]!= num)
          count++;
        }
        else{
          if(arr[i][j]== num)
          count++;
        }
      }
    }
    return count;
  }

  public static int test(int x, int y){
    int minCount = 64;
    minCount = Math.min(minCount, inTest(x,y,1));
    minCount = Math.min(minCount, inTest(x,y,0));
    
    return minCount;
  } 

  public static int[][] arr = new int[50][50];
  public static void main(String args[]){
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    M = scan.nextInt();

    for(int i = 0; i<N; i++){
      String s = scan.next();
      for(int j = 0; j<M; j++){
        arr[i][j] = toInt(s.charAt(j));
      }
    }
  
    for(int i = 0; i<N-7; i++){
      for(int j= 0; j<M-7; j++){
        min = Math.min(min,test(i, j));
      }
    }

    System.out.print(min);
    
  }
}