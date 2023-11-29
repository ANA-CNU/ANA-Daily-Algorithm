#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)

#include <stdio.h>
#include <stdlib.h>

typedef struct 
{
	int x;
	int y;
} coordinate;


int static compare(const void* first, const void* second)
{
	coordinate a = *(coordinate *)first;
	coordinate b = *(coordinate *)second;

	if (a.x > b.x)
	{
		return 1;
	}
	else if (a.x == b.x && a.y > b.y)
	{
		return 1;
	}
	else
	{
		return -1;
	}



}

int main(void)
{
	int n;
	
	scanf("%d", &n);

	coordinate coord[100000];

	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &coord[i].x, &coord[i].y);
	}

	qsort(coord, n, sizeof(coordinate), compare);
	
	for (int i = 0; i < n; i++)
	{
		printf("%d %d\n", coord[i].x, coord[i].y);
	}
	
	
	return 0;
}