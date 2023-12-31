import java.io.*;
import java.util.*;
public class Boj1976 {
  public static int [] arr;
    public static int find(int x){
        if(arr[x] == x){
        return x;
        }
        return arr[x] = find(arr[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
        arr[y] = x;
        }
    }
  public static void main(String []args)throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    arr = new int[N+1];
    for(int i=1;i<=N;i++){
      arr[i] = i;
    }
    int [][] map = new int[N+1][N+1];
    for(int i=1;i<=N;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1;j<=N;j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int [] plan = new int[M+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1;i<=M;i++){
      plan[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=1;i<=N;i++){
      for(int j=1;j<=N;j++){
        if(map[i][j] == 1){
          union(i,j);
        }
      }
    }
    int index =find(plan[1]);
    for(int i=2;i<=M;i++){
      if(index != find(plan[i])){
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
