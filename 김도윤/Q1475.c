#include <stdio.h>
#include <string.h>
#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#define SWAP(a,b)  {int t; t = a; a=b; b=t;}

int main(void)
{
	char number[8];

	int num[10] = { 0 };


	scanf("%s", number);

	for (int i = 0; i < strlen(number); i++)
	{
		for (int j = 48; j < 58; j++)
		{
			if (number[i] == j)
			{
				num[j - 48] += 1;
			}
		}
	}

	num[6] += num[9];
	if (num[6] % 2 == 0)
	{
		num[6] /= 2;
	}
	else
	{
		num[6] /= 2;
		num[6]++;
	}

	num[9] = 0;

	for (int i = 0; i < 10; i++)
	{
		for (int j = i; j < 10; j++)
		{
			if (num[i] > num[j])
			{
				SWAP(num[i], num[j]);
			}
		}
	}
	printf("%d", num[9]);

	return 0;
}