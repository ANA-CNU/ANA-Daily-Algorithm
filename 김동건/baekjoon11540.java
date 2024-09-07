/*
 * N개의 문제, 순서대로 풀어야. 못푸는 문제 있음 스킵가능  
 * 둘중하나만 풀수 잇는 문제가 있다. 
 * 가장 적게 교대하면 모든문제를 풀고 싶다.
 * N은 1억까지, 따라서 못써먹는다.
 */

 import java.util.*;
 import java.io.*;

 public class baekjoon11540{
  public static Deque<Integer> rforA= new LinkedList<>() ;
  public static Deque<Integer> rforB= new LinkedList<>();
  public static int A; 
  public static int B;
  public static int N;

  public static int solveTry(boolean who){
    int count= 0;
    Deque<Integer> forA = new LinkedList<>(rforA);
    Deque<Integer> forB = new LinkedList<>(rforB);
    
    while(!forA.isEmpty()&&!forB.isEmpty()){

      int alice = forA.peek();
      int bob = forB.peek();

      if(alice == bob){
        forA.pop();
        forB.pop();
      }
      else if(alice > bob){
        if(who == false){
        who = true;
        count++;
      }
      forB.pop();
      }
      else{
        if(who == true){
          who = false;
          count++;
        }
        forA.pop();
      }
    }

    if(who == true&& !forA.isEmpty())
    count++;
    
    if(who == false && !forB.isEmpty())
    count++;

    return count;


  }
 

  public static void baekjoon11540(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String s1 = br.readLine();
    String s2 = br.readLine();
    String s3 = br.readLine();

    String s11[] = s1.split(" ");

    N = Integer.parseInt(s11[0]);
    A = Integer.parseInt(s11[1]);
    B = Integer.parseInt(s11[2]);

    String s22[] = s2.split(" ");
    int s222[] = new int[s22.length];
    for(int i = 0; i<s22.length; i++){
      s222[i] = Integer.parseInt(s22[i]);
    }

    String s33[] = s3.split(" ");
    int s333[] = new int[s33.length];
    for(int i = 0; i<s33.length; i++){
      s333[i] = Integer.parseInt(s33[i]);
    }

    Arrays.sort(s222);
    Arrays.sort(s333);

    for(int i = s222.length-1; i>=0; i--){
      rforA.push(s222[i]);
    }
    for(int i = s333.length-1; i>=0; i--){
      rforB.push(s333[i]);
    }




    int min = solveTry(true);
    min = Math.min(min,solveTry(false) );
    //마지막에 자리를 바꾸고 변경하는 경우만 생각해서 큐가 안비었으면 
    //다플러스 하게 했다. 근데 만약 마지막에 둘다 풀수있는 문제였다면
    //기존 풀던 사람의 자리만 남아도 그대로 하면 되는 것.

    System.out.println(min);
  }
 }