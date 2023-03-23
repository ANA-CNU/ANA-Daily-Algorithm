#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int n, t;
} Entry;

int compare_entries(const void *a, const void *b) {
    Entry *x = (const Entry *) a, *y = (const Entry *) b;

    return (x->t > y->t) - (x->t < y->t);
}

int main(void) {
    int m;

    scanf("%d", &m);

    Entry *entries = malloc(m * sizeof(*entries));

    for (int i = 0; i < m; i++)
        scanf("%d %d", &entries[i].n, &entries[i].t);
    
    qsort(entries, m, sizeof(*entries), compare_entries);

    int low = 0, high = m - 1, max = -1;

    while (low <= high) {
        int k = (entries[low].n < entries[high].n)
            ? entries[low].n
            : entries[high].n;

        entries[low].n -= k, entries[high].n -= k;

        if (max < entries[low].t + entries[high].t)
            max = entries[low].t + entries[high].t;

        if (entries[low].n <= 0) low++;
        if (entries[high].n <= 0) high--;
    }

    printf("%d\n", max);

    free(entries);

    return 0;
}