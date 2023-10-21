#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>


int main(void)
{
	int t, temp;
	int num[50];

	scanf("%d", &t);

	for (int i = 0; i < t; i++)
	{
		scanf("%d", &num[i]);
	}

	for (int i = 0; i < t - 1; i++)
	{
		for (int j = 0; j < t - 1 - i; j++)
		{
			if (num[j] > num[j + 1])
			{
				temp = num[j];
				num[j] = num[j + 1];
				num[j + 1] = temp;
			}
		}
	}
	if (t == 1)
	{
		printf("%d", num[0] * num[0]);
	}
	else
	{
		printf("%d", num[0] * num[t - 1]);
	}




}