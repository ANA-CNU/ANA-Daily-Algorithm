#include <iostream>
#include <vector>
using namespace std;
int n, m, result = 0;
vector<int> arr;
int find(int u){
    if (arr[u] == u) 
        return u;
    else 
        return arr[u] = find(arr[u]);
}
bool union_node(int u, int v){
    u = find(u);
    v = find(v);
    if (u == v) return true;
    else{
        arr[u] = v;
        return false;
    }
}
int main() {
    cin >> n >> m;
    arr.resize(n);
    for (int i = 0; i < n; i++) {
        arr[i] = i;
    }
    for (int i = 1; i <= m; i++){
        int u,v;
        cin >> u >> v;
        if (union_node(u, v)){
            result = i;
            break;
        }
    }
    cout << result;
    return 0;
}
