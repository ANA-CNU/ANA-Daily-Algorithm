#include <math.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int c, p;
} Item;

int main(void) {
    for (;;) {
        double k;

        int n, m;

        scanf("%d %lf", &n, &k);

        if (n == 0 && k == 0.0) break;

        // 반올림을 통한 부동 소수점 오차 문제 해결 (e.g. `k = 8.29`)
        m = round(k * 100.0);

        Item *items = malloc(n * sizeof(*items));

        for (int i = 0; i < n; i++) {
            scanf("%d %lf", &items[i].c, &k);

            items[i].p = round(k * 100.0);
        }

        int *dp = calloc((m + 1), sizeof(*dp));

        for (int j = 1; j <= m; j++) {
            for (int i = 0; i < n; i++) {
                if (j - items[i].p >= 0 && dp[j] < dp[j - items[i].p] + items[i].c)
                    dp[j] = dp[j - items[i].p] + items[i].c;
            }
        }

        printf("%d\n", dp[m]);

        free(dp), free(items);
    }

    return 0;
}