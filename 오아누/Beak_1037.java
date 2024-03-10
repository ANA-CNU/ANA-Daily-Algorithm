import java.util.Scanner;

public class Beak_1037
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();

        int minDivNum = -1, maxDivNum = -1; // 초기화 그냥 -1로 함
        for (; i > 0; i--)
        {
            int curNum = input.nextInt();
            if (curNum > maxDivNum)
            {
                maxDivNum = curNum;
            }

            if (curNum < minDivNum || minDivNum == -1)
            {
                minDivNum = curNum;
            }
        }

        System.out.println(minDivNum * maxDivNum);

        input.close();

        // 약수의 갯수와 그 수의 모든 약수가 주어졌을 때, 그 수를 어떻게 구할 수 있냐
        // 만약 그 수가 짝수라면, 약수 중 가장 큰 수 * 2
        // 만약 그 수가 홀수라면??
        // 어쩌면 약수 중 가장 작은 수 * 약수 중 가장 큰 수 = 그 수. 라고 할 수 있지 않을까??
        // 99, 3, 33
        // 121, 11, 11
        // 1024, 2, 512
        // 77, 7, 11
        // 2*179, 2, 179
        // 아마 맞을 듯 하다
    }
}