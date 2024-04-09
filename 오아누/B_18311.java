import java.util.Scanner;

public class B_18311
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] sections = new int[input.nextInt()];
        long position = input.nextLong(); // k가 엄청엄청 크게 주어질 수 있으므로

        for (int i = 0; i < sections.length; i++)
        {
            sections[i] = input.nextInt();
        }

        int i = 0;
        boolean isWayBack = false;
        while (true)
        {
            position -= sections[i];
            if (position < 0) // position이 왕복거리보다 항상 적게 주어지므로 outOfIndex 없이 탈출 가능
            {
                break;
            }

            if (isWayBack)
            {
                i--;
            }
            else
            {
                if (++i >= sections.length)
                {
                    i--;
                    isWayBack = true;
                }
            }
        }

        System.out.print(i + 1);
        input.close();
    }
}