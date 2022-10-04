import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 20127 {


    static int n,num[],result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        num=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }
        up();
        down();
        if(result==Integer.MAX_VALUE) {
            System.out.println("-1");
        }
        else {
            System.out.println(result);
        }

    }

    private static void down() {
        // TODO Auto-generated method stub
        int count=0;
        Queue<Integer> q=new LinkedList<Integer>();
        int change=1;
        for(int i=1;i<n;i++) {
            if(num[i-1]<num[i]) {
                count++;
                q.add(change);
                change=1;
            }
            else {
                change++;
            }
        }
        if(count>1) {
            return;
        }
        else if(count==1) {
            if(num[0]<=num[n-1]) {
                result=Math.min(result,q.remove());
            }
        }
        else {
            result=0;
        }
    }

    private static void up() {
        // TODO Auto-generated method stub
        int count=0;
        Queue<Integer> q=new LinkedList<Integer>();
        int change=1;
        for(int i=1;i<n;i++) {
            if(num[i-1]>num[i]) {
                count++;
                q.add(change);
                change=1;
            }
            else {
                change++;
            }
        }
        if(count>1) {
            return;
        }
        else if(count==1) {
            if(num[0]>=num[n-1]) {
                result=Math.min(result,q.remove());
            }
        }
        else {
            result=0;
        }
    }




}
