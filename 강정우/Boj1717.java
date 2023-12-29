import java.util.*;
import java.io.*;
public class Boj1717 {
    static int n,m;
    static int[]list;
    static int find(int a){
        if(a==list[a]){
            return a;
        }else {
            return list[a]=find(list[a]);
        }
    }
    static void union(int a,int b){
        a =find(a);
        b =find(b);
        if(a!=b){
            list[b]=a;
        }
    }
    static boolean checkSame(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        list=new int[n+1];
        for(int i=0;i<=n;i++){
            list[i]=i;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int cal= Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            if(cal==0){
                union(a,b);
            }else{
                if(checkSame(a,b)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }
}
