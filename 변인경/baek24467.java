import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek24467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        boolean result = false;
        int  index = 0;
        int course = 0;
        for(int i= 0;i<10;i++){
            String [] input = br.readLine().split("");
            int sum = 0;
            sum += Integer.parseInt(input[0]);
            sum += Integer.parseInt(input[1]);
            sum += Integer.parseInt(input[2]);
            sum += Integer.parseInt(input[3]);


            while (sum == 4 || sum == 0){
                if(sum == 4 ){

                    index += 5;

                }
                else {
                    index += 4;
                }
                sum = 0;

                input = br.readLine().split("");
                sum += Integer.parseInt(input[0]);
                sum += Integer.parseInt(input[1]);
                sum += Integer.parseInt(input[2]);
                sum += Integer.parseInt(input[3]);
            }
            if(sum == 3){
                index += 1;
            }
            else if (sum == 2){
                index += 2;
            }
            else if(sum == 1){
                index += 3;
            }


            if(course == 0){
                if(index == 5){
                    course = 1;
                    index = 0;
                }
                else if(index == 10){
                    course = 3;

                    index = 0;
                }
                else if(index >= 21){
                    result = true;
                }
            }
            else if(course == 1){
                if(index == 3){
                    course = 2;
                    index = 0;
                }
                else if(index>= 12){
                    result = true;
                }
            }
            else if(course == 2){
                if(index >= 4){
                    result = true;
                }
            }
            else if(course == 3){
                if(index >= 7){
                    result = true;
                }
            }

        }
        if(result ){
            System.out.println("WIN");
        }
        else{
            System.out.println("LOSE");
        }
    }
}
