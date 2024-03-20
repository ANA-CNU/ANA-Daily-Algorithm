import java.util.Scanner;

public class B_1018
{
    private static int min(int a, int b)
    {
        return a < b ? a : b;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        byte[][] board = new byte[input.nextInt()][input.nextInt()];

        input.nextLine(); // nextInt 다음에 줄바꿈 문자를 받아줌

        for (int y = 0; y < board.length; y++) // board.length는 행의 갯수임
        {
            String temp = input.nextLine();

            for (int x = 0; x < temp.length(); x++)
            {
                if (temp.charAt(x) == 'B')
                {
                    board[y][x] = 1;
                }
                else if (temp.charAt(x) == 'W')
                {
                    board[y][x] = 0;
                }
            }
        }

        int minNum = -1;
        for (int y = 0; y <= board.length - 8; y++)
        {
            for (int x = 0; x <= board[y].length - 8; x++)
            {
                boolean isTurnOfBlack_Line = true;
                int numOfWrongCell = 0, numOfWrongCell_Reverse = 0;
                for (int j = y; j < y + 8; j++)
                {
                    boolean isTurnOfBlack = isTurnOfBlack_Line;
                    for (int i = x; i < x + 8; i++)
                    {
                        if (isTurnOfBlack)
                        {
                            if (board[j][i] == 1) // 맞는 경우
                            {
                                numOfWrongCell_Reverse++;
                            }
                            else if (board[j][i] == 0)
                            {
                                numOfWrongCell++;
                            }
                        }
                        else
                        {
                            if (board[j][i] == 1)
                            {
                                numOfWrongCell++;
                            }
                            else if (board[j][i] == 0) // 맞는 경우
                            {
                                numOfWrongCell_Reverse++;
                            }
                        }

                        isTurnOfBlack = !isTurnOfBlack;
                    }

                    isTurnOfBlack_Line = !isTurnOfBlack_Line;
                }

                int temp = min(numOfWrongCell, numOfWrongCell_Reverse);
                if (minNum == -1)
                {
                    minNum = temp;
                }
                else
                {
                    minNum = min(minNum, temp);
                }
            }
        }

        System.out.println(minNum);

        input.close();
    }
}