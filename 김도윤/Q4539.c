#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int count(double n)
{
	int count = 0;
	while ((int)n)
	{
		n /= 10;
		count++;
	}

	return count;
}


int main(void)
{
	int n;
	double num;
	int c;
	
	scanf("%d", &n);


	for (int i = 0; i < n; i++)
	{
		scanf("%lf", &num);
		
		c = count(num);
		
		for (int j = 0; j < c - 1; j++)
		{
			num = num / 10.00;
			num += 0.5;
		}

		num = (int)num;

		for (int j = 0; j < c - 1; j++)
		{
			num *= 10;

		}
		printf("%d\n", (int)num);
	}



	return 0;
}