#include <stdio.h>

int main(void)
{
	int number[1000] = { 0 };
	int a, b;
	int sum = 0;
	int z = 0;

	scanf("%d %d", &a, &b);
	
	for (int i = 1; i < 46; i++)
	{
		for (int j = 0; j < i; j++)
		{
			number[z] = i;
			z++;
            if(z == 1001)
            {
                break;
            }
		}
		if (z == 1001)
		{
			break;
		}
	}
	for (int i = a-1; i <= b-1; i++)
	{
		sum += number[i];
	}
	printf("%d", sum);





	return 0;
}