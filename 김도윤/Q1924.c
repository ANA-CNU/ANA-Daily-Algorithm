#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>

int main(void)
{
	int month[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
	int m, d;
	int l = 0;

	scanf("%d %d", &m, &d);

	for (int i = 1; i < m; i++)
	{
		l += month[i-1];
	}

	l += d;
	
	switch (l%7)
	{
	case 0: printf("SUN\n"); break;
	case 1: printf("MON\n"); break;
	case 2: printf("TUE\n"); break;
	case 3: printf("WED\n"); break;
	case 4: printf("THU\n"); break;
	case 5: printf("FRI\n"); break;
	case 6: printf("SAT\n"); break;
	

	default:
		break;
	}








	return 0;
}