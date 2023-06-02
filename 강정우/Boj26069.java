import java.util.*;
public class Boj26069 {
    public static void main(String[]main){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        HashSet<String>set=new HashSet<>();
        set.add("ChongChong");
        for(int i=0;i<n;i++){
            String a= sc.next();
            String b= sc.next();
            if(set.contains(a)){
                set.add(b);
            } else if (set.contains(b)) {
                set.add(a);
            }
        }
        System.out.println(set.size());
    }
}
