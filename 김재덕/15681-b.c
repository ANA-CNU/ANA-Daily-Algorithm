#include <stdio.h>
#include <stdlib.h>

#define GRAPH_INIT_CAPACITY 8

typedef struct {
    int v, w;
} Edge;

typedef struct {
    struct {
        Edge *ptr;
        int capacity, length;
    } *adjacency;
    int *visited;
    int V;
} Graph;

Graph *graph_create(int V);
void graph_release(Graph *g);
void graph_add_edge(Graph *g, int u, int v, int w);
void graph_dfs(Graph *g, int u);

/* `valgrind --tool=memcheck --leak-check=full --show-reachable=yes ./bin/main.out`  */

int main(void) {
    int n, r, q;
    
    scanf("%d %d %d", &n, &r, &q);

    Graph *g = graph_create(n);

    for (int i = 0; i < n - 1; i++) {
        int u, v;

        scanf("%d %d", &u, &v);

        graph_add_edge(g, u, v, -1);
    }

    graph_dfs(g, r);

    for (int i = 0; i < q; i++) {
        int u;

        scanf("%d", &u);

        printf("%d\n", g->visited[u]);
    }

    graph_release(g);

    return 0;
}

Graph *graph_create(int V) {
    Graph *g = malloc(sizeof *g);

    g->V = V + 1, g->adjacency = malloc(g->V * sizeof *(g->adjacency));

    for (int i = 0; i < g->V; i++) {
        g->adjacency[i].capacity = GRAPH_INIT_CAPACITY;
        g->adjacency[i].length = 0;

        g->adjacency[i].ptr = malloc(
            g->adjacency[i].capacity * sizeof *(g->adjacency[i].ptr)
        );
    }

    g->visited = calloc(g->V, sizeof *(g->visited));

    return g;
}

void graph_release(Graph *g) {
    for (int i = 0; i < g->V; i++)
        free(g->adjacency[i].ptr);

    free(g->visited), free(g->adjacency), free(g);
}

void graph_add_edge(Graph *g, int u, int v, int w) {
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

    g->adjacency[u].ptr[g->adjacency[u].length++] = (Edge) { v, w };
    g->adjacency[v].ptr[g->adjacency[v].length++] = (Edge) { u, w };
}

void graph_dfs(Graph *g, int u) {
    g->visited[u] = 1;

    for (int i = 0; i < g->adjacency[u].length; i++) {
        int v = g->adjacency[u].ptr[i].v;

        if (!g->visited[v]) {
            graph_dfs(g, v);

            g->visited[u] += g->visited[v];
        }
    }
}