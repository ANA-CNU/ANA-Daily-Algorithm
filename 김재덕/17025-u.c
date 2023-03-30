#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int a, p;
} Blob;

void dfs(char **grid, bool **visited, Blob *b, int n, int x, int y);

int main(void) {
    int n;

    scanf("%d", &n);

    char **grid = malloc(n * sizeof(*grid));
    bool **visited = malloc(n * sizeof(*visited));

    for (int i = 0; i < n; i++) {
        grid[i] = malloc(n * sizeof(**grid));
        visited[i] = calloc(n, sizeof(**visited));
    }

    for (int y = 0; y < n; y++)
        for (int x = 0; x < n; x++)
            scanf(" %c", &grid[y][x]);

    Blob result = { .a = -1, .p = INT_MAX }, b = { .a = 0 };

    for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
            if (grid[y][x] == '#' && !visited[y][x])
                b.a = b.p = 0;

            dfs(grid, visited, &b, n, x, y);

            if (result.a < b.a) result = b;
            if ((result.a == b.a) && (result.p > b.p)) result.p = b.p;
        }
    }

    printf("%d %d\n", result.a, result.p);

    for (int i = 0; i < n; i++) free(visited[i]), free(grid[i]);

    free(visited), free(grid);

    return 0;
}

void dfs(char **grid, bool **visited, Blob *b, int n, int x, int y) {
    if (grid == NULL || visited == NULL 
        || grid[y][x] == '.' || visited[y][x]) return;

    b->a++;

    visited[y][x] = true;

    static const int dx[] = { 1, 0, -1, 0 };
    static const int dy[] = { 0, -1, 0, 1 };

    for (int i = 0; i < 4; i++) {
        int kx = x + dx[i], ky = y + dy[i];

        if (kx < 0 || kx > n - 1 || ky < 0 || ky > n - 1) b->p++;
        else b->p += (grid[ky][kx] == '.');
    }

    for (int i = 0; i < 4; i++) {
        int kx = x + dx[i], ky = y + dy[i];

        if (kx < 0 || kx > n - 1 
            || ky < 0 || ky > n - 1) continue;

        dfs(grid, visited, b, n, kx, ky);
    }
}