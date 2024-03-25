import java.util.Scanner;

public class B_1024
{
    private static int[] calc(int sum, int length)
    {
        int temp = sum - length * (length - 1) / 2;
        int[] tttmpp;

        if (temp < length && temp != 0)
        {
            return new int[] { -1 };
        }

        if (temp % length == 0)
        {
            return new int[] { temp / length, length };
        }
        else
        {
            if (length >= 100)
            {
                return new int[] { -1 };
            }

            tttmpp = calc(sum, length + 1);
        }

        return tttmpp;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int sum, length;
        sum = input.nextInt();
        length = input.nextInt();

        int[] tmp = calc(sum, length);
        if (tmp[0] != -1)
        {
            length = tmp[1];
            for (int i = 0; i < length; i++)
            {
                System.out.printf("%d ", tmp[0] + i);
            }
        }
        else
        {
            System.out.println(-1);
        }

        input.close();
    }
}