#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int s, t;
} Lecture;

typedef struct { Lecture *ptr; int length; } Heap;

Heap *heap_create(int n);
void heap_release(Heap *h);
void heap_insert(Heap *h, Lecture l);
Lecture heap_delete_root(Heap *h);

int compare_lectures(const void *x, const void *y) {
    Lecture *l = (Lecture *) x, *m = (Lecture *) y;

    return (l->s > m->s) - (l->s < m->s);
}

int main(void) {
    int n;
    
    scanf("%d", &n);

    Lecture *lectures = malloc(n * sizeof(*lectures));

    for (int i = 0; i < n; i++)
        scanf("%d %d", &lectures[i].s, &lectures[i].t);

    qsort(lectures, n, sizeof *lectures, compare_lectures);

    Heap *h = heap_create(n);

    for (int i = 0; i < n; i++) {
        if (h->length == 0 || lectures[i].s < h->ptr[1].t) {
            heap_insert(h, lectures[i]);
        } else {
            Lecture l = heap_delete_root(h);

            heap_insert(h, (Lecture) { l.s, lectures[i].t });
        }
    }

    printf("%d\n", h->length);

    heap_release(h), free(lectures);

    return 0;
}

Heap *heap_create(int n) {
    Heap *h = malloc(sizeof *h);

    h->length = 0, h->ptr = calloc(n + 1, sizeof *(h->ptr));

    return h;
}

void heap_release(Heap *h) {
    if (h == NULL) return;

    free(h->ptr), free(h);
}

void heap_insert(Heap *h, Lecture l) {
    if (h == NULL) return;

    h->ptr[++h->length] = l;

    int k = h->length;

    while (h->ptr[k].t < h->ptr[k / 2].t) {
        Lecture t = h->ptr[k];

        h->ptr[k] = h->ptr[k / 2];
        h->ptr[k / 2] = t;

        k /= 2;
    }
}

Lecture heap_delete_root(Heap *h) {
    if (h == NULL || h->length == 0) return (Lecture) { -1, -1 };

    Lecture root = h->ptr[1];

    h->ptr[1] = h->ptr[h->length];
    h->ptr[h->length] = root;

    h->length--;

    int k = 1;

    while ((k << 1) <= h->length) {
        int j = k << 1;

        if (j < h->length && h->ptr[j].t > h->ptr[j + 1].t) j++;
        if (h->ptr[k].t <= h->ptr[j].t) break;

        Lecture t = h->ptr[k];

        h->ptr[k] = h->ptr[j];
        h->ptr[j] = t;

        k = j;
    }

    return root;
}