import java.util.Scanner;

public class Beak_10430
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[3];

        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = input.nextInt();
        }

        System.out.printf("%d\n", (nums[0] + nums[1]) % nums[2]);
        System.out.printf("%d\n", ((nums[0] % nums[2]) + (nums[1] % nums[2])) % nums[2]);
        System.out.printf("%d\n", (nums[0] * nums[1]) % nums[2]);
        System.out.printf("%d\n", ((nums[0] % nums[2]) * (nums[1] % nums[2])) % nums[2]);

        input.close();
    }
}