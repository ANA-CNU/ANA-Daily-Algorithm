import java.util.*;
import java.io.*;


public class Main {
    static int N=0;
    static int[] a;

    public static LinkedList<Integer> search() throws IOException {
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=N-1;i>=0;i--){
            list.add(a[i],i+1);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        a=new int[N];
        LinkedList<Integer> l=new LinkedList<>();

        for(int i=0;i<N;i++){
            a[i]=Integer.parseInt(s.nextToken());
        }
        for(int i=0;i<N;i++){
            bw.write(search().get(i)+" ");
        }
        bw.flush();
    }
}