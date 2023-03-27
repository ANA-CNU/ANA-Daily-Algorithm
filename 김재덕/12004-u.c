#include <stdbool.h>
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

int main(void) {
    int n, m;

    scanf("%d %d", &n, &m);

    Graph *g = graph_create(n + 1);

    for (int i = 0; i < m; i++) {
        int u, v;

        scanf("%d %d", &u, &v);

        graph_add_edge(g, u, v, 0);
    }

    for (int i = 0; i < n; i++) {
        int z;

        scanf("%d", &z);

        for (int j = 1; j <= n; j++)
            if (g->visited[j] != 2)
                g->visited[j] = 0;

        int k = 1;

        while (k < n && g->visited[k] == 2) k++;

        graph_dfs(g, k);

        bool valid = true;
        
        for (int j = 1; j <= n; j++)
            if (!g->visited[j]) {
                valid = false;

                break;
            }

        puts(valid ? "YES" : "NO");

        g->visited[z] = 2, g->adjacency[z].length = 0;
    }

    graph_release(g);

    return 0;
}

Graph *graph_create(int V) {
    Graph *g = malloc(sizeof(*g));

    g->V = V;

    g->visited = calloc(V, sizeof(*(g->visited)));
    g->adjacency = malloc(V * sizeof(*(g->adjacency)));

    for (int i = 0; i < V; i++) {
        g->adjacency[i].capacity = GRAPH_INIT_CAPACITY; 
        g->adjacency[i].length = 0;

        g->adjacency[i].ptr = malloc(
            GRAPH_INIT_CAPACITY * sizeof(*(g->adjacency[i].ptr))
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

void graph_add_edge(Graph *g, int u, int v, int w) {
    if (g == NULL) return;

    if (g->adjacency[u].length >= g->adjacency[u].capacity) {
        g->adjacency[u].ptr = realloc(
            g->adjacency[u].ptr,
            2 * (g->adjacency[u].capacity) * sizeof(*(g->adjacency[u].ptr))
        );

        g->adjacency[u].capacity *= 2;
    }

    g->adjacency[u].ptr[g->adjacency[u].length++] = (Edge) { v, w };

    if (g->adjacency[v].length >= g->adjacency[v].capacity) {
        g->adjacency[v].ptr = realloc(
            g->adjacency[v].ptr,
            2 * (g->adjacency[v].capacity) * sizeof(*(g->adjacency[v].ptr))
        );

        g->adjacency[v].capacity *= 2;
    }

    g->adjacency[v].ptr[g->adjacency[v].length++] = (Edge) { u, w };
}

void graph_dfs(Graph *g, int u) {
    if (g == NULL) return;

    g->visited[u] = 1;

    for (int i = 0; i < g->adjacency[u].length; i++) {
        int v = g->adjacency[u].ptr[i].v;

        if (v > 0 && !g->visited[v]) graph_dfs(g, v);
    }
}