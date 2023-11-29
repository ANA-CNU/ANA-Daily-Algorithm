#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>

int main(void)
{
	int a, b, c;

	int temp1, temp2, temp3;

	for (int i = 1000; i < 10000; i++)
	{
		a = 0, b = 0, c = 0;

		temp1 = i;
		temp2 = i;
		temp3 = i;

		while (temp1)
		{
			a += temp1 % 10;
			temp1 /= 10;
		}

		while (temp2)
		{
			b += temp2 % 12;
			temp2 /= 12;
		}

		while (temp3)
		{
			c += temp3 % 16;
			temp3 /= 16;
		}

		if ((a == b) && (b == c))
		{
			printf("%d\n", i);
		}

	}


	return 0;
}