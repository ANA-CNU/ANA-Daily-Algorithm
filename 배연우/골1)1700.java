import java.util.*;
import java.io.*;

public class Main {
    static int[] plug;
    public static void main(String[] Args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st);
        int K = stoi(st);

        plug = new int[N];
        int size = 0;
        int[] log = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            log[i] = stoi(st);
        }

        int k = -1;
        while(size < N) {
            k++;
            if(k >= K) {
                break;
            }
            int tar = log[k];
            if(isContain(tar)) {
                continue;
            }

            plug[size] = tar;
            size++;
        }

        int cnt = 0;
        for (int i = N; i < K; i++) {
            //만약 이미 꽃혀 있다면
            if(isContain(log[i])) {
                continue;
            }

            //꽃혀 있지 않다면
            cnt++;
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j : plug) {
                tmp.add(j);
            }
            for (int j = i+1; j < K && tmp.size() > 1; j++) {
                tmp.remove(Integer.valueOf(log[j]));
            }

            //남은 한개를 제거
            int tar = tmp.get(0);
            for (int j = 0; j < N; j++) {
                if(plug[j] == tar) {
                    plug[j] = log[i];
                }
            }
        }

        System.out.println(cnt);
    }
    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static boolean isContain(int tar) {
        for (int i : plug) {
            if(i == tar) {
                return true;
            }
        }
        return false;
    }
}