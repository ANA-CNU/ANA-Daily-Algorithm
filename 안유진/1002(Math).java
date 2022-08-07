import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void solve(int x1, int y1, int r1, int x2, int y2, int r2){
        int dis = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if(x1 == x2 && y1 == y2 && r1 == r2){ //접점무한개
            sb.append(-1).append('\n');
        }else if(dis > Math.pow(r1 + r2 , 2)){ //두점사이거리 > 반지름 합 (접점없음)
            sb.append(0).append('\n');
        }else if(r1 != r2 && Math.pow(r1-r2, 2) > dis){ //원안에 원인데 서로안부닥침
            sb.append(0).append('\n');
        }else if(Math.pow(r1 - r2, 2) == dis || Math.pow(r1 + r2, 2) == dis){ //한개
            sb.append(1).append('\n');
        }else{
            sb.append(2).append('\n'); //아니면 두개 (원이포개지는거니까)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            solve(x1, y1, r1, x2, y2, r2);
        }
        System.out.println(sb);
    }
}
