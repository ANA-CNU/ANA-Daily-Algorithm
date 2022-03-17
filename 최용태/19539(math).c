#include <stdio.h>
int main()
{
	int N, i;
	int result; // MAX_SIZE == 100000
	int last_2=0;
	int last_1=0;
	scanf("%d", &N);

	for (i = 0; i < N; i++) {
		scanf("%d", &result);
		last_2 = last_2 + result / 2;
		if (result % 2 != 0)
			last_1++;
	}
	printf("result : %d \n",last_2 - last_1);
	if ((last_2 - last_1) % 3 == 0 && (last_2-last_1)>=0)
		printf("YES");
	else
		printf("NO");


	return 0;
}