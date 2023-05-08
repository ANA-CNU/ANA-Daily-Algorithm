#include <stdio.h>
#include <stdlib.h>

// `x`와 `y`의 범위는 0 ~ 20이므로, `x`값과 `y`값을 각각 순서 관계없이 2개 선택!  
#define MAX_PCL_COUNT 44100

typedef struct { int x, y; } Point;
typedef struct { int x0, y0, x1, y1; } PCL;
typedef struct { char **ptr, **visited; int n; } Grid;

static const int DELTA_X[4] = { 0, 1, 0, -1 }, DELTA_Y[4] = { 1, 0, -1, 0 };

Grid *grid_create(int n) {
    Grid *g = malloc(sizeof *g);

    g->n = n + 1;
    
    g->ptr = malloc(g->n * sizeof *(g->ptr));
    g->visited = malloc(g->n * sizeof *(g->visited));

    for (int i = 0; i < g->n; i++) {
        g->ptr[i] = malloc(g->n * sizeof **(g->ptr));
        g->visited[i] = malloc(g->n * sizeof **(g->visited));
    }

    return g;
}

void grid_release(Grid *g) {
    if (g == NULL) return;

    for (int i = 0; i < g->n; i++) 
        free(g->visited[i]), free(g->ptr[i]);

    free(g->visited), free(g->ptr), free(g);
}

void grid_reset(Grid *g) {
    if (g == NULL) return;

    for (int y = 0; y < g->n; y++)
        for (int x = 0; x < g->n; x++)
            g->visited[y][x] = 0; 
}

void grid_dfs(Grid *g, const PCL *pcl, Point p, char c) {
    if (g == NULL) return;

    g->visited[p.y][p.x] = 1;

    for (int i = 0; i < 4; i++) {
        const Point q = { p.x + DELTA_X[i], p.y + DELTA_Y[i] };

        if (q.x < pcl->x0 || q.x > pcl->x1 || q.y < pcl->y0 || q.y > pcl->y1)
            continue;

        if (g->ptr[q.y][q.x] == c && !g->visited[q.y][q.x]) 
            grid_dfs(g, pcl, q, c);
    }
}

int is_valid(Grid *g, const PCL *pcl) {
    if (g == NULL || pcl == NULL) return 0;

    grid_reset(g);

    int region_table[26] = { 0 };

	for (int y = pcl->y0; y <= pcl->y1; y++) {
		for (int x = pcl->x0; x <= pcl->x1; x++) {
			if (g->visited[y][x]) continue;

			region_table[g->ptr[y][x] - 'A']++;

			grid_dfs(g, pcl, (Point) { x, y }, g->ptr[y][x]);
		}
	}

	int color_count = 0, region_one = 0, region_multi = 0;

	for (int i = 0; i < 26; i++) {
        if (!region_table[i]) continue;

		if (region_table[i] == 1) region_one = 1;
		else region_multi = 1;

        color_count++;
	}

	return (color_count == 2) && (region_one && region_multi);
}

int main(void) {
    int n;

    scanf("%d", &n);

    Grid *g = grid_create(n);

    for (int y = 0; y < n; y++)
        for (int x = 0; x < n; x++)
            scanf(" %c", &g->ptr[y][x]);

    PCL *pcls = malloc(MAX_PCL_COUNT * sizeof *pcls);

    int pcl_count = 0, result = 0;

    for (int y0 = 0; y0 < n; y0++)
        for (int x0 = 0; x0 < n; x0++)
            for (int y1 = 0; y1 < n; y1++)
                for (int x1 = 0; x1 < n; x1++) {
                    const PCL pcl = { x0, y0, x1, y1 };

                    if (!is_valid(g, &pcl)) continue;

                    pcls[pcl_count++] = pcl;
                }

    for (int i = 0; i < pcl_count; i++) {
        int check = 1;

        for (int j = 0; j < pcl_count; j++) {
            if (i == j) continue;

            if (pcls[i].x0 >= pcls[j].x0 && pcls[i].x1 <= pcls[j].x1
                && pcls[i].y0 >= pcls[j].y0 && pcls[i].y1 <= pcls[j].y1) {
                check = 0;

                break;
            }
        }
        
        result += check;
    }

    printf("%d\n", result);

    free(pcls), grid_release(g);

    return 0;
}