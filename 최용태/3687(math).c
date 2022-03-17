#include <stdio.h>

int main()
{
	int T,j, i, N = 0;
	int time1, last, time2;
	int Arr[7] = {6,1,7,4,2,0,8};


	scanf("%d", &T);

	for (i = 0; i < T; i++) {
		scanf("%d", &N);

		int borrow, digit = 1, result = 0;
		int firsts = 7;
		int ends = 7;
		int midLast;

		while (N > result) {
			result = 7 * digit;
			digit++;
		}
		midLast = digit - 3;
		borrow = result - N;
		if (N <= 7) {
			if (N == 6)
				printf("6");
			else
				printf("%d", Arr[N - 1]);
		}
		else {
			if (borrow > 0) {
				if (firsts - borrow == 1) {
					borrow--; 
					if (midLast > 0)
						midLast--;
					else
						ends--;
				}
				else if (firsts - borrow == 3) {
					borrow--; 
					if (midLast > 0)
						midLast--;
					else
						ends--;
				}
				if (firsts - borrow == 4) {
					borrow--; 
					if (midLast > 0)
						midLast--;
					else
						ends--; 
				}
				firsts = firsts - borrow;
			}

			if (firsts == 6)
				printf("%d", Arr[0]);
			else
				printf("%d", Arr[firsts - 1]);
			for (int z = 0; z <digit-3 ; z++) {
				if (z < (digit - 3) - midLast)
					printf("0");
				else
					printf("8");
			}
			printf("%d", Arr[ends - 1]);

}
		printf(" ");
		time1 = N / 8;
		time2 = N / 2;
		last = N % 8;

		if (N % 2 == 1) {
			printf("7");
			for (j = 0; j < (time2 - 1); j++)
				printf("1");
		}
		else {
			for (j = 0; j < time2; j++)
				printf("1");
		}
		printf("\n");
	}
	return 0;
}
