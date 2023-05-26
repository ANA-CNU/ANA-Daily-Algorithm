#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTEX_COUNT  10001

#ifndef RAYLIB_H
typedef struct { long long int x, y; } Vector2;
#endif

typedef struct { 
    Vector2 vertices[MAX_VERTEX_COUNT];
    int n;
} Polygon;

inline Vector2 vector2_add(Vector2 v1, Vector2 v2) {
    return (Vector2) { v1.x + v2.x, v1.y + v2.y };
}

inline Vector2 vector2_subtract(Vector2 v1, Vector2 v2) {
    return (Vector2) { v1.x - v2.x, v1.y - v2.y };
}

inline Vector2 vector2_scalar_multiply(Vector2 v, long long int s) {
    return (Vector2) { v.x * s, v.y * s };
}

inline long long int vector2_cross(Vector2 v1, Vector2 v2) {
    return (v1.x * v2.y) - (v1.y * v2.x);
}

inline long long int vector2_dot(Vector2 v1, Vector2 v2) {
    return (v1.x * v2.x) + (v1.y * v2.y);
}

inline long long int vector2_distance_sq(Vector2 v1, Vector2 v2) {
    const Vector2 v = vector2_subtract(v1, v2);

    return vector2_dot(v, v);
}

inline long long int vector2_ccw(Vector2 v1, Vector2 v2, Vector2 v3) {
    const long long int lhs = (v3.y - v1.y) * (v2.x - v1.x);
    const long long int rhs = (v2.y - v1.y) * (v3.x - v1.x);

    return (lhs > rhs) - (lhs < rhs);
}

int point_in_convex(Polygon *s, Vector2 p) {
    if (s == NULL || s->n < 3) return 0;

    const long long int c1 = vector2_ccw(s->vertices[0], p, s->vertices[1]);
    const long long int c2 = vector2_ccw(s->vertices[0], p, s->vertices[s->n - 1]);

    if (c1 > 0 || c2 < 0) return 0;

    int low = 0, high = s->n - 1;

    while (high - low > 1) {
        const int mid = low + (high - low) / 2;

        if (vector2_ccw(s->vertices[0], p, s->vertices[mid]) > 0.0) high = mid;
        else low = mid;
    }

    const long long int r1 = vector2_ccw(s->vertices[0], p, s->vertices[low]);
    const long long int r2 = vector2_ccw(s->vertices[low], p, s->vertices[low + 1]);
    const long long int r3 = vector2_ccw(s->vertices[low + 1], p, s->vertices[0]);

    if ((!r1 && !r2) || (!r1 && !r3) || (!r2 && !r3)) return -1;

    if ((low == 1 && !r1 && (r2 * r3 >= 0))
        || (low + 1 == s->n - 1 && !r3 && (r1 * r2 >= 0))
        || (!r2 && (r1 * r3 >= 0))) return -1;

    return (r1 <= 0 && r2 <= 0 && r3 <= 0);
}

int main(void) {
    int n, m, k;

    scanf("%d %d %d", &n, &m, &k);

    Polygon s1 = { .n = n }, s2 = { .n = m };

    for (int i = 0; i < n; i++) 
        scanf("%lld %lld", &s1.vertices[i].x, &s1.vertices[i].y);
    
    for (int i = 0; i < m; i++) 
        scanf("%lld %lld", &s2.vertices[i].x, &s2.vertices[i].y);

    int r = 0;

    for (int i = 0; i < k; i++) {
        Vector2 v;

        scanf("%lld %lld", &v.x, &v.y);

        if (!point_in_convex(&s1, v) || point_in_convex(&s2, v)) r++;
    }

    printf((r == 0) ? "YES\n" : "%d\n", r);

    return 0;
}