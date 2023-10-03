#include <iostream>
#include <algorithm>

#define INF 1000000001

using namespace std;

int N;
int arr[100001], seg[400001];

void init(int left, int right, int node) {
    if (left == right) {
        seg[node] = arr[left];
        return;
    }

    int mid = (left+right)/2;
    init(left, mid, node*2); init(mid+1, right, node*2+1);
    seg[node] = min(seg[node*2], seg[node*2+1]);
}

void update(int left, int right, int node, int i, int k) {
    if (left == i && i == right) {
        seg[node] = k;
        return;
    } else if (i < left || right < i) return;

    int mid = (left+right)/2;
    update(left, mid, node*2, i, k); update(mid+1, right, node*2+1, i, k);
    seg[node] = min(seg[node*2], seg[node*2+1]);
}

int getmin(int left, int right, int node, int u, int v) {
    if (u <= left && right <= v) return seg[node];
    else if (v < left || right < u) return INF;
    
    int mid = (left+right)/2;
    return min(getmin(left, mid, node*2, u, v), getmin(mid+1, right, node*2+1, u, v));
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    cin >> N;
    for (int i = 1; i < N+1; i++) {
        cin >> arr[i];
    }

    init(1, N, 1);

    int Q; cin >> Q;
    while (Q--) {
        int q, u, v; cin >> q >> u >> v;
        if (q == 1) {
            update(1, N, 1, u, v);
        } else {
            cout << getmin(1, N, 1, u, v) << '\n';
        }
    }
        
    return 0;
}