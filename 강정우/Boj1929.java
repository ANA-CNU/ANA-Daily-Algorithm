import java.util.*;
public class Boj1929 {
    static void primeNumberSieve(int k,int n){
    int number = n;
    int []primeNum=new int[n+1];
    for (int i = 2; i <= number; i++)
    {
        primeNum[i] = i;
    }
    for (int i = 2; i <= Math.sqrt(number); i++)
    {
        if (primeNum[i] == 0)
            continue;
        for (int j = i * i; j <= number; j += i)
            primeNum[j] = 0;
    }
    for(int i=k;i<=n;i++){
        if(primeNum[i]!=0)
            System.out.println(primeNum[i]);
    }
}

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        primeNumberSieve(a,b);
    }
}
