import java.util.Scanner;
import java.math.BigInteger;

/*
 
0 -> 10, 1 -> 01

1, 01, 1001, 01101001, 1001011001101001, 01101001100101101001011001101001, 1001011001101001011010011001011001101001100101101001011001101001

0들의 그룹이 몇개냐..
0이 3개 연속인 경우는 없다

이전에 01 이었다면 1001 0그룹이 하나 나옴
이전에 00 이었다면 1010 0그룹 1, 그리고 우 연결가능성이 있는 0그룹이 하나 존재
이전에 11 이었다면 0101 마찬가지. 좌 연결가능성 1
이전에 10이었다면 0110 옆에랑 연결 가능성이 있는 0그룹이 2개 존재

근데 보니까 신기한 패턴이 있네?

n번째 이진수 = (n-1번째 이진수 반전) << pow(2, n-1) | (n-1번째 이진수)

이게 있다면 n번째 이진수를 찾는건 O(n)임.
그러면 n번째 이진수를 찾을 수 있음.

근데 문제는 n이 1000까지 갔을 때 long 범위도 넘길것 같다는 거지
생각해보면 n번째 이진수의 길이는 2^(n-1). long의 비트수는 64개 n이 7만 돼도 노답.

그러면 1그룹의 수와 0그룹의 수로 접근.
1번째 이진수 1. 1그룹의 수는 1, 0그룹의 수는 0
2번째 이진수 01. 이전 1그룹 + 0그룹 만큼 1그룹과 0그룹의 수가 정해짐.
다만.. 반전돼서 붙는 접합부에서 겹치는 경우가 생길수 있음.
예를 들면 01101001-10010110 의 경우 (이전 1그룹 + 0그룹 - 1) 만큼 1그룹, (이전 1그룹 + 0그룹) 만큼 0그룹임.
마찬가지로 10-01 도 0그룹이 -1 되었음.
그럼 언제 0그룹을 -1하고 1그룹을 -1하냐?
이전 이진수의 양끝자리가 서로 다를때, 0그룹을 -1한다. 왜냐면 맨 끝자리는 항상 1이므로 반전될때, 0그룹이 겹침.
이전 이진수의 양끝자리가 다른진 어떻게 알아? 보니까 같다 안 같다가 번갈아 가면서 나온다.
0 -> 10, 1 -> 01 이므로 당연한 얘기. 따라서 n % 2 == 0 일때  같지 않고 홀수일때 같다.
즉 홀수일때 0그룹의 수를 (이전 1그룹 + 0그룹 - 1)로 잡으면 된다.
근데 이러면 굳이 재귀적으로 구현 할 것도 없이 상수타임으로 바로 나오는 거 아님?

아니 근데 출력할 값이 너무 큰데?
비트가 대충 2^999개가 필요함. 저장하려면. 근데 long이 64개니까, long이 16개는 필요하겠네.
long이 하나에 8 byte 니까 128 byte. 널널함. 근데 이거하고 저거하면 좀 모지랄수도?

BigInteger 이용해서 해결

 */

public class B_2226
{
    private static BigInteger[] calcBinaryGroupsNum(int n)
    {
        if (n == 1)
        {
            return new BigInteger[] { new BigInteger("0"), new BigInteger("1") };
        }
        else
        {
            if (n % 2 == 0)
            {
                BigInteger[] temp = calcBinaryGroupsNum(n - 1);
                return new BigInteger[] { temp[0].add(temp[1]), temp[0].add(temp[1]) };
            }
            else
            {
                BigInteger[] temp = calcBinaryGroupsNum(n - 1);
                return new BigInteger[] { temp[0].add(temp[1].add(new BigInteger("-1"))), temp[0].add(temp[1]) };
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println(calcBinaryGroupsNum(input.nextInt())[0]);

        input.close();
    }
}