import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class B7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int [][] man = new int [num][3];

        for(int i = 0; i < num; i++){
            String [] arr2 = br.readLine().split(" ");
            man[i][0] = Integer.parseInt(arr2[0]);
            man[i][1] = Integer.parseInt(arr2[1]);
            man[i][2] = 1;
        }

        for(int i = 0; i < num; i++){
            for(int j = i; j < num; j++){
                if(man[i][0] > man[j][0] && man[i][1] > man[j][1]){
                    man[j][2]++;
                }else if(man[i][0] < man[j][0] && man[i][1] < man[j][1]){
                    man[i][2]++;
                }
            }
        }

        for(int i = 0; i < num; i++){
            System.out.print(man[i][2] + " ");
        }
    }
}
