#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#define MAX_SIZE 10


int main() {
	
	int A[10000];
	int N=0;
	int result = 0;
	int start = 0, sum = 0,count=0;
	int flag = 0;
	scanf("%d %d", &N,&result);

	for (int i = 0; i < N; i++) {
		scanf("%d", &A[i]);

		sum += A[i];

			 while (sum >result) {
				 sum -= A[start];
				 start++;
			 }
			
			 if (sum == result)
				 count++;
	}
	printf("%d", count);
}
