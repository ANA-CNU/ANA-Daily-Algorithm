#include <stdio.h>
#include <stdlib.h>

#define MAX_TABLE_SIZE 100001

typedef struct {
    int m, c;
} Item;

int main(void) {
    int c, n;

    scanf("%d %d", &c, &n);

    Item *items = malloc(n * sizeof(*items));

    for (int i = 0; i < n; i++)
        scanf("%d %d", &items[i].m, &items[i].c);

    // dp[i] = `i`원을 들였을 때 홍보할 수 있는 고객 수의 최댓값
    // int *dp = calloc(MAX_TABLE_SIZE, sizeof(*dp)), k = -1;
    int dp[MAX_TABLE_SIZE] = { [0] = 0 }, k = -1;

    for (int i = 1; i <= MAX_TABLE_SIZE; i++) {
        for (int j = 0; j < n; j++) {
            if (i - items[j].m >= 0) {
                dp[i] = (dp[i] < dp[i - items[j].m] + items[j].c)
                    ? dp[i - items[j].m] + items[j].c
                    : dp[i];
            }
        }

        if (dp[i] >= c) {
            k = i;

            break;
        }
    }

    printf("%d\n", k);

    // free(dp), free(items);
    free(items);

    return 0;
}