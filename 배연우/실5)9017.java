import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = stoi(st);
        for(int i = 0; i < T; i++) {
            //입력 파트
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            int maxNum = 0;
            for(int j = 0; j < N; j++) {
                arr[j] = stoi(st);
                maxNum = Math.max(maxNum, arr[j]);
            }

            //연산 파트 1 - 팀의 성립여부 파악하기
            int[] team = new int[maxNum+1]; //index = team & value = teamCnt
            int[] fifth = new int[maxNum+1];
            ArrayList<Integer> teamList = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                team[arr[j]]++;
                if(team[arr[j]] == 6) {
                    teamList.add(arr[j]);
                }
            }

            //연산 파트 2 - 팀의 등수 파악하기
            int[] score = new int[maxNum+1];
            team  = new int[maxNum+1];
            int current = 0;
            for(int j = 0; j < N; j++) {
                if(teamList.contains(arr[j])) {
                    current++;
                    if(team[arr[j]] < 4) {
                        score[arr[j]] += current;
                        team[arr[j]]++;
                    }
                    else if(team[arr[j]] == 4) {
                        fifth[arr[j]] = current;
                        team[arr[j]]++;
                    }

                }
            }
            //연산 파트 3 - 팀의 점수 계산하기 + 등수 계산하기
            int best = teamList.get(0);
            for(int j = 0; j < maxNum+1; j++) {
                if(score[j] == 0) {
                    continue;
                }
                if(score[best] > score[j]) {
                    best = j;
                } else if (score[best] == score[j]) {
                    if(fifth[best] > fifth[j]) {
                        best = j;
                    }
                }
            }
            //출력 파트
            System.out.println(best);
        }
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}