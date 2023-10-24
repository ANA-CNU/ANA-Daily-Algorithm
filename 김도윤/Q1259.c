#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	char num1[6];
	int count;

	while (1)
	{
		count = 1;

		scanf("%s", num1);
		
		if (num1[0] == '0')
		{
			break;
		}

		for (int i = 0; i < strlen(num1) / 2; i++)
		{
			if (num1[i] != num1[strlen(num1) - 1 - i])
			{
				count = 0;
			}
		}
		
		if (count == 0)
		{
			printf("no\n");
		}
		else if (count == 1)
		{
			printf("yes\n");
		}

	}








	return 0;
}