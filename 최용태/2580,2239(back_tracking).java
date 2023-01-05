import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX_BLOCK = 9;
    static ArrayList<Loc> emptySpace = new ArrayList<>();
    static int[][] src = new int[MAX_BLOCK + 1][MAX_BLOCK + 1];
    static int fulfilled;
    static boolean found=false;


    public static void init() throws IOException {
        for (int x = 1; x < MAX_BLOCK + 1; x++) {
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            for (int i = 1; i < MAX_BLOCK + 1; i++) {
                src[x][i] = Integer.parseInt(s.nextToken());
                if (src[x][i] == 0) emptySpace.add(new Loc(x, i));
            }
        }
    }

    public static int getStartingPoint(int givenValue){
        return switch (givenValue) {
            case 1, 2, 3 -> 1;
            case 4, 5, 6 -> 4;
            case 7, 8, 9 -> 7;
            default -> -1;
        };
    }

    public static boolean checkType1(Loc givenLoc,int value){
        for (int i = 1; i <= MAX_BLOCK; i++) {
            if (src[givenLoc.i][i] == value) return false;
        }
        return true;
    }

    public static boolean checkType2(Loc givenLoc,int value){
        for (int i = 1; i <= MAX_BLOCK; i++) {
            if (src[i][givenLoc.j] == value) return false;
        }
        return true;
    }

    public static boolean checkType3(Loc givenLoc,int value){
        Loc startLoc=new Loc(getStartingPoint(givenLoc.i),getStartingPoint(givenLoc.j));

        for(int i=startLoc.i;i<startLoc.i+3;i++){
            for(int j=startLoc.j;j<startLoc.j+3;j++) {
                if (src[i][j] == value) return false;
            }
        }

        return true;
    }

    public static boolean isAble(Loc givenLoc, int value) {
        return checkType1(givenLoc,value)
                && checkType2(givenLoc,value)
                && checkType3(givenLoc,value);
    }

    public static void search(int n) {
        if(!found) {
            if (n == fulfilled) {
                for (int i = 1; i < src.length; i++) {
                    Arrays.stream(src[i]).filter(o -> o != 0).forEach(o->System.out.print(o+" "));
                    System.out.println();
                }
                found=true;
                return;
            }

            Loc currentLoc = emptySpace.get(n);

            out:
            for (int v = 1; v <= MAX_BLOCK; v++) {
                if (isAble(currentLoc, v)) {
                    src[currentLoc.i][currentLoc.j] = v;
                    search(n + 1);
                    src[currentLoc.i][currentLoc.j] = 0;
                }
                if (found) break out;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        fulfilled = emptySpace.size();
        search(0);
    }
}

class Loc {
    int i;
    int j;

    Loc(int ii, int jj) {
        i = ii;
        j = jj;
    }
}