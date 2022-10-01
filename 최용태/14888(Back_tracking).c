#include <stdio.h>
#include <string.h>
#include <math.h>

#define MAX_SIZE 11
#define max(a,b) (((a)>(b)) ? (a) : (b))
#define min(a,b) (((a)<(b)) ? (a) : (b))

int arr[MAX_SIZE];
int operator[4];
int N = 0;
int ans_min = 1000000000;
int ans_max = -1000000000;

void search(int n,int sum,int currentOp[]) {
    
    if (n == N-1) {
        ans_max = max(ans_max, sum);
        ans_min = min(ans_min, sum);
        return;
    }
    else {
        for (int i = 0; i < 4; i++) 
            if (currentOp[i] > 0) {
                int tmp = 0;
                currentOp[i]--;
                switch (i)
                {
                    case 0:
                        tmp = sum + arr[n+1];
                        break;
                    case 1:
                        tmp = sum - arr[n+1];
                        break;
                    case 2:
                        tmp = sum * arr[n+1];
                        break;
                    case 3:
                        tmp = sum / arr[n+1];
                        break;
                }
                printf("\ntmp : %d\n", tmp);
                search(n + 1, tmp, currentOp);
                currentOp[i]++;
            }
    }
}


int main() {
    
    scanf("%d", &N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    for (int i = 0; i <4; i++) {
        scanf("%d", &operator[i]);
    }

    search(0,arr[0],operator);

    printf("%d\n%d", ans_max, ans_min);

    return 0;
}