#include <stdio.h>
#include <stdlib.h>

#define GRAPH_INIT_CAPACITY 8

typedef struct {
    int u, v;
} Edge;

typedef struct {
    struct {
        int *ptr, capacity, length;
    } *adjacency;
    int *visited;
    int V;
} Graph;

Graph *graph_create(int V);
void graph_release(Graph *g);
void graph_add_edge(Graph *g, int u, int v);
void graph_dfs(Graph *g, int u, Edge e);

int main(void) {
    int p, c;

    for (;;) {
        scanf("%d %d", &p, &c);

        if (!p && !c) break;

        Graph *g = graph_create(p);

        Edge *edges = malloc(c * sizeof(*edges));

        for (int i = 0; i < c; i++) {
            int u, v;

            scanf("%d %d", &u, &v);

            graph_add_edge(g, u, v);

            edges[i].u = u, edges[i].v = v;
        }

        int valid = 1;

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < g->V; j++)
                g->visited[j] = 0;

            graph_dfs(g, 0, edges[i]);

            for (int j = 0; j < g->V; j++) 
                if (!g->visited[j]) {
                    valid = 0;

                    break;
                }
            
            if (!valid) break;
        }

        puts(!valid ? "Yes" : "No");

        graph_release(g), free(edges);
    }

    return 0;
}

Graph *graph_create(int V) {
    Graph *g = malloc(sizeof(*g));

    g->V = V, g->visited = calloc(V, sizeof(*(g->visited)));

    g->adjacency = malloc(V * sizeof(*(g->adjacency)));

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

    for (int i = 0; i < g->V; i++) 
        free(g->adjacency[i].ptr);

    free(g->adjacency), free(g->visited), free(g);
}

void graph_add_edge(Graph *g, int u, int v) {
    if (g == NULL) return;

    if (g->adjacency[u].length >= g->adjacency[u].capacity) {
        g->adjacency[u].capacity *= 2;

        g->adjacency[u].ptr = realloc(
            g->adjacency[u].ptr,
            g->adjacency[u].capacity * sizeof(*(g->adjacency[u].ptr))
        );
    }

    g->adjacency[u].ptr[g->adjacency[u].length++] = v;

    if (g->adjacency[v].length >= g->adjacency[v].capacity) {
        g->adjacency[v].capacity *= 2;

        g->adjacency[v].ptr = realloc(
            g->adjacency[v].ptr,
            g->adjacency[v].capacity * sizeof(*(g->adjacency[v].ptr))
        );
    }

    g->adjacency[v].ptr[g->adjacency[v].length++] = u;
}

void graph_dfs(Graph *g, int u, Edge e) {
    if (g == NULL) return;

    g->visited[u] = 1;

    for (int i = 0; i < g->adjacency[u].length; i++) {
        int v = g->adjacency[u].ptr[i];

        if (g->visited[v] || (e.u == u && e.v == v) || (e.u == v && e.v == u))
            continue; 
        
        graph_dfs(g, v, e);
    }
}