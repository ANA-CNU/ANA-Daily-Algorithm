#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct { int x, y; } Point;

typedef struct {
    int **ptr, **visited, width, height;
} Grid;

Grid *grid_create(int w, int h) {
    Grid *g = malloc(sizeof *g);

    g->width = w, g->height = h;
    
    g->ptr = malloc(h * sizeof *(g->ptr));
    g->visited = malloc(h * sizeof *(g->visited));

    for (int i = 0; i < h; i++) {
        g->ptr[i] = malloc(w * sizeof **(g->ptr));
        g->visited[i] = calloc(w, sizeof **(g->visited));
    }

    return g;
}

void grid_release(Grid *g) {
    if (g == NULL) return;

    for (int i = 0; i < g->height; i++) 
        free(g->visited[i]), free(g->ptr[i]);

    free(g->visited), free(g->ptr), free(g);
}

void grid_reset(Grid *g) {
    if (g == NULL) return;

    for (int y = 0; y < g->height; y++)
        for (int x = 0; x < g->width; x++)
            g->visited[y][x] = INT_MAX; 
}

void grid_dfs(
    Grid *g, Point p, int j, 
    const int x, const int y, const int k
) {
    if (g == NULL || g->visited[p.y][p.x] <= j) return;
    
    // 작업 횟수를 저장한다.
    g->visited[p.y][p.x] = j;

    // #1: 첫 번째 양동이를 가득 채운다.
    grid_dfs(g, (Point) { x, p.y }, j + 1, x, y, k);

    // #1: 두 번째 양동이를 가득 채운다.
    grid_dfs(g, (Point) { p.x, y }, j + 1, x, y, k);

    // #2: 첫 번째 양동이를 비운다.
    grid_dfs(g, (Point) { 0, p.y }, j + 1, x, y, k);

    // #2: 두 번째 양동이를 비운다.
    grid_dfs(g, (Point) { p.x, 0 }, j + 1, x, y, k);

    if (x < y) {
        const int qx = (p.x + p.y <= y) ? 0 : (p.x + p.y) - y;
        const int qy = (p.x + p.y <= y) ? (p.x + p.y) : y;

        // #3: 첫 번째 양동이에 들어 있는 우유를 두 번째 양동이에 붓는다.
        grid_dfs(g, (Point) { qx, qy }, j + 1, x, y, k);

        const int rx = (p.x + p.y <= x) ? (p.x + p.y) : x;
        const int ry = (p.x + p.y <= x) ? 0 : p.y - (x - p.x);

        // #3: 두 번째 양동이에 들어 있는 우유를 첫 번째 양동이에 붓는다.
        grid_dfs(g, (Point) { rx, ry }, j + 1, x, y, k); 
    } else {
        const int qx = (p.x + p.y <= y) ? 0 : p.x - (y - p.y);
        const int qy = (p.x + p.y <= y) ? (p.x + p.y) : y;

        // #3: 첫 번째 양동이에 들어 있는 우유를 두 번째 양동이에 붓는다.
        grid_dfs(g, (Point) { qx, qy }, j + 1, x, y, k);

        const int rx = (p.x + p.y <= x) ? (p.x + p.y) : x;
        const int ry = (p.x + p.y <= x) ? 0 : (p.x + p.y) - x;

        // #3: 두 번째 양동이에 들어 있는 우유를 첫 번째 양동이에 붓는다.
        grid_dfs(g, (Point) { rx, ry }, j + 1, x, y, k);
    }
}

int main(void) {
    int x, y, k, m;

    scanf("%d %d %d %d", &x, &y, &k, &m);

    Grid *g = grid_create(x + 1, y + 1);

    // 처음에는 각 양동이를 얼마만큼 채울 수 있을지 알 수 없음!
    grid_reset(g);

    grid_dfs(g, (Point) { 0 }, 0, x, y, k);

    int result = INT_MAX;

    for (int y = 0; y < g->height; y++)
        for (int x = 0; x < g->width; x++)
            if (g->visited[y][x] <= k) {
                const int diff = abs(m - (x + y));

                if (result > diff) result = diff;
            }

    printf("%d\n", result);

    grid_release(g);

    return 0;
}