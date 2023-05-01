import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];

        int ans=0;
        StringTokenizer s=new StringTokenizer(br.readLine()," ");

        IntStream.range(0,N).forEach(i->{
            arr[i]=Integer.parseInt(s.nextToken());
            hashMap.put(arr[i], hashMap.containsKey(arr[i]) ? hashMap.get(arr[i])+1 : 1);
        });

        Arrays.sort(arr);

        for(int i=N-1;i>=0;i--) {
            for (int j = N-1; j >= 0; j--) {
                int gap = arr[i] - arr[j];

                if (j!=i && hashMap.containsKey(gap) && !((gap == arr[j] ||  gap == arr[i]) && hashMap.get(gap) < 2)) {
                    if(arr[i]==0 && arr[j]==0 && hashMap.get(0)<3) continue;
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
