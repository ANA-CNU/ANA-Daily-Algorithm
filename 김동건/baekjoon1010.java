//풀이: https://eatrawlife.github.io/posts/2024/09/baekjoon1010/

 import java.util.*;
 public class baekjoon1010{

  public static int comp(Scanner scan){
    N = scan.nextInt();
    M = scan.nextInt();

    return arr[M][N];

  }

  public static int[][] arr = new int[31][31];
  public static int N;
  public static int M;
  public static int k;
  public static void main(String args[]){
    Scanner scan = new Scanner(System.in);

    k = scan.nextInt();

    for(int i = 0; i<=30; i++){
      arr[i][i] = 1;
      arr[i][0] = 1;
    }

    for(int i = 1; i<30; i++){
      for(int j =1 ; j<i; j++){
        arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
      }

      
    }

    for(int i = 0; i<k; i++){
      System.out.println(comp(scan));
    }


  }
 }