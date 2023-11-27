#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	int t, k, n;
	int room[15][15] = { 0 };

	for (int i = 0; i < 15; i++)
	{
		room[0][i] = i;
	}

	for (int i = 1; i < 15; i++)
	{
		for (int j = 1; j < 15; j++)
		{
			room[i][j] = room[i - 1][j] + room[i][j - 1];
		}
	}

	scanf("%d", &t);

	for(int i = 0; i < t; i++)
	{
		scanf("%d", &k);
		scanf("%d", &n);
		
		printf("%d\n", room[k][n]);
	}



	return 0;
}