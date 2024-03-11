import java.util.Scanner;

public class Beak_8393
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int sum = (n + 1) * n / 2; // 홀수든 짝수든 상관없는 공식. 그리고 컴퓨터 상으로도 홀수든 짝수든 2로 나누기 전의 값이 짝수니까 값이 잘못버려질 일 없음
        
        System.out.println(sum);

        input.close();
    }
}