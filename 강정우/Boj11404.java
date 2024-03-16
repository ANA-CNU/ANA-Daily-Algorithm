import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11404 {
    public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int k= Integer.parseInt(br.readLine());
        int inf=1000000000;
        int [][]arr=new int [n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(arr[i],inf);
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==j)
                    arr[i][j]=0;
            }
        }
        for(int i=0;i<k;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            if(arr[a][b]>m){
                arr[a][b]=m;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int l=1;l<=n;l++){
                    int cur=arr[j][l];
                    int v=arr[j][i]+arr[i][l];
                    arr[j][l]=Math.min(cur,v);
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                if (arr[i][j] == inf)
                    System.out.print(0 + " ");
                else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
