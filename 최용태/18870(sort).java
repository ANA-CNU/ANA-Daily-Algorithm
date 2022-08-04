import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

public class Main {


    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        int key=0;
        int prev=1000000001;

        ArrayList<Integer> arr=new ArrayList<Integer>(N);
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>(N);

        String num=br.readLine();
        StringTokenizer before=new StringTokenizer(num," ");
        StringTokenizer after=new StringTokenizer(num," ");

        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(before.nextToken()));
        }

        Collections.sort(arr);

        for(int i=0;i<N;i++){
            int Num=arr.get(i);
            if(prev!=Num) {
                hs.put(Num,key);
                key++;
            }
            prev=Num;
        }
        for(int i=0;i<N;i++) {
            int keyNum=Integer.parseInt(after.nextToken());
            bw.write(hs.get(keyNum)+" ");
        }
        bw.flush();
    }






    public static void main(String[] args) throws Exception {
       run();
    }
}
