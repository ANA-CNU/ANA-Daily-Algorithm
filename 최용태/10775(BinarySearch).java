import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static int binarySearch(ArrayList<Integer> gate,int key){
        int left=0;
        int right=gate.size()-1;
        int mid=(left+right)/2;
        while(left<=right){
            if(gate.get(mid)>key)
                right=mid-1;
            else if(gate.get(mid)<key)
                left=mid+1;
            else
                break;
            mid=(left+right)/2;
        }

        System.out.println(key+", mid-> "+gate.get(mid));
        return mid;
    }

    public static void main(String[] args) throws IOException {
        int G=Integer.parseInt(br.readLine());
        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer> gate=new ArrayList<>();
        int ans=0;
        boolean closed=false;
        for(int i=0;i<G+1;i++) gate.add(i);

        for(int i=0;i<N;i++){
            int airplane=Integer.parseInt(br.readLine());
            if(!closed){
                int docked =binarySearch(gate,airplane);
                if(docked == 0){
                    closed=true;
                    continue;
                }
                gate.remove(docked);
                ans++;
            }
        }

        System.out.println(ans);
    }
}