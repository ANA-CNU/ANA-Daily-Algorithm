import java.util.Scanner;
import java.util.Arrays;

public class B_1920
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int[] nums = new int[input.nextInt()];
        for (int i = 0; i < nums.length; ++i)
        {
            nums[i] = input.nextInt();
        }
        
        /* 버블 정렬 너무 느리잖슴~~
        for (int j = nums.length - 1; j > 0; --j)
        {
            for (int i = 0; i < j; ++i)
            {
                if (nums[i] > nums[i + 1])
                {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        */

        Arrays.sort(nums);
        for (int x = input.nextInt(); x > 0; --x)
        {
            int target = input.nextInt();
            int startIdx = 0, endIdx = nums.length - 1;
            boolean isExist = false;
            while (startIdx <= endIdx)
            {
                if (target > nums[(startIdx + endIdx) / 2])
                {
                    startIdx = (startIdx + endIdx) / 2 + 1;
                }
                else if (target < nums[(startIdx + endIdx) / 2])
                {
                    endIdx = (startIdx + endIdx) / 2 - 1;
                }
                else
                {
                    isExist = true;
                    break;
                }
            }

            System.out.println(isExist ? 1 : 0);
        }

        input.close();
    }
}