#include <stdio.h>
#include <stdlib.h>

#define HEAP_ELEMENT_TYPE   int
#define HEAP_INIT_CAPACITY  8

typedef struct {
    HEAP_ELEMENT_TYPE *ptr;
    int capacity, length;
} Heap;

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

void heap_insert_min(Heap *h, HEAP_ELEMENT_TYPE v) {
    if (h == NULL) return;

    if (h->length >= h->capacity)
        h->ptr = realloc(
            h->ptr,
            (h->capacity *= 2) * sizeof *(h->ptr)
        );

    h->ptr[++h->length] = v;

    {
        int k = h->length;

        while (k > 1 && h->ptr[k] < h->ptr[k / 2]) {
            HEAP_ELEMENT_TYPE t = h->ptr[k];

            h->ptr[k] = h->ptr[k / 2];
            h->ptr[k / 2] = t;

            k /= 2;
        }
    }
}

void heap_insert_max(Heap *h, HEAP_ELEMENT_TYPE v) {
    if (h == NULL) return;

    if (h->length >= h->capacity)
        h->ptr = realloc(
            h->ptr,
            (h->capacity *= 2) * sizeof *(h->ptr)
        );

    h->ptr[++h->length] = v;

    {
        int k = h->length;

        while (k > 1 && h->ptr[k] > h->ptr[k / 2]) {
            HEAP_ELEMENT_TYPE t = h->ptr[k];

            h->ptr[k] = h->ptr[k / 2];
            h->ptr[k / 2] = t;

            k /= 2;
        }
    }
}

HEAP_ELEMENT_TYPE heap_delete_min(Heap *h) {
    if (h == NULL) return (HEAP_ELEMENT_TYPE) -1;

    HEAP_ELEMENT_TYPE root = h->ptr[1];

    h->ptr[1] = h->ptr[h->length];
    h->ptr[h->length] = root;

    h->length--;

    int k = 1;

    while ((k * 2) <= h->length) {
        int j = k * 2;

        if (j < h->length && h->ptr[j] > h->ptr[j + 1]) j++;
        if (h->ptr[k] <= h->ptr[j]) break;

        HEAP_ELEMENT_TYPE t = h->ptr[k];

        h->ptr[k] = h->ptr[j];
        h->ptr[j] = t;

        k = j;
    }

    return root;
}

HEAP_ELEMENT_TYPE heap_delete_max(Heap *h) {
    if (h == NULL) return (HEAP_ELEMENT_TYPE) -1;

    HEAP_ELEMENT_TYPE root = h->ptr[1];

    h->ptr[1] = h->ptr[h->length];
    h->ptr[h->length] = root;

    h->length--;

    int k = 1;

    while ((k * 2) <= h->length) {
        int j = k * 2;

        if (j < h->length && h->ptr[j] < h->ptr[j + 1]) j++;
        if (h->ptr[k] >= h->ptr[j]) break;

        HEAP_ELEMENT_TYPE t = h->ptr[k];

        h->ptr[k] = h->ptr[j];
        h->ptr[j] = t;

        k = j;
    }

    return root;
}

int heap_is_empty(Heap *h) {
    return (h == NULL) || (h->length <= 0);
}

int main(void) {
    int n, med = -1;

    scanf("%d", &n);

    Heap *low = heap_create(), *high = heap_create();

    for (int i = 0; i < n; i++) {
        int value;

        scanf("%d", &value);

        if (i == 0) {
            med = value;
        } else {
            if (value > med) heap_insert_min(high, value);
            else if (value <= med) heap_insert_max(low, value);

            if (high->length > low->length + 1) {
                heap_insert_max(low, med);

                med = heap_delete_min(high);
            } else if (low->length > high->length) {
                heap_insert_min(high, med);

                med = heap_delete_max(low);
            }
        }

        printf("%d\n", med);
    }

    heap_release(high), heap_release(low);

    return 0;
}