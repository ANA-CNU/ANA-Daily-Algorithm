import java.util.Scanner;

public class B_2439
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        for (int i = 1; i <= n; i++)
        {
            String str = "";
            for (int j = n - i; j > 0; j--)
            {
                str += " ";
            }
            for (int j = i; j > 0; j--)
            {
                str += "*";
            }

            System.out.println(str);
        }

        input.close();
    }
}