//풀이: https://eatrawlife.github.io/posts/2024/09/baekjoon14501/
import java.util.*;
import java.io.*;

public class baekjoon14501{

  public static int[] Time = new int[16];
  public static int[] Pay = new int[16];
  public static int[] PayCount = new int[16];
  public static int N;

  public static void doo(int index){
    if(index >N)
    return;

    int duration = Time[index];


    if(index+duration-1<=N){
      PayCount[index+ duration-1] = Math.max(PayCount[index+ duration-1], PayCount[index-1]+Pay[index]);
      }

    if(index+1<=N){
      PayCount[index+1] = Math.max(PayCount[index+1], PayCount[index]);
      }
      doo(index+1);

  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    for(int i = 1; i<=N; i++){
      Time[i] = scan.nextInt();
      Pay[i] = scan.nextInt();
    }

    doo(1);
    
    int max = 0;
    for(int i = 1; i<=N; i++){
      max = Math.max(max, PayCount[i]);
    }
    System.out.println(max);
      
  }
}