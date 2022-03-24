import java.util.Scanner;
public class Main{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            String n;
            int count=0;
            while(true){
                n=sc.nextLine();
                char[] arr=n.toCharArray();
                if(arr[0]=='0'){
                    break;
                }
                for(int i=0;i<=(arr.length-1)/2;i++){
                    if(arr[i]==arr[arr.length-i-1]){
                        count++;
                    }
                }
                if(count==(arr.length+1)/2){
                    System.out.print("yes\n");
                    count=0;
                }
                else{
                    System.out.print("no\n");
                    count=0;
                }
                

            }
        }
}
