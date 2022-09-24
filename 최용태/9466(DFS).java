import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans=0;
    static int[] a=new int[100000+1];

    public static void BFS(int start,int[] a,boolean[] visited,boolean[] selected){ // visited에 본인도 있어야 가능
        int nextIdx=start;
        visited[start]=true;

        Stack<Integer> stk=new Stack<Integer>();
        stk.push(start);

        while(true){ // 죄송합니다
            int current=nextIdx;
            nextIdx=a[current];

            if(selected[nextIdx]){
                while(!stk.isEmpty()){
                    int lastIdx=stk.pop();
                    selected[lastIdx]=true;
                    ans++;
                }
                return;
            }else if(visited[nextIdx]){
                while(stk.peek()!=nextIdx){
                    int poopedIdx=stk.pop();
                    selected[poopedIdx]=true;
                }
                selected[stk.pop()]=true;
                while(!stk.isEmpty()){
                    int lastIdx=stk.pop();
                    selected[lastIdx]=true;
                    ans++;
                }
                return;
            }else{
                stk.push(nextIdx);
                visited[nextIdx]=true;
            }
        }
    }

    public static int search() throws IOException {
        int N=Integer.parseInt(br.readLine());
        boolean[] selected=new boolean[N+1];
        boolean[] visited=selected.clone();
        StringTokenizer s=new StringTokenizer(br.readLine()," ");

        for(int i=1;i<N+1;i++){
            a[i]=Integer.parseInt(s.nextToken());
        }

        for(int i=1;i<N+1;i++){
            if(!selected[i]) {
                BFS(i, a, selected,visited);
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());

         for(int i=0;i<T;i++){
            sb.append(search()).append("\n");
            ans=0;
         }

        System.out.println(sb);
    }
}