import java.util.Scanner;

/*
 * 팩토리얼을 다 계산 한다는 건 말이 안되고,
 * 끝자리의 0의 개수라는 건 소인수분해 했을때 2와 5의 지수부 중 더 작은 값. (*10의 개수)
 */

public class B_1676
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int count_2 = 0, count_5 = 0;
        for (; n > 0; n--) // n = 0일 경우 0 출력 (0! = 1 이므로)
        {
            int temp = n;
            while (temp % 2 == 0)
            {
                count_2++;
                temp /= 2;
            }

            while (temp % 5 == 0)
            {
                count_5++;
                temp /= 5;
            }
        }

        System.out.println(count_2 < count_5 ? count_2 : count_5);

        input.close();
    }
}