import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[5][];
        for(int i=0; i<arr.length; i++){
            String str = sc.nextLine();
            arr[i] = new char[str.length()];
            for(int j=0; j<str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<15; i++){
            for(int j=0; j<arr.length; j++){
                if (arr[j].length <= i) {
                    continue;
                } else{
                    System.out.print(arr[j][i]);
                }
            }
        }
    }
}
