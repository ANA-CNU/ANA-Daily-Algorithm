#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x, y;
} Point;

typedef struct {
    Point *ptr;
    int length;
} Stack;

void dfs(
    int **grid, bool **visited, int m, int n, 
    int x, int y, int d
);

bool possible(
    int **grid, bool **waypoints, bool **visited, 
    int m, int n, int d
);

int main(void) {
    int m, n;

    scanf("%d %d", &m, &n);

    int **grid = malloc(m * sizeof(*grid));
    bool **waypoints = malloc(m * sizeof(*waypoints));
    bool **visited = malloc(m * sizeof(*visited));

    for (int i = 0; i < m; i++) {
        grid[i] = malloc(n * sizeof(**grid));
        waypoints[i] = calloc(n, sizeof(**waypoints));
        visited[i] = calloc(n, sizeof(**visited));
    }

    int low = INT_MAX, high = INT_MIN;

    for (int y = 0; y < m; y++)
        for (int x = 0; x < n; x++) {
            scanf("%d", &grid[y][x]);

            if (low > grid[y][x]) low = grid[y][x];
            if (high < grid[y][x]) high = grid[y][x];
        }

    for (int y = 0; y < m; y++)
        for (int x = 0; x < n; x++) {
            int value;

            scanf("%d", &value);

            waypoints[y][x] = value;
        }

    high = (high - low), low = 0;

    while (low < high) {
        int mid = low + (high - low) / 2;

        if (possible(grid, waypoints, visited, m, n, mid)) high = mid;
        else low = mid + 1;
    }

    printf("%d\n", low);

    for (int i = 0; i < m; i++) 
        free(visited[i]), free(waypoints[i]), free(grid[i]);

    free(visited), free(waypoints), free(grid);

    return 0;
}

void dfs(
    int **grid, bool **visited, int m, int n, 
    int x, int y, int d
) {
    if (grid == NULL || visited == NULL || visited[y][x]) return;

    static const int dx[] = { 1, 0, -1, 0 };
    static const int dy[] = { 0, -1, 0, 1 };

    Stack s = { .ptr = malloc((m * n) * sizeof(*(s.ptr))) };

    s.ptr[s.length++] = (Point) { x, y };

    while (s.length > 0) {
        Point p = s.ptr[--s.length];

        visited[p.y][p.x] = true;

        for (int i = 0; i < 4; i++) {
            int kx = p.x + dx[i], ky = p.y + dy[i];

            if (kx < 0 || kx > n - 1 
                || ky < 0 || ky > m - 1) continue;

            if (visited[ky][kx] || abs(grid[ky][kx] - grid[p.y][p.x]) > d) continue;

            s.ptr[s.length++] = (Point) { kx, ky };
        }
    }

    free(s.ptr);
}

bool possible(
    int **grid, bool **waypoints, bool **visited, 
    int m, int n, int d
) {
    if (grid == NULL || waypoints == NULL || visited == NULL)
        return false;

    for (int y = 0; y < m; y++)
        for (int x = 0; x < n; x++)
            visited[y][x] = false;

    bool marked = false;

    for (int y = 0; y < m; y++) {
        for (int x = 0; x < n; x++) {
            if (waypoints[y][x]) {
                dfs(grid, visited, m, n, x, y, d);

                marked = true;

                break;
            }
        }

        if (marked) break;
    }

    bool valid = true;

    for (int y = 0; y < m; y++) {
        for (int x = 0; x < n; x++)
            if (waypoints[y][x] && !visited[y][x]) {
                valid = false;

                break;
            }

        if (!valid) break;
    }

    return valid;
}