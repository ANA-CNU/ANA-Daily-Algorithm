import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] str_arr = str.toCharArray();
        int count = 0;
        String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(int i=0; i<arr.length; i++){
            if(str.contains(arr[i])){
                str = str.replace(arr[i],"!");
            }
        }
        System.out.println(str.length());
    }
}
