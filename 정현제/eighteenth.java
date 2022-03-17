package grap_my_hand;

import java.io.*;
import java.util.*;

public class eighteenth {
  //함수에서 사용할 변수들
  static int[][] check; //간선 연결상태
  static boolean[] checked; //확인 여부
  static int n; //정점개수
  static int m; //간선개수
  static int start; //시작정점
  
  public static void main(String[] args) throws IOException {
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  m = sc.nextInt();
  start = sc.nextInt();
  
  check = new int[1001][1001]; //좌표를 그대로 받아들이기 위해 +1해서 선언
  checked = new boolean[1001]; //초기값 False
  
  //간선 연결상태 저장
  for(int i = 0; i < m; i++) {
    int x = sc.nextInt();
    int y = sc.nextInt();
    
    check[x][y] = check[y][x] = 1;
  }
  
  dfs(start); //dfs호출
  
  checked = new boolean[1001]; //확인상태 초기화
  System.out.println(); //줄바꿈
  
  bfs(); //bfs호출
  }
  
  //시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
  public static void dfs(int i) {
    checked[i] = true;
    System.out.print(i + " ");
    
    for(int j = 1; j <= n; j++) {
      if(check[i][j] == 1 && checked[j] == false) {
        dfs(j);
      }
    }
  }
  
  public static void bfs() {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(start); //시작점도 Queue에 넣어야 함
    checked[start] = true;
    System.out.print(start + " ");
    
    //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
    while(!queue.isEmpty()) {
      int temp = queue.poll();
      
      for(int j = 1; j <= n; j++) {
        if(check[temp][j] == 1 && checked[j] == false) {
          queue.offer(j);
          checked[j] = true;
          System.out.print(j + " ");
        }
      }
    }
  }
}