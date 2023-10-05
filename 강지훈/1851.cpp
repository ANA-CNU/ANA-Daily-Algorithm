#include <iostream>
#include <algorithm>
#include <map>
#include <queue>
 
using namespace std;
using edge = pair<int, int>;
using ll = long long;

int N, m0;
int arr[100000];
int pc[100000];
bool visited[100000] = {0};
queue<int> q;

void dfs(int cur) {
    if (visited[cur]) return;
    visited[cur] = 1;
    q.push(arr[cur]);
    dfs(pc[cur]);
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    cin >> N;
    int temp[100000];
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        temp[i] = arr[i];
    }

    sort(temp, temp+N);
    
    m0 = temp[0];
    
    map<int, int> mp;
    for (int i = 0; i < N; i++) mp.insert(make_pair(temp[i], i));
    for (int i = 0; i < N; i++) pc[i] = mp[arr[i]];
    
    int ans = 0;
    for (int i = 0; i < N; i++) {
        if (visited[i]) continue;
        dfs(i);

        if (q.size() == 1) {
            q.pop();
            continue;
        }

        int m = (1<<30);
        int size = q.size();
        ll sum1 = 0, sum2 = 0;
        while (!q.empty()) {
            m = min(m, q.front());
            sum1 += q.front();
            sum2 += q.front();
            q.pop();
        }
        sum1 += ((ll)size-2)*m;
        sum2 += m+((ll)size+1)*m0;
        ans += min(sum1, sum2);
    }

    cout << ans;
    
    return 0;
}