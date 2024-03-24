import java.util.Scanner;
import java.util.BitSet;

public class B_1929
{
    /*
    private static BitSet getPrimeSet(int n) // n까지의 소수 집합을 리턴
    {
        BitSet primeSet = new BitSet();
        primeSet.set(2);

        for (int i = 3; i <= n; i++)
        {
            boolean isPrime = true;
            int pointer = 2;
            if (i % 2 == 0) // 짝수
            {    
                while (pointer <= i / 2 && pointer != -1)
                {
                    if (i % pointer == 0)
                    {
                        isPrime = false;
                        break;
                    }

                    pointer = primeSet.nextSetBit(pointer + 1);    
                }    
            }
            else // 홀수
            {
                while (pointer <= i / 3 && pointer != -1)
                {
                    if (i % pointer == 0)
                    {
                        isPrime = false;
                        break;
                    }

                    pointer = primeSet.nextSetBit(pointer + 1);
                }
            }

            if (isPrime)
            {
                primeSet.set(i);
            }
        }

        return primeSet;
    }
    */ // 처음에 시도했던 거 근데 너무 느림

    // 아레니우스 체? 아무튼 그 방식
    private static BitSet fastGetPrimeSet(int n)
    {
        BitSet primeSet = new BitSet();
        primeSet.set(2);

        BitSet nonPrimeSet = new BitSet();
        for (int i = 2; i <= n; i++)
        {
            if (nonPrimeSet.get(i) == false)
            {
                primeSet.set(i);
                for (int j = i; j <= n; j += i)
                {
                    nonPrimeSet.set(j);
                }
            }
        }

        return primeSet;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int m = input.nextInt();
        int n = input.nextInt();

        // BitSet primeSet = getPrimeSet(n);
        BitSet primeSet = fastGetPrimeSet(n);

        for (int p = primeSet.nextSetBit(m); p <= n && p != -1; p = primeSet.nextSetBit(p + 1))
        {
            System.out.println(p);
        }

        input.close();
    }
}