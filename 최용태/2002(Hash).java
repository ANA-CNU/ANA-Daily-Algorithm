import java.io.*;
import java.util.*;

public class Main {
    static Hashtable<String,Integer> ht=new Hashtable<String,Integer>();
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       int count=0;
       int N=Integer.parseInt(br.readLine());
       int current=0;
       int a[]=new int[N];

       for(int i=0;i<N;i++){
           ht.put(br.readLine(),i);
       }
       for(int i=0;i<N;i++){
           int v=ht.get(br.readLine());
           a[v]=i;
       }
       current=a[0];
       for(int i=0;i<N-1;i++){
           if(a[i+1]<current)
               count++;
           else
               current=a[i+1];
       }

        System.out.println(count);
    }
}
