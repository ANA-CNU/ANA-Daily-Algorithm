import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
  long x, y;
  
  Point(long x, long y) {
    this.x = x;
    this.y = y;
  }
}

public class Main {
  public static int N;
  public static ArrayList<Point> arr = new ArrayList<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    
    int Q = Integer.parseInt(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while(Q-->0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
  
      Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
          , b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      
      bw.write(solve(a, b)+"\n");
    }
    bw.flush();
  }
  
  public static int solve(Point a, Point b) {
    boolean aIn = isIn(a), bIn = isIn(b);
    
    
    if (aIn && bIn) {
      int res = 0;
      int[] aBin = function(a), bBin = function(b);
      
      for (int i=0;i<N;i++)
        res += Math.abs(aBin[i] - bBin[i]);
      
      return Math.min(optimizedOut(a, aBin) + optimizedOut(b, bBin),  res >> 1);
    } else if (aIn == bIn) {
      return 0;
    } else {
      if (aIn) {
        int[] aBin = function(a);
        return optimizedOut(a, aBin);
      }
      else {
        int[] bBin = function(b);
        return optimizedOut(b, bBin);
      }
    }
  }
  
  public static int optimizedOut (Point a, int[] bin) {
    int[] k = new int[N];
    int[] s = new int[N];
    
    int min = Integer.MAX_VALUE;
    
    for (int i=0;i<bin.length;i++) {
      int left = i;
      int right = ((bin[i]-1) % N);
      
      int value = bin[i] - i;
      
      k[left]+=value;
      s[left]++;
      
      if (left <= right) {
        if (right + 1 < N)
          s[right+1]--;
      } else {
        k[0] += value - (N-left);
        s[0]++;
        s[value - (N - left)]--;
      
      }
    }
    
    int adding = 0, stack = 0;
    for (int i=0;i<N;i++) {
      adding += k[i];
      stack += s[i];
      
      min = Math.min(min, adding);
      adding -= stack;
    }
    
    
    return min;
  }
  
  public static int[] function (Point a) {
    int[] res = new int[N];
    
    for (int i=0, k = 1;i<N;i++) {
      while(true) {
        int s = CCW(arr.get(i), arr.get(k % N), a);
        if (s > 0) break;
  
        k++;
      }
      
      res[i] = k-1;
    }
    
    return res;
  }
  
  public static boolean isIn(Point a) {
    for (int i = 0; i + 1 < arr.size(); i++) {
      if (CCW(arr.get(i), arr.get(i+1), a) != -1) return false;
    }
    
    if (CCW(arr.get(N-1), arr.get(0), a) != -1) return false;
    return true;
  }
  
  public static int CCW(Point a, Point b, Point c) {
    long x = (c.x - a.x) * (b.y - a.y) - (b.x - a.x) * (c.y - a.y);
    return Long.compare(x, 0);
  }
}
