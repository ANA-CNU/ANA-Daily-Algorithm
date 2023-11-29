#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>


int main(void)
{

	int num[5] = { 0 };
	int temp;
	int count = 1;
	int b = 0; 

	for (int i = 0; i < 5; i++)
	{
		scanf("%d", &num[i]);
	}
	while (count)
	{
		for (int i = 0; i < 4; i++)
		{
			if (num[i + 1] < num[i])
			{
				temp = num[i + 1];
				num[i + 1] = num[i];
				num[i] = temp;

				for (int j = 0; j < 5; j++)
				{
					printf("%d ", num[j]);
				}
				printf("\n");
			}
		}
		
		b = 0;

		for (int i = 0; i < 5; i++)
		{
			if (num[i] == i + 1)
			{
				b++;
			}
		}
		if (b == 5)
		{
			count = 0;
		}

	}
	





	return 0;
}