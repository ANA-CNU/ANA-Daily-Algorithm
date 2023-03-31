#include <stdio.h>
#include <stdlib.h>

#define GRAPH_INIT_CAPACITY 8

typedef struct {
    int v, w;
} Edge;

typedef struct {
    struct { Edge *ptr; int capacity, length; } *adjacency;
    int *visited, V;
} Graph;

Graph *graph_create(int V);
void graph_release(Graph *g);
void graph_add_edge(Graph *g, int u, int v, int w);
Edge graph_dfs(Graph *g, int u);

int main(void) {
    int n;

    scanf("%d", &n);
    
    Graph *g = graph_create(n + 1);

    for (int i = 0; i < n; i++) {
        int u;

        scanf("%d", &u);

        for (;;) {
            int v, w;

            scanf("%d", &v);

            if (v < 0) break;

            scanf("%d", &w);

            graph_add_edge(g, u, v, w);
        }
    }

    Edge src = graph_dfs(g, 1); 

    for (int i = 0; i < g->V; i++) g->visited[i] = 0;
    
    Edge dst = graph_dfs(g, src.v);

    printf("%d\n", dst.w);

    graph_release(g);

    return 0;
}

Graph *graph_create(int V) {
    Graph *g = malloc(sizeof(*g));

    g->adjacency = malloc(V * sizeof(*(g->adjacency)));
    g->visited = malloc(V * sizeof(*(g->visited)));
    g->V = V;

    for (int i = 0; i < V; i++) {
        g->adjacency[i].capacity = GRAPH_INIT_CAPACITY;
        g->adjacency[i].length = 0;
        
        g->adjacency[i].ptr = malloc(
            g->adjacency[i].capacity * sizeof(*(g->adjacency[i].ptr))
        );
    }

    return g;
}

void graph_release(Graph *g) {
    if (g == NULL) return;

    for (int i = 0; i < g->V; i++) free(g->adjacency[i].ptr);

    free(g->visited), free(g->adjacency), free(g);
}

void graph_add_edge(Graph *g, int u, int v, int w) {
    if (g == NULL) return;

    if (g->adjacency[u].length >= g->adjacency[u].capacity)
        g->adjacency[u].ptr = realloc(
            g->adjacency[u].ptr,
            (g->adjacency[u].capacity *= 2) * sizeof(*(g->adjacency[u].ptr))
        );

    g->adjacency[u].ptr[g->adjacency[u].length++] = (Edge) { v, w };

    if (g->adjacency[v].length >= g->adjacency[v].capacity)
        g->adjacency[v].ptr = realloc(
            g->adjacency[v].ptr,
            (g->adjacency[v].capacity *= 2) * sizeof(*(g->adjacency[v].ptr))
        );

    g->adjacency[v].ptr[g->adjacency[v].length++] = (Edge) { u, w };
}

Edge graph_dfs(Graph *g, int u) {
    if (g == NULL) return (Edge) { -1 };

    Edge result = { u, 0 };

    g->visited[u] = 1;

    for (int i = 0; i < g->adjacency[u].length; i++) {
        int v = g->adjacency[u].ptr[i].v;
        int w = g->adjacency[u].ptr[i].w;

        if (!g->visited[v]) {
            Edge e = graph_dfs(g, v);

            if (result.w < w + e.w)
                result.v = e.v, result.w = w + e.w;
        }
    }

    return result;
}