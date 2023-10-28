#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>

int PowerOfN(int X, int N)
{
	int X1 = X;

	if (N == 0)
	{
		return 1;
	}

	for (int i = 0; i < N - 1; i++)
	{
		X = X * X1;
	}

	return X;
}

int main(void)
{
	int x = 1;
	int a;
	int count = 0;

		scanf("%d", &x);

		for (int i = 6; i >= 0; i--)
		{
			a = PowerOfN(2, i);

			if (x >= a)
			{
				x = x - a;
				count++;
			}
		}

		printf("%d", count);

	




	return 0;
}