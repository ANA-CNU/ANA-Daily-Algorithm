#include <stdio.h>
#include <stdlib.h>

typedef struct { int *ptr, length; } Vector;

typedef struct { char **ptr, **visited; int n; } Graph;

Graph *graph_create(int n) {
    Graph *g = malloc(sizeof *g);

    g->n = n + 1;
    
    g->ptr = malloc(g->n * sizeof *(g->ptr));
    g->visited = malloc(g->n * sizeof *(g->visited));

    for (int i = 0; i < g->n; i++) {
        g->ptr[i] = malloc(g->n * sizeof **(g->ptr));
        g->visited[i] = calloc(g->n, sizeof **(g->visited));
    }

    return g;
}

void graph_release(Graph *g) {
    if (g == NULL) return;

    for (int i = 0; i < g->n; i++) 
        free(g->visited[i]), free(g->ptr[i]);

    free(g->visited), free(g->ptr), free(g);
}

void graph_dfs(Graph *g, Vector *prefs, int u, int v) {
    if (g == NULL) return;

    g->visited[u][v] = 1;

    for (int i = 0; i < prefs[v].length; i++) {
        int w = prefs[v].ptr[i];

        if (!g->visited[u][w]) graph_dfs(g, prefs, u, w);
    }
}

int main(void) {
    int n;

    scanf("%d", &n);

    Vector *prefs = malloc((n + 1) * sizeof *prefs);

    for (int i = 1; i <= n; i++) {
        prefs[i].ptr = malloc(n * sizeof *(prefs[i].ptr));
        prefs[i].length = 0;

        int value, ignore = 0;

        for (int j = 0; j < n; j++) {
            if (ignore) {
                scanf("%*d");

                continue;
            }

            scanf("%d", &value);

            prefs[i].ptr[prefs[i].length++] = value;

            // 지금 갖고 있는 선물보다 우선 순위가 낮은 선물은 확인하지 않는다.
            if (value == i) ignore = 1;
        }
    }

    Graph *g = graph_create(n);

    // 시작 정점에서 찜 목록에 있는 모든 정점에 대하여,
    // 두 정점을 잇는 사이클이 있는지 확인한다.
    for (int i = 1; i <= n; i++)
        graph_dfs(g, prefs, i, i);

    for (int i = 1; i <= n; i++)
		for (int j = 0; j < prefs[i].length; j++) {
            int w = prefs[i].ptr[j];

            // 찜 목록에 있는 선물 중에 
            // 우선 순위가 가장 높은 것을 선택한다.
            if (g->visited[w][i]) {
                printf("%d\n", w);

                break;
            }
        }

    graph_release(g);

    for (int i = 1; i <= n; i++) 
        free(prefs[i].ptr);

    free(prefs);

    return 0;
}