import java.util.Scanner;

public class Main {
    static char[] width = {'A','B','C','D','E','F'};
    static boolean[][] field = new boolean[6][6];
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        int[] first = null, last = null;
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            int w = getInt(s.charAt(0));
            int h = s.charAt(1) - '0' - 1;
            if(last != null) {
                if(!isMovable(w,h,last[0],last[1])) {
                    System.out.println("Invalid");
                    return;
                }
            }
            if(field[w][h]) {
                System.out.println("Invalid");
                return;
            }
            field[w][h] = true;
            if(first == null) {
                first = new int[]{w,h};
            }
            last = new int[]{w,h};
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(!field[i][j]) {
                    System.out.println("Invalid");
                    return;
                }
            }
        }

        // 둘 사이가 나이트가 갈 수 있는 위치인가?
        assert first != null;

        if(isMovable(first[0],first[1],last[0],last[1]))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }

    static boolean isMovable(int w1, int h1, int w2, int h2) {
        int wdiff = Math.abs(w1-w2);
        int hdiff = Math.abs(h1-h2);
        if(wdiff == 2) {
            if(hdiff == 1) {
                return true;
            }
        }
        if(wdiff == 1) {
            if(hdiff == 2) {
                return true;
            }
        }
        return false;
    }

    static int getInt(char c) {
        for (int i = 0; i < 6; i++) {
            if(c == width[i])
                return i;
        }
        return -1;
    }
}