#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	char S[101] = { 0 };
	int _c = 0, a = 0, A = 0, n = 0;


	while (1)
	{
		for (int i = 0; i < 101; i++)
		{
			S[i] = 0;
		}

		_c = 0;
		a = 0;
		A = 0;
		n = 0;

		gets(S);
		if (S[0] == 0)
		{
			break;
		}

		for (int i = 0; i < strlen(S); i++)
		{
			if (S[i] == ' ')
			{
				_c++;
			}
			else if(S[i] >= 'a' && S[i] <= 'z')
			{
				a++;
			}
			else if (S[i] >= 'A' && S[i] <= 'Z')
			{
				A++;
			}
			else if(S[i] >= '0' && S[i] <= '9')
			{
				n++;
			}
			else 
			{
				break;
			}
		}

		printf("%d %d %d %d\n", a, A, n, _c);
	}







	return 0;
}