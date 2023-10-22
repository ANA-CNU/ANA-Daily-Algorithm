#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>

int IsPrime(long long int num)
{
	int count = 0;

	for (long long int i = 2; i * i <= num; i++)
	{
		if (num % i == 0)
		{
			return 1; // 소수가 아님
		}
	}
	return 0; // 소수임
}

int main(void)
{
	int t;
	long long int n;

	scanf("%d", &t);

	for (int i = 0; i < t; i++)
	{

		scanf("%lld", &n);


		if (n == 0 || n == 1)
		{
			printf("%d\n", 2);
			continue;
		}
		else if (n == 2 || n == 3)
		{
			printf("%d\n", n);
			continue;
		}
		while (IsPrime(n))
		{
				n++;
		}

			printf("%lld\n", n);
	}

	return 0;
}