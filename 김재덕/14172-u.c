#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

#define GRAPH_INIT_CAPACITY 8

typedef struct {
    long long int x, y, d;
} Cow;

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
int graph_dfs(Graph *g, int u);

int main(void) {
    int n;

    scanf("%d", &n);

    Cow *cows = malloc(n * sizeof(*cows));

    for (int i = 0; i < n; i++)
        scanf("%lld %lld %lld", &cows[i].x, &cows[i].y, &cows[i].d);

    Graph *g = graph_create(n + 1);

    for (int src = 0; src < n; src++) {
        for (int dst = src + 1; dst < n; dst++) {
            long long int diff = (cows[dst].x - cows[src].x) * (cows[dst].x - cows[src].x) 
                + (cows[dst].y - cows[src].y) * (cows[dst].y - cows[src].y);

            if (cows[src].d * cows[src].d >= diff) graph_add_edge(g, src + 1, dst + 1, 0);
            if (cows[dst].d * cows[dst].d >= diff) graph_add_edge(g, dst + 1, src + 1, 0);
        }
    }

    int result = 1;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++)
            g->visited[j] = 0;

        int k = graph_dfs(g, i);

        if (result < k) result = k;
    }

    printf("%d\n", result);

    graph_release(g), free(cows);

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
}

int graph_dfs(Graph *g, int u) {
    if (g == NULL) return 0;

    g->visited[u] = 1;

    for (int i = 0; i < g->adjacency[u].length; i++) {
        int v = g->adjacency[u].ptr[i].v;

        if (!g->visited[v]) 
            g->visited[u] += graph_dfs(g, v);
    }

    return g->visited[u];
}