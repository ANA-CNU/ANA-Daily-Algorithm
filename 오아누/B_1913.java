//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class B_1913
{
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class NxNSnail
    {
        private int n;
        private int[][] snailMatrix;
        private int target;
        private int[] targetPos;

        public NxNSnail(int n, int target)
        {
            this.n = n;
            snailMatrix = new int[n][n];
            this.target = target;
            targetPos = new int[2];
            createSnailMatrix();
        }

        private int createSnailMatrix()
        {
            if (n == 0 || snailMatrix == null)
                return -1;

            int dir = 0, num = 1, px = n / 2, py = n / 2;
            Root:
            for (int moveCountUntilTurn = 2;; moveCountUntilTurn++)
            {
                for (int move = 0; move < moveCountUntilTurn / 2; move++)
                {
                    if (num == target)
                    {
                        targetPos[0] = px;
                        targetPos[1] = py;
                    }

                    snailMatrix[py][px] = num++; // num 대입하고 ++
                    if (num > n * n)
                        break Root;

                    switch (dir) {
                        case 0:
                            py--;
                            break;
                        case 1:
                            px++;
                            break;
                        case 2:
                            py++;
                            break;
                        case 3:
                            px--;
                            break;
                    }
                }

                if (++dir > 3)
                    dir = 0;
            }

            return 0;
        }

        public int[] getTargetPos()
        {
            return targetPos;
        }

        public void printSnail() throws IOException
        {
            for (int y = 0; y < n; y++)
            {
                for (int x = 0; x < n; x++)
                {
                    //System.out.print(snailMatrix[y][x] + " ");
                    bw.write(snailMatrix[y][x] + " ");
                }

                //System.out.print("\n");
                bw.write("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        //Scanner input = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        int target = Integer.parseInt(bf.readLine());
        NxNSnail snail = new NxNSnail(n, target);
        snail.printSnail();
        int[] targetPos = snail.getTargetPos();
        //System.out.println((targetPos[1] + 1) + " " + (targetPos[0] + 1));
        bw.write((targetPos[1] + 1) + " " + (targetPos[0] + 1));
        
        //input.close();
        bw.flush();
        bw.close();
    }
}