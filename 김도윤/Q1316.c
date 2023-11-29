#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	int n;
	int count = 0;
	int c;
	char word[105] = { 0 };
	int alpha[26] = { 0 };

	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		scanf("%s", word);

		for (int k = 0; k < 26; k++)
		{
			alpha[k] = 0;
		}

		c = 1;

		alpha[(int)(word[0] - 'a')]++;

		for (int j = 1; j < strlen(word); j++)
		{
			if ((alpha[(int)(word[j] - 'a')] != 0) && (word[j] != word[j - 1]))
			{
				break;
			}
			else
			{
				alpha[(int)(word[j] - 'a')]++;
				c++;
			}
		}

		if (c == strlen(word))
		{
			count++;
		}

	}

	printf("%d", count);

	return 0;
}