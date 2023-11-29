#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	char S[102] = { 0 };

	fgets(S, 101, stdin);

	for (int i = 0; i < strlen(S); i++)
	{
		if ((S[i] >= 'A' && S[i] <= 'M') || (S[i] >= 'a' && S[i] <= 'm'))
		{
			S[i] += 13;
		}
		else if ((S[i] > 'M' && S[i] <= 'Z') || (S[i] > 'm' && S[i] <= 'z'))
		{
			S[i] -= 13;
		}
	}

	for (int i = 0; i < strlen(S); i++)
	{
		printf("%c", S[i]);
	}



	return 0;
}