#include <stdio.h>
#include <stdlib.h>

static int compare_values(const void *a, const void *b) {
    int x = *(const int *) a, y = *(const int *) b;

    return (x > y) - (x < y);
}

int main(void) {
    int n, k;

    scanf("%d %d", &n, &k);

    // 건초 배열의 각 원소 사이의 변화량이 저장될 배열.
    int *diff = calloc(n + 1, sizeof *diff);

    for (int i = 0; i < k; i++) {
        int a, b;

        scanf("%d %d", &a, &b);

        // 시작 지점에서부터 계속 1씩 증가하다가,
        // 끝 지점에서부터는 더 이상 증가하지 않는다.
        diff[a]++, diff[b + 1]--;

#ifndef ONLINE_JUDGE
        printf("[DEBUG] D[] = { ");

        for (int j = 1; j <= n; j++)
            printf("%d, ", diff[j]);

        puts("_ }");
#endif
    }

    int *values = calloc(n, sizeof *values);

    // 변화량 배열을 실제 배열로 변환한다.
    for (int i = 0; i < n; i++)
        values[i] = ((i > 0) ? values[i - 1] : 0) + diff[i + 1];

#ifndef ONLINE_JUDGE
    printf("[DEBUG] V[] = { ");

    for (int i = 0; i < n; i++)
        printf("%d, ", values[i]);

    puts("_ }");
#endif

    // 바로 그냥~ 정렬해버리기!
    qsort(values, n, sizeof(*values), compare_values);

    printf("%d\n", values[n / 2]);
    
    free(values), free(diff);

    return 0;
}