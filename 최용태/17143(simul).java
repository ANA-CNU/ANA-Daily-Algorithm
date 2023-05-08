import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static Pool p;
    static ArrayList<Shark> sharkList = new ArrayList<>();

    static StringTokenizer getToken(String s) {
        return new StringTokenizer(s, " ");
    }

    static int getNext(StringTokenizer s) {
        return Integer.parseInt(s.nextToken());
    }

    static Loc move(Shark shark) {
        int cLoc = shark.getCurrentLineLoc();
        int R = (shark.is_vertical() ? N : M)-1;
        int ableMoving = shark.speed;

        if (!shark.is_regularDir()) {
            if(shark.is_vertical()) {
                ableMoving -= (R - cLoc);
                cLoc = ableMoving > 0 ? R : cLoc + shark.speed;
            }
            else {
                ableMoving-=cLoc;
                cLoc = ableMoving > 0 ? 0 : cLoc - shark.speed;
            }
        } else {
            if(shark.is_vertical()) {
                ableMoving-=cLoc;
                cLoc = ableMoving > 0 ? 0 : cLoc - shark.speed;
            }
            else {
                ableMoving -= (R - cLoc);
                cLoc = ableMoving > 0 ? R : cLoc + shark.speed;
            }
        }

        while (ableMoving > 0) {
            shark.switchDir();
            int move=Math.min(ableMoving, R);
            ableMoving -= move;
            if(shark.is_vertical())
                cLoc += shark.is_regularDir() ? -move : move;
            else
                cLoc += shark.is_regularDir() ? move : -move;
        }

        shark.setCurrentLineLoc(cLoc);
        return shark.loc;
    }

    static void refresh() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int key = i * M + j;
                Queue<Shark> queue = p.getSharkQueue(key);

                if (queue.size() == 0) {
                    p.pool[i][j] = null;
                } else {
                    Shark winner = queue.poll();

                    while (!queue.isEmpty()) {
                        Shark cmp = queue.poll();
                        if (winner.size < cmp.size) {
                            winner.is_exist = false;
                            winner = cmp;
                        }else
                            cmp.is_exist=false;
                    }

                    queue.offer(winner);
                    p.pool[winner.loc.i][winner.loc.j] = winner;
                }
            }
        }
    }

    static void sharksMove() {
        for (Shark shark : sharkList) {
            if (shark.is_exist) {
                int key = p.getMapperKey(shark.loc);
                p.getSharkQueue(key).remove(shark); // 이전 상어 큐에서 삭제
                p.getSharkQueue(p.getMapperKey(move(shark))).offer(shark);
            }
        }
    }

    static int fishing(int line) {
        Shark target;
        for (int i = 0; i < N; i++) {
            if (p.pool[i][line] != null) {
                target = p.pool[i][line];
                p.getSharkQueue(p.getMapperKey(target.loc)).poll();
                target.is_exist = false;
                p.pool[i][line] = null;
                return target.size;
            }
        }
        return 0;
    }

    static int play() {
        int result = 0;

        for (int i = 0; i < M; i++) {
            result += fishing(i);
            sharksMove();
            refresh();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = getToken(br.readLine());

        N = getNext(s1);
        M = getNext(s1);

        int S = getNext(s1);

        p = new Pool(N, M);

        for (int t = 0; t < S; t++) {
            StringTokenizer s2 = getToken(br.readLine());

            int i = getNext(s2) - 1;
            int j = getNext(s2) - 1;
            int speed = getNext(s2);
            int dir = getNext(s2);
            int size = getNext(s2);

            Shark shark = new Shark(i, j, speed, dir, size);
            sharkList.add(shark);

            p.pool[i][j] = shark;
            p.getSharkQueue(p.getMapperKey(shark.loc)).offer(shark);
        }

        System.out.println(play());
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

class Pool {
    Shark[][] pool;
    int[][] queueMapper;
    HashMap<Integer, Queue<Shark>> sharkQueue = new HashMap<>();

    Pool(int N, int M) {
        pool = new Shark[N][M];
        queueMapper = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                queueMapper[i][j] = i * M + j;
                sharkQueue.put(queueMapper[i][j], new LinkedList<>());
            }
        }
    }

    Queue<Shark> getSharkQueue(int key) {
        return sharkQueue.get(key);
    }

    int getMapperKey(Loc loc) {
        return queueMapper[loc.i][loc.j];
    }

}

class Shark {

    Loc loc;
    int speed;
    int dir;
    int size;

    boolean is_exist = true;

    Shark(int i, int j, int v, int d, int s) {
        loc = new Loc(i, j);
        size = s;
        speed = v;
        dir = d;
    }

    int getCurrentLineLoc() {
        return is_vertical() ? loc.i : loc.j;
    }

    void setCurrentLineLoc(int l) {
        if (is_vertical())
            loc.i = l;
        else
            loc.j = l;
    }

    void switchDir() {
        dir += is_regularDir() ? 1 : -1;
    }

    boolean is_regularDir() { // 우, 상이 정규 방향
        return is_vertical() ? dir == 1 : dir == 3;
    }

    boolean is_vertical() {
        return dir <= 2;
    }

    @Override
    public String toString(){
        return String.format("LOC: (%d,%d), speed: %d, size: %d",loc.i,loc.j,speed,size);
    }

}