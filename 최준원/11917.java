import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(bf.readLine());
        HashSet<Integer> k=new HashSet<>();
        PriorityQueue<Integer> ka=new PriorityQueue<>();
        int[] tmp=new int[a];
        String[] s = bf.readLine().split(" ");
        for(int i=0; i<a; i++){
            int x=Integer.parseInt(s[i]);
            k.add(x);ka.add(x);tmp[i]=x;
        }
        int b=Integer.parseInt(bf.readLine());
        if(b<=a) System.out.println(tmp[b-1]);
        else {
            while (!ka.isEmpty() && ka.peek() < k.size()) ka.poll();
            if (ka.isEmpty()) System.out.println(b - a + k.size() - 1);
            else System.out.println(Math.min(b - a + k.size() - 1, ka.poll()));
        }
    }
}
