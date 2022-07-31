import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int count = 1;
    public static boolean checking(int x, int y){ //점수가 같은지 체킹
        if(x == y){
            count++;
            return true;
        }else{
            return false;
        }
    }
    public static void sort(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(arr[0][j] < arr[0][j+1]){
                    int temp = arr[0][j];
                    arr[0][j] = arr[0][j+1];
                    arr[0][j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken())+1;
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 1){
            System.out.println(1);
            return;
        }

        arr = new int[2][N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N-1; i++){
            arr[0][i] = Integer.parseInt(st.nextToken());
        }

        arr[0][N-1] = newScore;
        sort(N);

        for(int i = 0; i < N; i++){
            arr[1][i] = i+1; //등수먹여놓음
        }

        for(int i = 1; i < N; i++){
            if(checking(arr[0][i-1], arr[0][i])){ //전 점수 현점수 비교 true면
                arr[1][i] = arr[1][i-1];
            }else{
                arr[1][i] = arr[1][i-1] + count;
                count = 1;
            }
        }

        for(int i = 0; i < N; i++){
            int current = i+1; //지금까지확인한 사람수
            int count = 0;
            if(arr[0][i] == newScore && current <= P){
                int j = i;
                while( j < N-1 &&(arr[1][j+1] == arr[1][i])){
                    count++;
                    j++;
                }
                if(count+current <= P){
                    sb.append(arr[1][i]);
                    break;
                }else{
                    sb.append(-1);
                    break;
                }
            }else if(i == N-1){ //위에서 조건충족시 break걸리니까 끝까지안된거면 -1
                sb.append(-1);
            }
        }

        /*for(int i = 0; i < 2; i++){
            for(int j = 0; j < N; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }*/
        System.out.println(sb);
    }
}
//N: 2번째줄입력받을 현재점수개수
//newScore: 새로입력받은 점수
//P: 등수커트라인
//2차원 배열로 생성후 0번째 열에는 점수 비내림차순정렬, 1번째 열에는 등수 차례로 일단입력
//0번째 열에서 인덱스1번부터 차례로 서칭하면서 점수가같으면 등수를 앞에인덱스껄로 바꿔주고
//몇개가 같았는지 카운트.
//이후 카운트가 0이상이면 점수가 다를때 카운트반영해서 등수 바꿔줌.
//P와 newscore가 같은값이면 이 인덱스가 마지막인지 넘어가는경우인지.....
