#include <iostream>
using namespace std;

int pc[101][101];
int visit[101];

void dfs(int pc[][101], int n, int startNode, int* visit) {
    int i = 1;
    visit[startNode] = 1;

    for (i = 1; i <= n; i++) {
        if (i != startNode)
            if (pc[startNode][i] !=0 || pc[i][startNode] !=0 )
                if (visit[i] == 0)
                    dfs(pc, n, i, visit);
    }
}

int main() {
    int n, k, a, b;
    cin >> n >> k;
    
    while (k-- > 0) {
        cin >> a >> b;
        pc[a][b] = 1;
    }

    dfs(pc, n, 1, visit);
    
    int cnt = 0;

    for (int i = 2; i <= n; i++)
        if (visit[i] != 0)
            cnt++;
    
    cout << cnt;
}