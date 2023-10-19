#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int arr1[300][300];

int main(void)
{
	int n, m, k, a, b, x, y;
	unsigned int sum = 0;

	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &arr1[i][j]);
		}
	}

	scanf("%d", &k);

	for (int i = 0; i < k; i++)
	{
		sum = 0;

		scanf("%d %d %d %d", &a, &b, &x, &y);

		for (int i1 = a - 1; i1 < x; i1++)
		{
			for (int i2 = b - 1; i2 < y; i2++)
			{
				sum += arr1[i1][i2];
			}
		}
		printf("%d\n", sum);
	}






	return 0;
}