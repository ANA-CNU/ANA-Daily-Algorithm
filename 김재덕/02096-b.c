#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n;

    scanf("%d", &n);

    int values[4] = { 0 };

    scanf("%d %d %d", &values[1], &values[2], &values[3]);

    int max_sums[4] = { [1] = values[1], [2] = values[2], [3] = values[3] };
    int min_sums[4] = { [1] = values[1], [2] = values[2], [3] = values[3] };

    int p[4] = { 0 }, q[4] = { 0 };

    for (int y = 2; y <= n; y++) {
        scanf("%d %d %d", &values[1], &values[2], &values[3]);

        for (int x = 1; x <= 3; x++) {
            if (x == 1) {
                p[x] = (max_sums[1] > max_sums[2]) ? 1 : 2;
                q[x] = (min_sums[1] < min_sums[2]) ? 1 : 2;
            } else if (x == 2) {
                p[x] = (max_sums[1] > max_sums[2]) ? 1 : 2;
                p[x] = (max_sums[p[x]] > max_sums[3]) ? p[x] : 3;

                q[x] = (min_sums[1] < min_sums[2]) ? 1 : 2;
                q[x] = (min_sums[q[x]] < min_sums[3]) ? q[x] : 3;
            } else {
                p[x] = (max_sums[2] > max_sums[3]) ? 2 : 3;
                q[x] = (min_sums[2] < min_sums[3]) ? 2 : 3;
            }
        }

        int old_max_sums[4] = { [1] = max_sums[1], [2] = max_sums[2], [3] = max_sums[3] };
        int old_min_sums[4] = { [1] = min_sums[1], [2] = min_sums[2], [3] = min_sums[3] };

        for (int x = 1; x <= 3; x++) {
            max_sums[x] = values[x] + old_max_sums[p[x]];
            min_sums[x] = values[x] + old_min_sums[q[x]];
        }
    }

    int max = (max_sums[1] > max_sums[2]) ? max_sums[1] : max_sums[2];
    max = (max > max_sums[3]) ? max : max_sums[3];

    int min = (min_sums[1] < min_sums[2]) ? min_sums[1] : min_sums[2];
    min = (min < min_sums[3]) ? min : min_sums[3];

    printf("%d %d\n", max, min);

    return 0;
}