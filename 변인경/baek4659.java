import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            String[] arr = input.split("");
            int firstCase_flag = 0;
            int secondCase_flag = 0;
            int thirdCase_flag = 0;
            if (input.contains("a") || input.contains("e") || input.contains("i") || input.contains("o") || input.contains("u")) {
                firstCase_flag = 1;
            }
            if (firstCase_flag == 0) {
                System.out.println("<" + input + "> is not acceptable.");

            } else {

                int count_mom = 0;
                int count_son = 0;

                for (int i = 0; i < arr.length; i++) {

                    if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {

                        count_mom++;
                        count_son = 0;
                        if (count_mom == 3) {
                            secondCase_flag = 1;
                            break;
                        }
                    } else {
                        count_mom = 0;
                        count_son++;
                        if (count_son == 3) {
                            secondCase_flag = 1;
                            break;
                        }
                    }

                }
                if (secondCase_flag == 1) {
                    System.out.println("<" + input + "> is not acceptable.");


                } else {
                    String save_double = arr[0];
                    for (int i = 0; i < arr.length - 1; i++) {


                        if (save_double.equals(arr[i + 1])) {
                            if (!save_double.equals("e") && !save_double.equals("o")) {

                                thirdCase_flag = 1;
                                break;
                            }
                        } else {
                            save_double = arr[i + 1];
                        }
                    }
                    if (thirdCase_flag == 1) {
                        System.out.println("<" + input + "> is not acceptable.");

                    } else {
                        System.out.println("<" + input + "> is acceptable.");

                    }
                }


            }

        }

    }
}
