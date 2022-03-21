#include <stdio.h>

void N2devide(int n1,int d,int n2) {
	if (n2 == 1) {
		printf("%d %d\n",n1,n2);
		return;
	}
	else
		N2devide(n1, d, n2 / d);

	printf("%d %d\n",n1,n2);
}

void N1devide(int n1, int n2, int d1, int d2) {

	if (n1 == 1) {
		N2devide(n1, d2, n2);
		return;
	}
	else {
		while (1) {

		}
		N1devide(n1 / d1, n2, d1, d2);
	}

	N2devide(n1, d2, n2);
}


int main()
{
	unsigned int N1 , N2;
	unsigned int i=1,j=1;
	scanf("%d %d", &N1, &N2);
	while (j <=N1) {
		if (N1 % j != 0) {
			j++;
			continue;
		}
		i = 1;
	while (i<=N2) {
		if (N2 % i != 0) {
			i++;
			continue;
		}
		else
			printf("%d %d\n", j, i++);
	}
	j++;
}

	return 0;
}