#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

vector<vector<pair<int, int>>> v;
vector<int> result;
vector<bool> visited;
int n;
int farthest_node = 0;

void dfs(int start) {
    stack<int> stack;
    stack.push(start);
    visited[start] = true;

    while(!stack.empty()) {
        int cur = stack.top();
        stack.pop();

        for(int i = 0; i < v[cur].size(); i++) {
            int next = v[cur][i].first;
            int cost = v[cur][i].second;
            if(visited[next]) continue;
            result[next] = result[cur] + cost;
            stack.push(next);
            visited[next] = true;
            if(result[farthest_node] < result[next]) {
                farthest_node = next;
            }
        }
    }
}

int main() {
    cin>>n;
    v.resize(n+1);
    result.assign(n+1, 0);
    visited.assign(n+1, false);

    for(int i = 0; i < n; i++) {
        int a, b, c;
        cin>>a;
        while(true) {
            cin>>b;
            if(b == -1) break;
            cin>>c;
            v[a].push_back({b, c});
        }
    }

    dfs(1);

    result.assign(n+1, 0);
    visited.assign(n+1, false);

    dfs(farthest_node);

    cout<<*max_element(result.begin(), result.end());
}
