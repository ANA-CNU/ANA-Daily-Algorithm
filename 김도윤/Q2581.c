#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <stdbool.h>

int main(void)
{
	int n, m;
	bool is_prime = true;
	int sum = 0;
	int min;

	scanf("%d", &m);
	scanf("%d", &n);

	for (int i = m; i <= n; i++)
	{
		is_prime = true;

		if (i == 1)
		{
			continue;
		}

		for (int j = 2; j * j <= i; j++)
		{
			if (i % j == 0)
			{
				is_prime = false;
			}
		}

		if (is_prime == true)
		{
			if (sum == 0)
			{
				min = i;
			}

			sum += i;
		}
	}


	if (sum != 0)
	{
		printf("%d\n%d", sum, min);
	}

	else
	{
		printf("-1");
	}
	

	return 0;
}