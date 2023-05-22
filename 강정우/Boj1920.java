import java.util.*;

public class Boj1920{
    static int search(int[]arr,int key, int low, int high) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if(key == arr[mid]) {
                return 1;
            } else if(key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
    public static void main(String[]args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int [n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        int k= sc.nextInt();
        int []arr2=new int[k];
        for(int i=0;i<k;i++){
            arr2[i]= sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            System.out.println(search(arr,arr2[i],0,arr.length-1));
        }
    }
}
