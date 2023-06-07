import java.util.*;
import java.io.*;
public class Boj1966 {
    public static void main(String[]args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            Queue<Integer> queue=new LinkedList<>();
            StringTokenizer st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int index=Integer.parseInt(st.nextToken());
            int []arr=new int [k];
            StringTokenizer st1=new StringTokenizer(br.readLine());
            for(int j=0;j<k;j++){
                arr[j]=Integer.parseInt(st1.nextToken());
            }
            int max=arr[0];
            for(int j=0;j<k;j++){
                queue.add(arr[j]);
                if(max<arr[j])
                    max=arr[j];
            }
            int count=0;
            int c=0;
            while (true) {
                int l=queue.poll();
                if(l<max){
                    queue.add(l);
                    c++;
                    if(index==0){
                        index= queue.size()-1;
                    }else
                        index--;
                    if(c== queue.size()){
                        max= queue.peek();
                        for(int j=0;j< queue.size();j++){
                            int we= queue.poll();
                            if(max< we)
                                max=we;
                            queue.add(we);
                        }
                        c=0;
                    }
                }else{
                    if (index==0)
                        break;
                    c=0;
                    count++;
                    index--;
                }
            }
            System.out.println(count+1);
        }
    }
}
