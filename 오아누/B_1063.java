import java.util.Scanner;

public class B_1063
{
    private static class Piece
    {
        public static final byte R = 1; // 0000 0001
        public static final byte L = 1 << 1; // 0000 0010
        public static final byte B = 1 << 2; // 0000 0100
        public static final byte T = 1 << 3; // 0000 1000
        // 이렇게 해서 RB 같은건 OR 연산으로 해버릴거임

        private char file, rank;
        
        public Piece(String pos)
        {
            this.file = pos.charAt(0);
            this.rank = pos.charAt(1);
        }

        public byte move(byte order)
        {
            char tempFile = file, tempRank = rank;

            // 만약 R이 입력돼있으면 1을 더함. 아니면 0을 더함
            tempFile += order & R;
            tempFile -= (order & L) >>> 1;
            tempRank -= (order & B) >>> 2;
            tempRank += (order & T) >>> 3;

            if ('A' <= tempFile && tempFile <= 'H' && '1' <= tempRank && tempRank <= '8')
            {
                file = tempFile;
                rank = tempRank;

                return 0; // 정상적으로 이동
            }

            return -1; // 벽에 막힘
        }

        public static byte stringToOrder(String str)
        {
            switch (str) {
                case "R":
                    return R;
            
                case "L":
                    return L;

                case "B":
                    return B;

                case "T":
                    return T;

                case "RT":
                    return R|T;

                case "LT":
                    return L|T;

                case "RB":
                    return R|B;

                case "LB":
                    return L|B;

                default:
                    return (byte)-1;
            }
        }

        public char getFile()
        {
            return file;
        }

        public char getRank()
        {
            return rank;
        }
    }

    private static class King extends Piece
    {
        private Rock rock;

        public King(String pos, Rock rock)
        {
            super(pos);
            this.rock = rock;
        }

        @Override
        public byte move(byte order)
        {
            if (super.move(order) == -1)
            {
                return -1;
            }

            if (rock.getFile() == getFile() && rock.getRank() == getRank())
            {
                if (rock.move(order) == -1)
                {
                    super.move((byte)(~order & 15)); // NOT 연산 하고 0000 1111 에 대해 AND 연산을 하므로써 반대로 이동 가능
                }
            }

            return 0;
        }
    }

    private static class Rock extends Piece
    {
        public Rock(String pos)
        {
            super(pos);
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        String kingPos = input.next(), rockPos = input.next();

        Rock rock = new Rock(rockPos);
        King king = new King(kingPos, rock);

        int numOfMove = input.nextInt();
        input.nextLine(); // nextInt 줄바꿈 문제 받기
        for (int i = numOfMove; i > 0; --i)
        {
            byte order = Piece.stringToOrder(input.nextLine());
            king.move(order);
        }

        System.out.println("" + king.getFile() + king.getRank()); // 그냥 더하니까 정수 덧셈 돼서 문자열 덧셈 하기 위해 "" 붙임
        System.out.println("" + rock.getFile() + rock.getRank());

        input.close();
    }
}