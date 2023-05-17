#include <math.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTEX_COUNT  3

typedef struct {
    int x, y;
} Vector2;

typedef struct { 
    Vector2 vertices[MAX_VERTEX_COUNT];
    int n;
} Polygon;

inline int vector2_ccw(Vector2 v1, Vector2 v2, Vector2 v3) {
    const int lhs = (v2.y - v1.y) * (v3.x - v1.x);
    const int rhs = (v3.y - v1.y) * (v2.x - v1.x);

    // NOTE: `-1` if clockwise, `0` if collinear, `1` if counter-clockwise
    return (lhs > rhs) - (lhs < rhs);
}

int point_in_triangle(Polygon *s, Vector2 p) {
    if (s == NULL || s->n != 3) return 0;

    return (vector2_ccw(s->vertices[0], p, s->vertices[1]) <= 0)
        && (vector2_ccw(s->vertices[1], p, s->vertices[2]) <= 0)
        && (vector2_ccw(s->vertices[2], p, s->vertices[0]) <= 0);
}

int main(void) {
    Polygon s = { .n = 3 };

    for (int i = 0; i < s.n; i++)
        scanf("%d %d", &s.vertices[i].x, &s.vertices[i].y);

    if (vector2_ccw(s.vertices[0], s.vertices[1], s.vertices[2]) < 0) {
        Vector2 tmp = s.vertices[1];

        s.vertices[1] = s.vertices[2];
        s.vertices[2] = tmp;
    }

    double area = fabs(
        s.vertices[0].x * (s.vertices[1].y - s.vertices[2].y)
        + s.vertices[1].x * (s.vertices[2].y - s.vertices[0].y)
        + s.vertices[2].x * (s.vertices[0].y - s.vertices[1].y)
    ) * 0.5;

    int k, count = 0;

    scanf("%d", &k);

    for (int i = 0; i < k; i++) {
        int x, y;

        scanf("%d %d", &x, &y);

        if (point_in_triangle(&s, (Vector2) { x, y })) count++;
    }

    printf("%.1f\n%d\n", area, count);

    return 0;
}