import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double result = 0;
        for (int i=0; i<20; i++){
            String str = sc.next();
            double score = sc.nextDouble();
            String S = sc.next();
            switch (S) {
                case "A+" :
                    result += (score * 4.5);
                    sum += score;
                    break;
                case "A0" :
                    result += (score * 4.0);
                    sum += score;
                    break;
                case "B+" :
                    result += (score * 3.5);
                    sum += score;
                    break;
                case "B0" :
                    result += (score * 3.0);
                    sum += score;
                    break;
                case "C+" :
                    result += (score * 2.5);
                    sum += score;
                    break;
                case "C0" :
                    result += (score * 2.0);
                    sum += score;
                    break;
                case "D+" :
                    result += (score * 1.5);
                    sum += score;
                    break;
                case "D0" :
                    result += (score * 1.0);
                    sum += score;
                    break;
                case "F" :
                    result += (score * 0.0);
                    sum += score;
                    break;
                default :
                    break;
            }
        }
        System.out.println(result / sum);
    }
}
