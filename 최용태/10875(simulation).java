import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int L;

    public static int convert(String s) {
        switch (s.charAt(0)) {
            case 'L':
                return 0;
            case 'R':
                return 1;
        }
        return -1;
    }

    public static long run() throws IOException {
        Queue<Loc> q = new LinkedList<>();
        Queue<Integer> dirQ = new LinkedList<>();
        Queue<Integer> moveQ = new LinkedList<>();
        ArrayList<LocPair> bodyList = new ArrayList<>();

        bodyList.add(new LocPair(new Loc(-L,L),new Loc(-L,-L)));
        bodyList.add(new LocPair(new Loc(-L,-L),new Loc(L,-L)));
        bodyList.add(new LocPair(new Loc(L,-L),new Loc(L,L)));
        bodyList.add(new LocPair(new Loc(L,L),new Loc(-L,L)));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(ss.nextToken());
            int dir = convert(ss.nextToken());
            moveQ.offer(n);
            dirQ.offer(dir);
        }

        q.offer(new Loc(0, 0));

        boolean isVertical = false;
        long ans = 0;
        int[] d = {-1, 1}; // 상, 하, 좌, 우

        Loc nextLoc = new Loc(0, 0);
        int currentDirection = 1; // prev의 처음은 우로 꺾은 상태이다.

        while (!moveQ.isEmpty() && !q.isEmpty()) {
            Loc cLoc = q.poll();
            int nextMove = moveQ.poll(); // 이동할 거리
            int nextDirection=dirQ.poll();
            int l = cLoc.getLocation(isVertical) + (d[currentDirection] * nextMove); // 현재 바라보고 있는 방향으로 직진한다.
            nextLoc = cLoc.createLocation(isVertical, l); // 이동하고 난 뒤의 위치는 nextLoc 이다.

            int status = isBody(bodyList, cLoc, nextLoc, currentDirection, isVertical); // status 는 nextLoc 의 위치를 기준으로 충돌 여부를 판단한다.

            currentDirection = getNextDirection(isVertical, currentDirection,nextDirection); // 현재 수직,수평 정보와 현재 방향, 다음의 방향을 기반으로 해서 다음의 방향이 결정된다.
            if (status != -1) {
                ans += status;
                return ans;
            }

            isVertical = !isVertical; // 이동을 완료 했으므로 다음의 수평 수직을 뒤바꾼다.

            q.offer(nextLoc);
            bodyList.add(new LocPair(cLoc, nextLoc));
            ans += nextMove;
        }
        int maxRange = d[currentDirection] * (2+1)*L;
        int status = isBody(bodyList, nextLoc,
                nextLoc.createLocation(isVertical, maxRange), currentDirection, isVertical);


        if (status != -1) {
            ans += status;
        }

        return ans;
    }


    public static int getNextDirection(boolean vertical, int currentDir, int nextDir) {
        if (!vertical && currentDir == 0 || vertical && currentDir == 1) {
            return Math.abs(nextDir - 1);
        } else
            return nextDir;
    }


    public static boolean inArea(int a, int b, int cmp) {
        return (Math.min(a, b) <= cmp && Math.max(a, b) >= cmp);
    }

    public static int isBody(ArrayList<LocPair> bodyList, Loc originalLoc, Loc nextLoc, int currentDirection, boolean isVertical) {
        int result = Integer.MAX_VALUE;
        for (LocPair locPair : bodyList) {
            Loc currentL1 = locPair.L1;
            Loc currentL2 = locPair.L2;

            if (currentL2.equals(originalLoc)) continue;

            if (currentL1.i == currentL2.i) { // 같은 i일때, 수평의 직선일 때
                 // 범위 안에 들어오는 가?
                    if (isVertical){ // 수직일 경우
                        if (inArea(currentL1.j, currentL2.j, nextLoc.j)) {
                            if (currentDirection == 0 && currentL1.i <= originalLoc.i && currentL1.i >= nextLoc.i
                                    || currentDirection == 1 && currentL1.i >= originalLoc.i && currentL1.i <= nextLoc.i) {
                                result = Math.min(result, Math.abs(currentL1.i - originalLoc.i));
                            }
                        }
                    }else{ // 수평일 경우
                        if(currentL1.i==nextLoc.i) {
                            int min_j = Math.min(currentL1.j, currentL2.j);
                            int max_j = Math.max(currentL1.j, currentL2.j);
                            if (currentDirection == 0 && max_j <= originalLoc.j && max_j >= nextLoc.j) {
                                result = Math.min(result, Math.abs(max_j - originalLoc.j));
                            } else if (currentDirection == 1 && min_j >= originalLoc.j && min_j <= nextLoc.j) {
                                result = Math.min(result, Math.abs(min_j - originalLoc.j));
                            }
                        }
                }
            } else { // 같은 j일때, 수직의 직선일 때
                    if (isVertical){ // 수직일 경우
                        if(currentL1.j==nextLoc.j) {
                            int min_i = Math.min(currentL1.i, currentL2.i);
                            int max_i = Math.max(currentL1.i, currentL2.i);
                            if (currentDirection == 0 && max_i >= originalLoc.i && max_i <= nextLoc.i) {
                                result = Math.min(result, Math.abs(max_i - originalLoc.i));
                            } else if (currentDirection == 1 && min_i <= originalLoc.i && min_i >= nextLoc.i) {
                                result = Math.min(result, Math.abs(min_i - originalLoc.i));
                            }
                        }
                    }else{ // 수평일 경우
                        if (inArea(currentL1.i, currentL2.i, nextLoc.i)) {
                            if (currentDirection == 0 && currentL1.j <= originalLoc.j && currentL1.j >= nextLoc.j
                                    || currentDirection == 1 && currentL1.j >= originalLoc.j && currentL1.j <= nextLoc.j) {
                                result = Math.min(result, Math.abs(currentL1.j - originalLoc.j));
                            }
                        }
                    }
                }
        }
        if (result == Integer.MAX_VALUE) result = -1;
        return result;
    }


    public static void main(String[] args) throws IOException {
        L = Integer.parseInt(br.readLine())+1; // 판 길이
        long ans = run();
        System.out.println(ans);
    }
}

class LocPair {
    Loc L1;
    Loc L2;

    LocPair(Loc xx, Loc yy) {
        L1 = xx;
        L2 = yy;
    }
}

class Loc {
    int i;
    int j;

    Loc(int ii, int jj) {
        i = ii;
        j = jj;
    }

    int getLocation(boolean isVertical) {
        if (isVertical)
            return this.i;
        else
            return this.j;
    }

    Loc createLocation(boolean isVertical, int move) {
        if (isVertical) {
            return new Loc(move, this.j);
        } else {
            return new Loc(this.i, move);
        }
    }
    public boolean equals(Loc o) {
        return o.i == this.i && o.j == this.j;
    }
}