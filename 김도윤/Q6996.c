#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	int n;
	int count = 0;
	char word1[101];
	char word2[101];

	int alpha1[26] = { 0 };
	int alpha2[26] = { 0 };

	

	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		scanf("%s %s", word1, word2);

		count = 0;
		for (int j = 0; j < 26; j++)
		{
			alpha1[j] = 0;
			alpha2[j] = 0;
		}

		for (int j = 0; j < strlen(word1); j++)
		{
			alpha1[(int)(word1[j] - 'a')]++;
		}

		for (int j = 0; j < strlen(word2); j++)
		{
			alpha2[(int)(word2[j] - 'a')]++;
		}

		for (int j = 0; j < 26; j++)
		{
			if (alpha2[j] != alpha1[j])
			{
				count = 1;
			}
		}

		if (count == 1)
		{
			printf("%s & %s are NOT anagrams.\n", word1, word2);
		}

		else
		{
			printf("%s & %s are anagrams.\n", word1, word2);
		}


	}


	return 0;
}