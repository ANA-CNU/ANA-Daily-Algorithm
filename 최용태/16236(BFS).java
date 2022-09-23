import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int ans=0;
    static Fish[][] sea;
    static Shark babyShark;

    public static class Loc {
        int i;
        int j;
        int depth;

        Loc(int ii, int jj, int dd) {
            i = ii;
            j = jj;
            depth = dd;
        }
    }

    public static class Fish {
        int size;
        int distance = -1;
        Loc fishLoc;

        Fish(int newI, int newJ, int newSize) {
            fishLoc = new Loc(newI, newJ, 0);
            this.size = newSize;
        }
    }

    public static class Shark {
        int stacked;
        int size;
        Loc sharkLoc;

        Shark(int newI, int newJ) {
            this.sharkLoc = new Loc(newI, newJ, 0);
            this.size = 2;
            this.stacked = 0;
        }

        boolean overStacked() {
            return (this.stacked == this.size);
        }

        void moveNext(int nextI, int nextJ) {
            this.sharkLoc.i=nextI;
            this.sharkLoc.j=nextJ;
            this.sizeUp();
        }

        void sizeUp() {
            this.stacked++;
            if (overStacked())  {
                this.size++;
                this.stacked = 0;
            }
        }
    }
    static void BFS(Fish targetFish) {
        Queue<Loc> q = new LinkedList<>();
        boolean visisted[][]=new boolean[N][N];
        targetFish.fishLoc.depth=0;
        q.offer(targetFish.fishLoc);
        while (!q.isEmpty()) {
            Loc cLoc = q.poll();

            if (cLoc.i == babyShark.sharkLoc.i && cLoc.j == babyShark.sharkLoc.j) {
                targetFish.distance = cLoc.depth;
                return;
            }
            if (cLoc.i + 1 < N && !visisted[cLoc.i+1][cLoc.j]&& sea[cLoc.i + 1][cLoc.j].size <= babyShark.size) {
                visisted[cLoc.i+1][cLoc.j]=true;
                sea[cLoc.i + 1][cLoc.j].fishLoc.depth= cLoc.depth+1;
                q.offer(sea[cLoc.i + 1][cLoc.j].fishLoc);
            }
            if (cLoc.i - 1 >= 0 &&  !visisted[cLoc.i-1][cLoc.j] &&sea[cLoc.i - 1][cLoc.j].size <= babyShark.size) {
                visisted[cLoc.i-1][cLoc.j]=true;
                sea[cLoc.i - 1][cLoc.j].fishLoc.depth= cLoc.depth+1;
                q.offer(sea[cLoc.i - 1][cLoc.j].fishLoc);
            }
            if (cLoc.j + 1 < N && !visisted[cLoc.i][cLoc.j+1] && sea[cLoc.i][cLoc.j + 1].size <= babyShark.size) {
                visisted[cLoc.i][cLoc.j+1]=true;
                sea[cLoc.i][cLoc.j + 1].fishLoc.depth= cLoc.depth+1;
                q.offer(sea[cLoc.i][cLoc.j + 1].fishLoc);
            }
            if (cLoc.j - 1 >=0 && !visisted[cLoc.i][cLoc.j-1] && sea[cLoc.i][cLoc.j - 1].size <= babyShark.size) {
                visisted[cLoc.i][cLoc.j-1]=true;
                sea[cLoc.i][cLoc.j - 1].fishLoc.depth= cLoc.depth+1;
                q.offer(sea[cLoc.i][cLoc.j - 1].fishLoc);
            }
        }

    }


    public static void searchForEatableFish() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(sea[i][j].size!=0){
                    BFS(sea[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sea = new Fish[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int inputFishSize=Integer.parseInt(s.nextToken());
                if (inputFishSize == 9){
                    inputFishSize=0;
                    babyShark = new Shark(i, j);
                }
                sea[i][j] = new Fish(i,j,inputFishSize);
            }
        }

        while(true) {
            int minValue=N*N;
            int minI=-1;
            int minJ=-1;
            searchForEatableFish();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(sea[i][j].size< babyShark.size && sea[i][j].distance>-1 && minValue>sea[i][j].distance){
                        minI=i;
                        minJ=j;
                        minValue=sea[i][j].distance;
                    }
                }
            }

            if(minI!=-1) {
                sea[minI][minJ].size = 0;
                sea[minI][minJ].distance = -1;
                babyShark.moveNext(minI, minJ);
                ans += minValue;
            }else break;
        }

        System.out.println(ans);
    }
}