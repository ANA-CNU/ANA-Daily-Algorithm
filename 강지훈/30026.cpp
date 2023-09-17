#include <iostream>
#include <algorithm>
#include <vector>
 
using namespace std;
 
int arr[200001];
int rev[200001];
int visited[200001] = {0};
int sz = 0;
 
void dfs(int i, int n) {
    if (visited[i] == n) return;
    visited[i] = n;
    dfs(arr[i], n);
}
 
int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);
 
    int N; cin >> N;
    for (int i = 1; i < N+1; i++) {
        cin >> arr[i];
        rev[arr[i]] = i;
    }
 
    for (int i = 1; i < N+1; i++) {
        if (visited[i] == 0) {
            dfs(i, ++sz);
        }
    }
 
    cout << sz-1 << ' ' << sz-1 << '\n';
 
    for (int i = 1; i < N; i++) {
        int l = visited[rev[i]], r = visited[rev[i+1]];
        if (l == r) continue;
        cout << rev[i] << ' ' << rev[i+1] << '\n';
 
        dfs(rev[i+1], visited[rev[i]]);
        int temp = rev[i];
        arr[rev[i]] = i+1; arr[rev[i+1]] = i;
        rev[i] = rev[i+1]; rev[i+1] = temp;
    }
 
    return 0;
}