#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

vector<long long> v(100001);
vector<long long> min_tree(400004);
vector<long long> max_tree(400004);




long long init_min(int node, int start, int end) {
    if (start == end) {
        return min_tree[node] = v[start];
    }
    int mid = (start + end) / 2;
    return min_tree[node] = min(init_min(node*2, start, mid), init_min(node*2+1, mid+1, end));
}





long long init_max(int node, int start, int end) {
    if (start == end) {
        return max_tree[node] = v[start];
    }
    int mid = (start + end) / 2;
    return max_tree[node] = max(init_max(node*2, start, mid), init_max(node*2+1, mid+1, end));
}


long long find_min(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return LLONG_MAX;
    if (left <= start && end <= right) return min_tree[node];
    int mid = (start + end) / 2;
    return min(find_min(node*2, start, mid, left, right), find_min(node*2+1, mid+1, end, left, right));
}


long long find_max(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return 0;
    if (left <= start && end <= right) return max_tree[node];
    int mid = (start + end) / 2;
    return max(find_max(node*2, start, mid, left, right), find_max(node*2+1, mid+1, end, left, right));
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m;
    cin >> n >> m;


    for (int i = 1; i <= n; i++) {
        cin>>v[i];
    }

    init_min(1, 1, n);
    init_max(1, 1, n);

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        cout << find_min(1, 1, n, a, b) << " " << find_max(1, 1, n, a, b) << endl;
    }

}
