import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] k;
    static boolean[] vi,ch,fi;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Long> ka=new HashSet<>();
        String[] s = bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
        k=new ArrayList[a+1]; vi=new boolean[a+1]; fi=new boolean[a+1]; ch=new boolean[a+1];
        for(int i=1; i<=a; i++) k[i]=new ArrayList<>();
        while(b-->0){
            s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
            if(!ka.contains(1000000*(long)x+y)){
                k[x].add(y);
                ka.add(1000000*(long)x+y);
            }
        }
        int count=0;
        for(int i=1; i<=a; i++) ch[i]=dfs(i);
        for(int i=1; i<=a; i++) {
            if(ch[i]) count++;
        }
        System.out.println(count);
    }
    static boolean dfs(int x){
        if(vi[x]&&fi[x]) return ch[x];
        vi[x]=true;
        boolean f=true;
        for(int i:k[x]){
            if(vi[i] && !fi[i]) f=false;
            else f&=dfs(i);
        }
        fi[x]=true;
        return ch[x]=f;
    }
}
