#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#define HEAP_ELEMENT_TYPE   Entry
#define HEAP_INIT_CAPACITY  8

typedef struct {
    int i, v;
} Entry;

typedef struct {
    HEAP_ELEMENT_TYPE *ptr;
    int capacity, length;
} Heap;

typedef struct {
    int f, s;
} Meal;

Heap *heap_create(void) {
    Heap *h = malloc(sizeof *h);

    h->capacity = HEAP_INIT_CAPACITY, h->length = 0;
    h->ptr = calloc(h->capacity, sizeof *(h->ptr));

    return h;
}

void heap_release(Heap *h) {
    if (h != NULL) free(h->ptr);

    free(h);
}

int heap_is_empty(Heap *h) {
    return (h == NULL) || (h->length <= 0);
}

void heap_insert(Heap *h, HEAP_ELEMENT_TYPE v) {
    if (h == NULL) return;

    if (h->length >= h->capacity)
        h->ptr = realloc(
            h->ptr,
            (h->capacity *= 2) * sizeof *(h->ptr)
        );

    h->ptr[++h->length] = v;

    {
        int k = h->length;

        while (k > 1 && h->ptr[k].v > h->ptr[k / 2].v) {
            HEAP_ELEMENT_TYPE t = h->ptr[k];

            h->ptr[k] = h->ptr[k / 2];
            h->ptr[k / 2] = t;

            k /= 2;
        }
    }
}

HEAP_ELEMENT_TYPE heap_delete_root(Heap *h) {
    if (heap_is_empty(h)) return (HEAP_ELEMENT_TYPE) { .i = -1 };

    HEAP_ELEMENT_TYPE root = h->ptr[1];

    h->ptr[1] = h->ptr[h->length];
    h->ptr[h->length] = root;

    h->length--;

    int k = 1;

    while ((k * 2) <= h->length) {
        int j = k * 2;

        if (j < h->length && h->ptr[j].v < h->ptr[j + 1].v) j++;
        if (h->ptr[k].v >= h->ptr[j].v) break;

        HEAP_ELEMENT_TYPE t = h->ptr[k];

        h->ptr[k] = h->ptr[j];
        h->ptr[j] = t;

        k = j;
    }

    return root;
}

int main(void) {
    long long int n, m;

    scanf("%lld %lld", &n, &m);

    Meal *meals = malloc(n * sizeof *meals);

    for (int i = 0; i < n; i++) {
        long long int f, s;

        scanf("%lld %lld", &f, &s);

        meals[i].f = f, meals[i].s = s;   
    }

    // 매운맛의 최댓값을 구하기 위해 우선순위 큐를 사용한다.
    Heap *h = heap_create();

    long long int result = LLONG_MAX, total_flavor = 0LL;

    int low = 0, high = 0;

    while (high < n) {
        while (high < n && total_flavor < m) {
            // 우선순위 큐에 원소의 인덱스와 매운맛 지수를 저장한다.
            heap_insert(h, (Entry) { .i = high, .v = meals[high].s });

            total_flavor += meals[high].f, high++;
        }

        if (!heap_is_empty(h) && total_flavor >= m) {
            int t = h->ptr[1].v;

            if (result > t) result = t;
        }

        // 다음 슬라이딩 윈도우에 포함되지 않는 값은 모두 제거한다.
        while (!heap_is_empty(h) && h->ptr[1].i <= low)
            heap_delete_root(h);

        total_flavor -= meals[low].f, low++;
    }

    printf("%lld\n", result);

    heap_release(h), free(meals);

    return 0;
}