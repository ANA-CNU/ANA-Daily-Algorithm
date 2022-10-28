import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[][] map;
  static int maxBlock = 0;

  static void moveBlock(int dir) {
    //0: move top, 1: move right, 2: move bottom, 3: move left
    ArrayList<Integer> list = new ArrayList<>();

    if(dir == 0) {
      for(int j = 0; j < n; j++) {
        //store
        list.clear();
        for(int i = 0; i < n; i++) {
          if(map[i][j] != 0) list.add(map[i][j]);
          map[i][j] = 0;
        }

        //move
        for(int i = 0; i < list.size(); i++) {
          map[i][j] = list.get(i);
        }

        //merge
        for(int i = 0; i < n-1; i++) {
          if(map[i][j] == 0) continue;
          if(map[i][j] != map[i+1][j]) continue;
          map[i][j] *= 2;
          map[i+1][j] = 0;
        }

        //store
        list.clear();
        for(int i = 0; i < n; i++) {
          if(map[i][j] != 0) list.add(map[i][j]);
          map[i][j] = 0;
        }

        //move
        for(int i = 0; i < list.size(); i++) {
          map[i][j] = list.get(i);
        }
      }
    }
    else if(dir == 2) {
      for(int j = 0; j < n; j++) {
        //store
        list.clear();
        for(int i = n-1; i >= 0; i--) {
          if(map[i][j] != 0) list.add(map[i][j]);
          map[i][j] = 0;
        }

        //move
        for(int i = 0; i < list.size(); i++) {
          map[n-1-i][j] = list.get(i);
        }

        //merge
        for(int i = n-1; i > 0; i--) {
          if(map[i][j] == 0) continue;
          if(map[i][j] != map[i-1][j]) continue;
          map[i][j] *= 2;
          map[i-1][j] = 0;
        }

        //store
        list.clear();
        for(int i = n-1; i >= 0; i--) {
          if(map[i][j] != 0) list.add(map[i][j]);
          map[i][j] = 0;
        }

        //move
        for(int i = 0; i < list.size(); i++) {
          map[n-1-i][j] = list.get(i);
        }
      }
    }
    else if(dir == 3) {
      for(int i = 0; i < n; i++) {
        //store
        list.clear();
        for(int j = 0; j < n; j++) {
          if(map[i][j] != 0) list.add(map[i][j]);
          map[i][j] = 0;
        }

        //move
        for(int j = 0; j < list.size(); j++) {
          map[i][j] = list.get(j);
        }

        //merge
        for(int j = 0; j < n-1; j++) {
          if(map[i][j] == 0) continue;
          if(map[i][j] != map[i][j+1]) continue;
          map[i][j] *= 2;
          map[i][j+1] = 0;
        }

        //store
        list.clear();
        for(int j = 0; j < n; j++) {
          if(map[i][j] != 0) list.add(map[i][j]);
          map[i][j] = 0;
        }

        //move
        for(int j = 0; j < list.size(); j++) {
          map[i][j] = list.get(j);
        }
      }
    }
    else if(dir == 1) {
      for(int i = 0; i < n; i++) {
        //store
        list.clear();
        for(int j = n-1; j >= 0; j--) {
          if(map[i][j] != 0) list.add(map[i][j]);
          map[i][j] = 0;
        }

        //move
        for(int j = 0; j < list.size(); j++) {
          map[i][n-1-j] = list.get(j);
        }

        //merge
        for(int j = n-1; j > 0; j--) {
          if(map[i][j] == 0) continue;
          if(map[i][j] != map[i][j-1]) continue;
          map[i][j] *= 2;
          map[i][j-1] = 0;
        }

        //store
        list.clear();
        for(int j = n-1; j >= 0; j--) {
          if(map[i][j] != 0) list.add(map[i][j]);
          map[i][j] = 0;
        }

        //move
        for(int j = 0; j < list.size(); j++) {
          map[i][n-1-j] = list.get(j);
        }
      }
    }
  }

  static void go(int cnt) {
    if(cnt == 5) {
      int max = 0;
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          max = Math.max(max, map[i][j]);
        }
      }
      maxBlock = Math.max(maxBlock, max);
      return;
    }

    int[][] copy = new int[n][n];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        copy[i][j] = map[i][j];
      }
    }

    for(int dir = 0; dir < 4; dir++) {
      moveBlock(dir);
      go(cnt+1);
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          map[i][j] = copy[i][j];
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    go(0);
    System.out.println(maxBlock);
  }
}

/*
5
2 2 4 8 16
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
2 2 4 8 16
 */
