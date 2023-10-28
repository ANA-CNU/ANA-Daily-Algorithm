#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	int t, r;
	char str[30] = { 0 };

	scanf("%d", &t);

	for (int i = 0; i < t; i++)
	{
		scanf("%d %s", &r, str);
		for (int j = 0; j < strlen(str); j++)
		{
			for (int k = 0; k < r; k++)
			{
				printf("%c", str[j]);
			}
			
		}
		printf("\n");
	}







	return 0;
}