package BOJ;
import java.util.*;
import java.io.*;
import annotation.*;
@BOJ(   number = 11758,
        tier = BaekjoonTier.GOLD_V,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 5))
public class BOJ11758 {

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static Coordinate [] coor;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        coor = new Coordinate[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            coor[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(ccw());
    }
    public static int ccw() { // 신발끈 공식을 이용
        int a = coor[0].x * coor[1].y + coor[1].x * coor[2].y + coor[2].x * coor[0].y;
        int b = coor[0].y * coor[1].x + coor[1].y * coor[2].x + coor[2].y * coor[0].x;
        // 반시계 방향
        if (a - b > 0) {
            return 1;
        } else if (a == b) { // 평행
            return 0;
        } else { // 시계 방향
            return -1;
        }
    }
}