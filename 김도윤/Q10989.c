#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>

int main(void)
{
	int n, c;
	int max = 0;
	int num[10001] = { 0 };

	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &c);

		if (c > max)
		{
			max = c;
		}
		num[c]++;
	}

	for (int i = 0; i < max + 1; i++)
	{
		for (int j = 0; j < num[i]; j++)
		{
			printf("%d\n", i);
		}	
	}

	return 0;
}