#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>

int matrix1[101][101];
int matrix2[101][101];
int matrix3[101][101];

int main(void)
{
	int m1, m2, n1, n2;
	int sum = 0;

	scanf("%d %d", &m1, &n1);

	for (int i = 1; i <= m1; i++)
	{
		for (int j = 1; j <= n1; j++)
		{
			scanf("%d", &matrix1[i][j]);
		}
	}

	scanf("%d %d", &m2, &n2);

	for (int i = 1; i <= m2; i++)
	{
		for (int j = 1; j <= n2; j++)
		{
			scanf("%d", &matrix2[i][j]);
		}
	}

	for (int i = 1; i <= 101; i++)
	{
		for (int j = 1; j <= 101; j++)
		{
			matrix3[i][j] = 0;
		}
	}

	for (int i = 1; i <= m1; i++)
	{
		for (int j = 1; j <= n2; j++)
		{
			for (int l = 1, k = 1; l <= m2, k <=n1; k++, l++)
			{
					matrix3[i][j] += matrix1[i][k] * matrix2[l][j];
			}
			
		}
	}

	for (int i = 1; i <= m1; i++)
	{
		for (int j = 1; j <= n2; j++)
		{
			printf("%d ", matrix3[i][j]);
		}
		printf("\n");
	}




	return 0;
}