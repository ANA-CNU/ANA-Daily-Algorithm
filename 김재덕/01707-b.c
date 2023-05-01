#include <stdio.h>
#include <stdlib.h>

#define GRAPH_INIT_CAPACITY 8

typedef enum {
    COLOR_RED = 1,
    COLOR_BLUE
} Color;

typedef struct {
    struct {
        int *ptr, capacity, length;
    } *adjacency;
    int *visited, V;
} Graph;

Graph *graph_create(int V);
void graph_release(Graph *g);
void graph_add_edge(Graph *g, int u, int v);
int graph_dfs(Graph *g, int u, Color c);

/* `valgrind --tool=memcheck --leak-check=full --show-reachable=yes ./bin/main.out` */

int main(void) {
    int t;

    scanf("%d", &t);

    for (int i = 0; i < t; i++) {
        int V, E;

        scanf("%d %d", &V, &E);

        Graph *g = graph_create(V);

        for (int j = 0; j < E; j++) {
            int u, v;

            scanf("%d %d", &u, &v);

            graph_add_edge(g, u, v);
        }

        int result = 1;

        for (int i = 1; i <= V; i++)
            if (!g->visited[i] && !graph_dfs(g, i, COLOR_RED)) {
                result = 0;

                break;
            }

        puts(result ? "YES" : "NO");

        graph_release(g);
    }

    return 0;
}

Graph *graph_create(int V) {
    Graph *g = malloc(sizeof *g);

    g->V = V + 1, g->visited = calloc(g->V, sizeof *(g->visited));
    g->adjacency = malloc(g->V * sizeof *(g->adjacency));

    for (int i = 0; i < g->V; i++) {
        g->adjacency[i].capacity = GRAPH_INIT_CAPACITY;
        g->adjacency[i].length = 0;

        g->adjacency[i].ptr = malloc(
            g->adjacency[i].capacity * sizeof *(g->adjacency[i].ptr)
        );
    }

    return g;
}

void graph_release(Graph *g) {
    if (g == NULL) return;

    for (int i = 0; i < g->V; i++)
        free(g->adjacency[i].ptr);

    free(g->adjacency), free(g->visited), free(g);
}

void graph_add_edge(Graph *g, int u, int v) {
    if (g == NULL) return;

    if (g->adjacency[u].length >= g->adjacency[u].capacity)
        g->adjacency[u].ptr = realloc(
            g->adjacency[u].ptr,
            (g->adjacency[u].capacity *= 2) * sizeof *(g->adjacency[u].ptr)
        );

    if (g->adjacency[v].length >= g->adjacency[v].capacity)
        g->adjacency[v].ptr = realloc(
            g->adjacency[v].ptr,
            (g->adjacency[v].capacity *= 2) * sizeof *(g->adjacency[v].ptr)
        );

    g->adjacency[u].ptr[g->adjacency[u].length++] = v;
    g->adjacency[v].ptr[g->adjacency[v].length++] = u;
}

int graph_dfs(Graph *g, int u, Color c) {
    if (g == NULL) return 0;

    int result = 1;

    g->visited[u] = c;

    for (int i = 0; i < g->adjacency[u].length; i++) {
        int v = g->adjacency[u].ptr[i];

        if (g->visited[v] == c) {
            result = 0;

            break;
        } else if (g->visited[v]) continue;

        if (!graph_dfs(g, v, (c == COLOR_RED) ? COLOR_BLUE : COLOR_RED)) {
            result = 0;

            break;
        }
    }

    return result;
}