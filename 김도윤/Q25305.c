#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b)
{
	int num1 = *(int*)a;
	int num2 = *(int*)b;

	if (num1 < num2)
	{
		return -1;
	}
	else if (num1 > num2)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

int main(void)
{
	int n, k;
	int x[1002] = { 0 };

	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &x[i]);
	}

	qsort(x, n, sizeof(int), compare);

	printf("%d", x[n - k]);

	
	return 0;
}