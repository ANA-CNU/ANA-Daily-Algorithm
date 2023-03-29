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
    int n;

    scanf("%d", &n);

    Graph *g = graph_create(n + 1);

    for (int i = 0; i < n - 1; i++) {
        int u, v;

        scanf("%d %d", &u, &v);

        // 간선 방향을 반대로 하여 깊이 우선 탐색
        graph_add_edge(g, v, u, 0);
    }

    int result = -1;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++)
            g->visited[j] = 0;

        graph_dfs(g, i);

        bool valid = true;

        for (int j = 1; j <= n; j++) {
            if (!g->visited[j]) {
                valid = false;

                break;
            }
        }
        
        if (valid) {
            result = i;

            break;
        }
    }

    printf("%d\n", result);

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
}

void graph_dfs(Graph *g, int u) {
    if (g == NULL) return;

    g->visited[u] = 1;

    for (int i = 0; i < g->adjacency[u].length; i++) {
        int v = g->adjacency[u].ptr[i].v;

        if (!g->visited[v]) graph_dfs(g, v);
    }
}