#include <stdio.h>
#include <stdlib.h>

#define SCREEN_WIDTH   6
#define SCREEN_HEIGHT  12

#define PIECE_COUNT    5

typedef struct { int x, y; } Point;

typedef struct {
    char **ptr, **visited;
    int width, height;
} Grid;

static const int DELTA_X[4] = { 0, 1, 0, -1 }, DELTA_Y[4] = { 1, 0, -1, 0 };

Grid *grid_create(int w, int h) {
    Grid *g = malloc(sizeof *g);

    g->width = w, g->height = h;
    
    g->ptr = malloc(h * sizeof *(g->ptr));
    g->visited = malloc(h * sizeof *(g->visited));

    for (int i = 0; i < h; i++) {
        g->ptr[i] = malloc(w * sizeof **(g->ptr));
        g->visited[i] = malloc(w * sizeof **(g->visited));
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
            g->visited[y][x] = 0; 
}

int grid_dfs(Grid *g, Point p, char c) {
    if (g == NULL || g->ptr[p.y][p.x] != c
        || g->visited[p.y][p.x] == c) return 0;

    int result = 1;

    g->visited[p.y][p.x] = c;

    for (int i = 0; i < 4; i++) {
        const Point q = { p.x + DELTA_X[i], p.y + DELTA_Y[i] };

        if (q.x < 0 || q.x >= g->width || q.y < 0 || q.y >= g->height)
            continue;

        if (g->ptr[q.y][q.x] == c && !g->visited[q.y][q.x]) 
            result += grid_dfs(g, q, c);
    }

    return result;
}

int main(void) {
    Grid *g = grid_create(SCREEN_WIDTH, SCREEN_HEIGHT);

    for (int y = 0; y < SCREEN_HEIGHT; y++)
        for (int x = 0; x < SCREEN_WIDTH; x++)
            scanf(" %c", &g->ptr[y][x]);

    const char pieces[PIECE_COUNT] = { 'R', 'G', 'B', 'P', 'Y' };

    int chain_count = 0, sum = 0;

    for (;;) {
        for (int i = 0; i < PIECE_COUNT; i++)
            for (int y = 0; y < SCREEN_HEIGHT; y++)
                for (int x = 0; x < SCREEN_WIDTH; x++) {
                    int k = grid_dfs(g, (Point) { x, y }, pieces[i]);

                    if (k < 4) {
                        grid_reset(g);

                        continue;
                    }

                    sum += k;

                    for (int py = 0; py < SCREEN_HEIGHT; py++)
                        for (int px = 0; px < SCREEN_WIDTH; px++)
                            if (g->ptr[py][px] == pieces[i] && g->visited[py][px])
                                g->ptr[py][px] = '.', g->visited[py][px] = 0;
                }

        if (sum <= 0) break; 

        chain_count++;

        for (;;) {
            int should_update = 0;

            for (int y = 0; y < SCREEN_HEIGHT - 1; y++)
                for (int x = 0; x < SCREEN_WIDTH; x++)
                    if (g->ptr[y][x] != '.' && g->ptr[y + 1][x] == '.') {
                        g->ptr[y + 1][x] = g->ptr[y][x], g->ptr[y][x] = '.';

                        should_update = 1;
                    }

            if (!should_update) break;
        }

        sum = 0;
    }

    printf("%d\n", chain_count);

    grid_release(g);

    return 0;
}