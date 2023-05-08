import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        // 단어는 공백 한 개로 구분됨, 공백으로 시작하거나 끝날 수 있음
        char[] words = new char[word.length()];
        for (int i=0; i<word.length(); i++){
            words[i] = word.charAt(i);
        }
        if (words[0]==' ' && words[words.length-1]==' ') {
            int count = 0;
            for(int i=1; i<words.length; i++){
                if (words[i]==' '){
                    count += 1;
                }
            }
            System.out.println(count);
        }
        else if (words[0]==' ') {
            int count = 1;
            for(int i=1; i<words.length; i++){
                if (words[i]==' '){
                    count += 1;
                }
            }
            System.out.println(count);
        }
        else if (words[words.length-1]==' '){
            int count = 0;
            for(int i=0; i<words.length; i++){
                if (words[i]==' '){
                    count += 1;
                }
            }
            System.out.println(count);
        }
        else {
            int count = 1;
            for(int i=0; i<words.length; i++){
                if (words[i]==' '){
                    count += 1;
                }
            }
            System.out.println(count);
        }
    }
}
