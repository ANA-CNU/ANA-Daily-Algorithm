#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{

	int t;
	char str[50];
	char str2[50];

	scanf("%d", &t);

	scanf("%s", str);

	for (int i = 0; i < t - 1; i++)
	{
		scanf("%s", str2);

		for (int j = 0; j < strlen(str); j++)
		{
			if (str[j] != str2[j])
			{
				str[j] = '?';
			}

		}
	}

	for (int i = 0; i < strlen(str); i++)
	{
		printf("%c", str[i]);
	}





	return 0;
}