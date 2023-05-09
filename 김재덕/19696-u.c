#include <stdio.h>
#include <stdlib.h>

#define ITEM_LIST_INIT_CAPACITY 8

typedef struct {
    int v, w, k; // 가치, 무게 및 수량
} Item;

typedef struct {
    struct { int v, k; } *ptr;
    int capacity, length, w;
} ItemList;

int compare_items(const void *a, const void *b) {
    const Item *x = (const Item *) a;
    const Item *y = (const Item *) b;

    if (x->w == y->w) return (x->v < y->v) - (x->v > y->v);
    else return (x->w > y->w) - (x->w < y->w);
}

int main(void) {
    int S, N, L = 0;
    
    scanf("%d %d", &S, &N);

    Item *items = malloc(N * sizeof *items);

    for (int i = 0; i < N; i++) {
        int v, w, k;

        scanf("%d %d %d", &v, &w, &k);

        // 물품의 무게가 최대 중량보다 크다면, 그냥 무시한다.
        if (w > S || k < 1) continue;

        items[L++] = (Item) { v, w, k };
    }

    // 각 물품을 무게 오름차순, 그리고 가치 내림차순으로 정렬한다.
    qsort(items, L, sizeof *items, compare_items);

    int M = 1;

    for (int i = 1; i < N; i++)
        if (items[i - 1].w != items[i].w) M++;

    ItemList *table = malloc(M * sizeof *table);

    for (int i = 0; i < M; i++) {
        table[i].capacity = ITEM_LIST_INIT_CAPACITY;
        table[i].length = 0, table[i].w = -1;

        table[i].ptr = malloc(
            table[i].capacity * sizeof *(table[i].ptr)
        );
    }

    int table_idx = 0;

    table[0].w = items[0].w;

    table[table_idx].ptr[table[table_idx].length].v = items[0].v;
    table[table_idx].ptr[table[table_idx].length].k = items[0].k;

    table[table_idx].length++;

    for (int i = 1; i < N; i++) {
        if (items[i - 1].w != items[i].w)
            table_idx++, table[table_idx].w = items[i].w;

        if (table[table_idx].length >= table[table_idx].capacity)
            table[table_idx].ptr = realloc(
                table[table_idx].ptr,
                (table[table_idx].capacity *= 2) * sizeof *(table[table_idx].ptr)
            );
        
        table[table_idx].ptr[table[table_idx].length].v = items[i].v;
        table[table_idx].ptr[table[table_idx].length].k = items[i].k;

        table[table_idx].length++;
    }

    long long int **dp = malloc((M + 1) * sizeof *dp);

    for (int i = 0; i <= M; i++) {
        dp[i] = calloc((S + 1), sizeof **dp);

        for (int s = 1; s <= S; s++) dp[i][s] = -1;
    }

    {
        for (int n = 1; n <= M; n++) {
            for (int s = 0; s <= S; s++) {
                dp[n][s] = dp[n - 1][s];

                long long int V = 0LL;

                // `c`는 같은 무게를 가진 모든 물품의 개수, 
                // `u`는 선택한 종류의 물품의 개수
                int w = table[n - 1].w, c = 0, t = 0, u = 0;

                while ((c + 1) * w <= s && t < table[n - 1].length) {
                    V += table[n - 1].ptr[t].v, c++, u++;

                    if (dp[n - 1][s - c * w] >= 0)
                        dp[n][s] = dp[n][s] > (dp[n - 1][s - c * w] + V)
                                ? dp[n][s]
                                : dp[n - 1][s - c * w] + V;

                    if (u == table[n - 1].ptr[t].k) u = 0, t++;
                }
            }
        }
    }

    long long int result = 0LL;

     for (int n = 1; n <= M; n++)
        for (int s = 0; s <= S; s++)
            result = (result > dp[n][s]) ? result : dp[n][s];

    printf("%lld\n", result);

    for (int i = 0; i <= M; i++) free(dp[i]);
    for (int i = 0; i < M; i++) free(table[i].ptr);

    free(dp), free(table), free(items);

    return 0;
}