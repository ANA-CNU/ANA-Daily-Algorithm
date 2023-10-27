#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <string.h>

int main(void)
{
	int mushroom[10] = {0, };
	int sum = 0;
	int k = 0;

	
	for (int i = 0; i < 10; i++)
	{
		scanf("%d", &mushroom[i]);
	}
	
	while (1)
	{
		sum += mushroom[k];
		
		if (sum >= 100)
		{
			break;
		}

		k++;
	}

	if (sum - 100 > 100 - 1 * (sum - mushroom[k]))
	{
		printf("%d", (sum - mushroom[k]));
	}
	else
	{
		printf("%d", sum);
	}





	return 0;
}