import java.util.Scanner;

public class B_10818
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = input.nextInt(); i > 0; --i)
        {
            int temp = input.nextInt();
            max = temp > max ? temp : max;
            min = temp < min ? temp : min;
        }

        System.out.println(min + " " + max);
    }
}