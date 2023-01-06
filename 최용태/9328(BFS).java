import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void init(HashMap<Character, Integer> hs) {
        for (int i = 0; i < 'Z' - 'A' + 1; i++) {
            hs.put((char) ('A' + i), 0);
        }
    }

    public static char convertKeyToDoor(char c) {
        return (char) (c - 32);
    }

    public static void run(int N, int M) throws IOException {
        HashMap<Character, Integer> keySet = new HashMap<>();
        Queue<Loc> staringQueue = new LinkedList<>();
        char[][] src = new char[N][M];
        int ans = 0;


        for (int i = 0; i < N; i++) {
            src[i] = br.readLine().toCharArray();
        }

        init(keySet);

        String key = br.readLine();

        for (int i = 0; i < key.length(); i++) {
            keySet.put(convertKeyToDoor(key.charAt(i)), 1);
        }

        for (int j = 0; j < M; j++) {
            if (src[0][j] != '*') staringQueue.offer(new Loc(0,j));
            if (src[N - 1][j] != '*') staringQueue.offer(new Loc(N-1,j));
        }
        for (int i = 0; i < N; i++) {
            if (src[i][0] != '*') staringQueue.offer(new Loc(i,0));
            if (src[i][M-1] != '*') staringQueue.offer(new Loc(i,M-1));
        } // 가장자리 탐색
        int count=0;
        while(!staringQueue.isEmpty()){
            Loc start=staringQueue.poll();
            if(src[start.i][start.j] >= 'A' && src[start.i][start.j] <= 'Z'){
                if(keySet.get(src[start.i][start.j])>0){
                    ans+=search(keySet,staringQueue,src,start);
                    count=0;
                }else{
                    staringQueue.offer(new Loc(start.i, start.j)); // nothingfound
                    count++;
                    if(count>N*M) break;
                }
            }else{
                ans+=search(keySet,staringQueue,src,start);
                count=0;
            }
        }
        bw.write(ans+"\n");
    }

    public static int search(HashMap<Character, Integer> keySet, Queue<Loc> staringQueue, char[][] src, Loc start) {
        Queue<Loc> q = new LinkedList<>();
        int document = 0;
        int N = src.length;
        int M = src[0].length;
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        q.offer(start);

        if(src[start.i][start.j]>='a' && src[start.i][start.j] <='z'){
            keySet.put(convertKeyToDoor(src[start.i][start.j]), 1);
        }else if(src[start.i][start.j]=='$'){
            document++;
        }

        src[start.i][start.j]='*';

        while (!q.isEmpty()) {
            Loc c = q.poll();
            for (int x = 0; x < 4; x++) {
                int I=c.i + di[x];
                int J=c.j + dj[x];

                if (I < N && I >= 0 && J < M && J >= 0) {
                    if (src[I][J] != '*') {
                        if (src[I][J] == '.') {
                            q.offer(new Loc(I, J));
                            src[I][J] = '*';
                        } else if (src[I][J] == '$') {
                            document++;
                            q.offer(new Loc(I, J));
                            src[I][J] = '*';
                        } else if (src[I][J] >= 'A' && src[I][J] <= 'Z') {
                            if (keySet.get(src[I][J]) > 0) {
                                q.offer(new Loc(I, J));
                                src[I][J] = '*';
                            } else { // 문이 안 열릴 경우
                                staringQueue.offer(new Loc(I, J));
                            }
                        } else if (src[I][J] >= 'a' && src[I][J] <= 'z') {
                            q.offer(new Loc(I, J));
                            keySet.put(convertKeyToDoor(src[I][J]), 1);
                            src[I][J] = '*';
                        }
                    }
                }
            }
        }

        return document;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine(), " ");
            run(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
        }
        bw.flush();
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