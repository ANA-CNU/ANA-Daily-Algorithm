import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] alph = new char[26];
        int[] count = new int[26];
        for (int i=0; i<alph.length; i++){
            alph[i] = (char)(97+i);
        }
        String word = sc.nextLine();
        for (int i=0; i<word.length(); i++){
            for (int j=0; j<alph.length; j++){
                if (word.charAt(i) == alph[j] || word.charAt(i)== (char)(alph[j]-32)) {
                    count[j] += 1;
                }
            }
        }
        int max = 0;
        int n = 0;
        for (int i=0; i<count.length; i++){
            if (max < count[i]) {
                max = count[i];
                n = i;
            }
        }
        int cnt = 0;
        for (int i=0; i<count.length; i++){
            if(max == count[i]) {
                cnt += 1;
            }
        }
        if(cnt > 1){
            System.out.println("?");
        } else {
            System.out.println((char)(alph[n]-32));
        }
    }
}
