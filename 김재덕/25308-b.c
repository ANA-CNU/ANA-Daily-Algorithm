#include <stdio.h>
#include <stdlib.h>

#define _USE_MATH_DEFINES
#include <math.h>

#define MAX_SPOKE_COUNT 8

typedef struct {
    double x, y;
} Vector2;

int vector2_ccw(Vector2 v1, Vector2 v2, Vector2 v3) {
    const double lhs = (v2.y - v1.y) * (v3.x - v1.x);
    const double rhs = (v3.y - v1.y) * (v2.x - v1.x);

    // `-1` if clockwise, `0` if collinear, `1` if counter-clockwise
    return (lhs > rhs) - (lhs < rhs);
}

static Vector2 points[MAX_SPOKE_COUNT];

void solve(
    int *values, int *visited, int *stack, int len,
    int *result, int k, int n
) {
    if (k == n) {
        int check = 1;

        for (int i = 0; i < MAX_SPOKE_COUNT; i++) {
            points[i].x = values[stack[i]] * cos(M_PI_4 * i);
            points[i].y = values[stack[i]] * sin(M_PI_4 * i);
        }

        for (int i = 0; i < MAX_SPOKE_COUNT; i++) {
            int low = i, high = (i + 2) % MAX_SPOKE_COUNT;
            int mid = (low + 1) % MAX_SPOKE_COUNT;

            if (vector2_ccw(points[low], points[mid], points[high]) > 0) {
                check = 0;

                break;
            }
        }

        if (check) (*result)++;
    } else {
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = 1;
            stack[len++] = i;

            solve(values, visited, stack, len, result, k + 1, n);

            visited[i] = 0;
            len--;
        }
    }
}

int main(void) {
    int values[8];

    for (int i = 0; i < MAX_SPOKE_COUNT; i++)
        scanf("%d", &values[i]);

    int *visited = calloc(MAX_SPOKE_COUNT, sizeof *visited);
    int *stack = malloc(MAX_SPOKE_COUNT * sizeof *stack);

    int len = 0, result = 0;

    solve(values, visited, stack, len, &result, 0, MAX_SPOKE_COUNT);

    printf("%d\n", result);
    
    free(stack), free(visited);

    return 0;
}