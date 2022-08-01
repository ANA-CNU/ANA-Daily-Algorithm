import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String file = br.readLine();
        String word = br.readLine();

        int wordLeng = word.length();

        int arr[] = new int[file.length()];
        for(int i = 0; i < file.length(); i++){
            arr[i] = file.charAt(i);
        }

        int i = 0;
        int index = 0;
        int current = 0;
        int count = 0;

        while(i < file.length()){
            if(arr[i] == word.charAt(index)){ //같은거체크
                if(index == 0){
                    current = i;
                }
                index++;
            }else{
                if(index > 0){
                    i = current;
                }
                index = 0;
            }

            if(index == wordLeng){
                index = 0;
                count++;
            }
            i++;
        }
        System.out.println(count);
    }
}
//문자열을 입력받고, 문자열 길이만큼 반복문돌려서확인
//두번째받은 문자열 기준으로 첫째글자부터 쭉확인함
//중복안되니까 한번센인덱스는 무시
