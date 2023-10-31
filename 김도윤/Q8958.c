#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>


int main(void)
{
	char C[100] = { 0 };
	int t;
	int score = 0;
	int sum = 0;

	scanf("%d", &t);

	for (int i = 0; i < t; i++)
	{
		score = 0;
		sum = 0;

		scanf("%s", C);

		for (int k = 0; k < strlen(C); k++)
		{
			if (C[k] == 'O')
			{
				score = 1;

				for (int l = k - 1; l >= 0; l--)
				{
					if (C[l] == 'O')
					{
						score++;
					}
					else
					{
						break;
					}
				}
			}
			else
			{
				score = 0;
			}
			sum += score;
		}

		printf("%d\n", sum);



	}










	return 0;
}