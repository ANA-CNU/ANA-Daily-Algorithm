import java.util.Scanner;

public class 백준_17548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();

        int eCount = 0;
        
        for(int i = 0; i < st.length(); i++){
            char c = st.charAt(i);
            if(c == 'e'){
                eCount += 1;
            }
        }
        System.out.print("h");
        for(int i = 0; i < eCount*2; i++){
            System.out.print("e");
        }
        System.out.print("y");
    }
}
