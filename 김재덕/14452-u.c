#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

#define PRIVATE static

typedef struct {
    int *ptr;
    size_t capacity;
    size_t length;
} Heap;

PRIVATE Heap *heap_create(size_t capacity);
PRIVATE void heap_release(Heap *h);
PRIVATE void heap_insert(Heap *h, int value);
PRIVATE int heap_delete_min(Heap *h);

PRIVATE bool simulate(int *values, int n, int k, int t);

PRIVATE Heap *h;

/* `valgrind --tool=memcheck --leak-check=full --show-reachable=yes ./bin/14452-u.out` */
int main(void) {
    int n, t;

    scanf("%d %d", &n, &t);

    int *values = malloc(n * sizeof(*values));

    for (int i = 0; i < n; i++)
        scanf("%d", values + i);

    h = heap_create(n);
    
    /* 
        각 소가 무대에 서는 순서를 지켜야 하기 때문에,
        `values`는 따로 정렬하지 않는다.
    */

    {
        // 이제 `k`의 최솟값을 찾아보자.
        int low = 1, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // 만약 `false`라면, `mid`보다 작거나 같은 `k`는 모두 `false`이다.
            if (!simulate(values, n, mid, t)) low = mid + 1;
            else high = mid;
        }

        printf("%d\n", low);
    }

    heap_release(h);

    free(values);

    return 0;
}

PRIVATE Heap *heap_create(size_t capacity) {
    Heap *h = malloc(sizeof *h);

    h->capacity = capacity, h->length = 0;
    h->ptr = malloc((h->capacity + 1) * sizeof(*(h->ptr)));

    return h;
}

PRIVATE void heap_release(Heap *h) {
    if (h != NULL) free(h->ptr);

    free(h);
}

PRIVATE void heap_insert(Heap *h, int value) {
    if (h == NULL) return;

    h->ptr[++h->length] = value;

    int k = h->length;

    // bottom-up heapify (swim)
    while (h->ptr[k >> 1] > h->ptr[k]) {
        int w = h->ptr[k >> 1];

        h->ptr[k >> 1] = h->ptr[k];
        h->ptr[k] = w;

        k >>= 1;
    }
}

PRIVATE int heap_delete_min(Heap *h) {
    if (h == NULL) return INT_MAX;

    int root = h->ptr[1];

    h->ptr[1] = h->ptr[h->length];
    h->ptr[h->length] = root;

    h->length--;

    int k = 1;

    // top-down heapify (sink)
    while ((k << 1) <= h->length) {
        int j = (k << 1);

        if (j < h->length && h->ptr[j] > h->ptr[j + 1]) j++;
        if (h->ptr[k] <= h->ptr[j]) break;

        int w = h->ptr[j];

        h->ptr[j] = h->ptr[k];
        h->ptr[k] = w;

        k = j;
    }

    return root;
}

PRIVATE bool simulate(int *values, int n, int k, int t) {
    while (h->length > 0) heap_delete_min(h);

    int min_value = 0;

    for (int i = 0; i < n; i++) {
        if (h->length == k)
            min_value = heap_delete_min(h);

        if (min_value + values[i] > t) return false;

        heap_insert(h, min_value + values[i]);
    }

    return true;
}
