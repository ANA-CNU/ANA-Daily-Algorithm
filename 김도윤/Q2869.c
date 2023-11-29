#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	int a, b, v;
	
	int count = 0;

	scanf("%d %d %d", &a, &b, &v);

	count = (v - b - 1) / (a - b) + 1;

	printf("%d", count);
	return 0;
}

