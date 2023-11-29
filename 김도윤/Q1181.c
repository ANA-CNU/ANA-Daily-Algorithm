#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char word[20002][52];

int compare(const void* first, const void* second)
{
	if (strlen((char*)first) > (strlen((char*)second)))
	{
		return 1;
	}

	else if (strlen((char*)first) < (strlen((char*)second)))
	{
		return -1;
	}

	else
	{
		return strcmp((char*)first, (char*)second);
	}
	
}


int main(void)
{
	int n; 

	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		scanf("%s", word[i]);
	}

	qsort(word, n, sizeof(word[0]), compare);
	
	for (int i = 0; i < n; i++)
	{
		if (strcmp(word[i], word[i + 1]) != 0 || i == (n -1))
		{
			printf("%s\n", word[i]);
		}
	}

	return 0;
}