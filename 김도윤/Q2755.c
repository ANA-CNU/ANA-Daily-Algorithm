#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable:4996)


#include <stdio.h>
#include <string.h>

int main(void)
{
	double sum_c = 0, sum_g = 0;
	double ave = 0.00;
	int n, c = 0;
	double g;
	char class[101];
	char grade[5];

	scanf("%d", &n);

	
	for (int i = 0; i < n; i++)
	{
		scanf("%s %d %s", class, &c, grade);

		if (grade[0] == 'A')
		{
			if (grade[1] == '+')
			{
				g = 4.3;
			}
			else if (grade[1] == '0')
			{
				g = 4.0;
			}
			else
			{
				g = 3.7;
			}
		}
		else if (grade[0] == 'B')
		{
			if (grade[1] == '+')
			{
				g = 3.3;
			}
			else if (grade[1] == '0')
			{
				g = 3.0;
			}
			else
			{
				g = 2.7;
			}
		}
		else if (grade[0] == 'C')
		{
			if (grade[1] == '+')
			{
				g = 2.3;
			}
			else if (grade[1] == '0')
			{
				g = 2.0;
			}
			else
			{
				g = 1.7;
			}
		}

		else if (grade[0] == 'D')
		{
			if (grade[1] == '+')
			{
				g = 1.3;
			}
			else if (grade[1] == '0')
			{
				g = 1.0;
			}
			else
			{
				g = 0.7;
			}
		}
		else
		{
			g = 0;
		}

		sum_c += c;
		sum_g += c * g;

	}

	ave = sum_g / sum_c;

	ave = (int)(ave * 100 + 0.5);
	ave = ave / 100;


	printf("%.2lf", ave);






	
	return 0;
}