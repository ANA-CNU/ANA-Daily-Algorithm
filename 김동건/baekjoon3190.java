/*
 *N*N칸, 사과가 있는 칸도 있음. 보드 상하좌우 끝에 벽이 있다.
 시작은 맨위 맨좌측. 뱀의 길이는 1 오른쪽 향함.
 
 처음은 머리 다음칸으로 움직임.
 벽이나 몸과 부딪히면 게임오버.
 사과가있으면 사과가 없어지고 꼬리가 움직이지 않음
 사과 없으면 꼬리가 위치한 칸은 비워줌.

 위작업이 끝나고나서 만약 현재가 X타임이면 X타임에 해당하는 문자에 따라 
 왼쪽 혹은 오른쪽으로 90도 회전.
*/
import java.util.*;

class Point{
  int x;
  int y;
  boolean next;

  public Point(int x, int y, boolean next){
    this.x = x;
    this.y = y;
    this.next = next;
  }
}

public class baekjoon3190{

  public static int[][] matrix = new int[100][100];

  public static boolean[][] appleMatrix= new boolean[100][100];
  public static Queue<Integer> timeToTurn = new LinkedList<>();
  public static Queue<Character> directionToTurn = new LinkedList<>();
  public static Queue<Point> body = new LinkedList<>();
  public static int N;  
  public static int K; 
  public static int L;
  public static int time = 0;

  public static int[] dx = {0,1,0,-1};
  public static int[] dy = {1,0,-1,0};
  public static int nowD = 0;
  
  public static boolean thereIsApple(int x, int y){
    if(appleMatrix[x][y]== true){
      return true;
    }
    return false;
  }
  public static Point move(int x, int y){
    time++;
    //다음칸 움직임
    int newX = x+dx[nowD];
    int newY = y+dy[nowD];

    //몸이나 벽에 부딫히면 게임오버. 
    if(newX<0||newY<0||newX>=N||newY>=N||matrix[newX][newY]!= 0)
    return new Point(-1,-1,false);
    
    //다음칸에 사과가있다면 머리만, 없으면 꼬리도 움직임
    if(thereIsApple(newX,newY)){
      appleMatrix[newX][newY] = false;
      matrix[newX][newY] = 1;
      body.add(new Point(newX,newY,true));
    }
    else{
      matrix[newX][newY] = 1;
      body.add(new Point(newX,newY,true));
      Point temp = body.poll();
      matrix[temp.x][temp.y] = 0;
    }
    
    if(!timeToTurn.isEmpty()&&time ==timeToTurn.peek()){
      timeToTurn.poll();
      char temp = directionToTurn.poll();

      if(temp == 'L')
      nowD = (nowD+3)%4;
      else
      nowD = (nowD+1)%4;
    }

    return new Point(newX, newY, true);

    //돌 필요가 있다면 회전.
  }

 
  public static void main(String args[]){
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    K = scan.nextInt();

    for(int i = 0; i<K; i++){
      appleMatrix[scan.nextInt()-1][scan.nextInt()-1] = true;
    }
    
    L = scan.nextInt();

    for(int i = 0; i<L;i++){
      timeToTurn.add(scan.nextInt());
      directionToTurn.add(scan.next().charAt(0));
    }
    matrix[0][0] = 1;
    body.add(new Point(0,0,true));
    Point temp = move(0,0);
    while(true){
      if(temp.next == true){
        temp = move(temp.x,temp.y);
      }
      else{
        break;
      }
    }

    System.out.println(time);


  }
}