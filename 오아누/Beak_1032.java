import java.util.Scanner;

public class Beak_1032
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine(); // 엔터 문제 때문에

        String[] fileNames = new String[n];
        char[] texts = null;

        for (int i = 0; i < n; i++)
        {
            String curString = input.nextLine();
            fileNames[i] = curString;
            
            int textLength = curString.length();
            if (texts == null)
            {
                texts = new char[textLength];
                for (int j = 0; j < textLength; j++)
                {
                    texts[j] = curString.charAt(j);
                }
            }            
            else
            {
                for (int j = 0; j < textLength; j++)
                {
                    char curChar = curString.charAt(j);
                    if (texts[j] != curChar)
                    {
                        texts[j] = '?';
                    }
                }
            }
        }

        System.out.println(String.valueOf(texts));

        input.close();
    }
}