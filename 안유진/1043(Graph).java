import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean people[] = new boolean[N+1];
        //원래값 false, 진실을 알고있는사람은 true로 바꿔줌
        boolean partycheck[] = new boolean[M];
        //원래값 false, 진실을말해야해서 망해버린 파티는 true. 나중에 false counting

        st = new StringTokenizer(br.readLine(), " ");
        int truthnum = Integer.parseInt(st.nextToken());

        //진실된사람 큐에 저장함
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < truthnum; i++){
            int temp  = Integer.parseInt(st.nextToken());
            queue.addLast(temp);
            people[temp] = true;
        }
       //파티정보저장
        int party[][] = new int[M][50];
        for(int i = 0; i < M;  i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            party[i][0] = num;
            for(int j = 1; j < num+1; j++){
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력은여기서끝

        while(!queue.isEmpty()){
            int truth = queue.removeFirst();
            for(int i = 0; i < M; i++){
                int check = 1;
                int num = party[i][0];
                for(int j = 1; j < num+1; j++){
                    int temp = party[i][j];
                    if(truth == temp){
                        partycheck[i] = true;
                        people[temp] = true;
                        check = 0;
                    }
                }
                if(check == 0){
                    for(int j = 1; j < num+1; j++){
                        int temp = party[i][j];
                        if(!people[temp]){
                            people[temp] = true;
                            queue.addLast(temp);
                        }
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < M; i ++){
            if(!partycheck[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
