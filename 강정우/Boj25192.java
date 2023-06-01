import java.util.*;
public class Boj25192 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<String,Boolean> map = new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            String s=sc.next();
            if(s.equals("ENTER")){
                map.clear();
            }else{
                try {
                    if (map.get(s)) {
                        count--;
                    }
                }catch (Exception e){
                    map.put(s,true);
                }
                finally {
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
