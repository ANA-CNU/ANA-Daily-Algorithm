import java.util.*;

public class B_10815 {
    public static void main(String[] args)
    {
        final int BIAS = 10000001;

        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        BitSet bit = new BitSet();
        for(; m > 0; m--)
        {
            bit.set(input.nextInt() + BIAS);
        }

        m = input.nextInt();
        BitSet compBitSet = new BitSet();
        int[] arr = new int[m];
        for (; m > 0; m--)
        {
            int temp = input.nextInt();
            compBitSet.set(temp + BIAS);
            arr[arr.length - m] = temp;
        }

        compBitSet.and(bit);

        for(int i = 0; i < arr.length; i++)
        {
            if (compBitSet.get(arr[i] + BIAS))
            {
                System.out.print("1 ");
            }
            else
            {
                System.out.print("0 ");
            }
        }
    } 
}