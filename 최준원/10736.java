import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> ka=new ArrayList<>();
        boolean[] tmp=new boolean[101];
        tmp[4]=tmp[8]=tmp[16]=tmp[32]=tmp[64]=true;
        ka.add(0); ka.add(1); ka.add(2);
        int i=3,p=2;
        while(i<=100){
            if(tmp[i]){
                int k=i/2;
                while(k-->0){
                    ka.add(++p);
                    i++;
                }
            }
            else{
                ka.add(p);
                i++;
            }
        }
        int g = Integer.parseInt(bf.readLine());
        while (g-- > 0) {
            int a=Integer.parseInt(bf.readLine());
            int x=ka.get(a);
            while(ka.get(a-1)==x) a--;
            System.out.println(x);
            for(int j=0; j<x; j++){
                System.out.print(a-j+" ");
            }
            System.out.println();
        }
    }
}
