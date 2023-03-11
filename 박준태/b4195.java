import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b4195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<test; i++){
            int relate = Integer.parseInt(br.readLine());//입력받는 이름 수
            HashMap<String, Integer> map = new HashMap<>();//str->int
            int var = 0;//0,1은 대표 2명
            Graph g = new Graph(2*relate);
            int[] parent = new int[2*relate];//그룹의 인원저장
            for(int j=0; j<relate; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a)){
                    map.put(a,var);
                    var++;
                }
                if(!map.containsKey(b)){
                    map.put(b,var);
                    var++;
                }//string->int

                int e = g.find_root(map.get(a));
                int f = g.find_root(map.get(b));
                if(e!=f){
                    g.union_root(e,f);
                }
                sb.append(g.amount[g.find_root(e)]).append("\n");
            }//그룹화
        }
        System.out.println(sb);
    }
}
class Graph{
    int[] amount;
    int[] parent;
    public Graph(int F){
        parent = new int[F+1];
        for(int i=0; i<=F; i++){
            parent[i]=i;
        }
        amount = new int[F+1];
        for(int i=0; i<=F; i++){
            amount[i]=1;
        }
    }
    public int find_root(int x){
        if(x == parent[x]) return x;
        return parent[x]=find_root(parent[x]);
    }
    public void union_root(int x, int y){
        x = find_root(x);
        y = find_root(y);
        if(x!=y){
            parent[x]=y;
            amount[y]+=amount[x];
        }
    }
}