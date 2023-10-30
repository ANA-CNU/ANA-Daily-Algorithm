#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>


int main(void)
{
	char arr[1000001] = { 0 };
	int alpha[26] = { 0 };
	int max = 0;
	int count = 0;
	int length = 0;

	scanf("%s", arr);

	length = strlen(arr);

	for (int i = 0; i < length; i++)
	{
		for (int j = 0; j < 26; j++)
		{
			if (arr[i] == 'A' + j || arr[i] == 'a' + j)
			{
				alpha[j]++;

				break;
			}
		}
	}
	
	for (int i = 0; i < 26; i++)
	{
		if (alpha[max] < alpha[i])
		{
			max = i;
		}
	}

	for (int i = 0; i < 26; i++)
	{
		if (alpha[max] == alpha[i])
		{
			count++;
		}
	}

	if (count != 1)
	{
		printf("?");
	}
	else
	{
		printf("%c", 'A' + max);
	}

	return 0;
}