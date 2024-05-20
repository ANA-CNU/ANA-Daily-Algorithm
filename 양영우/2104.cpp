#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;




vector<long long> v(100001);
vector<long long> tree_sum(400004);
vector<long long> tree_idx(400004);
int n;





int min_idx(int left, int right) {
    if (left == -1) return right;
    if (right == -1) return left;
    if(v[left] < v[right]) return left;
    else{
        return right;
    }
}




long long init_idx(int node, int start, int end) {
    if (start == end) return tree_idx[node] = start;

    int mid = (start + end) / 2;

    int left = init_idx(node * 2, start, mid);
    int right = init_idx(node * 2 + 1, mid + 1, end);
    return tree_idx[node] = min_idx(left, right);

}




long long idx(int node, int start, int end, int left, int right) {

    if (left > end || right < start) return -1;
    if (left <= start && end <= right) return tree_idx[node];
    int mid = (start + end) / 2;
    return min_idx(idx(node * 2, start, mid, left, right), idx(node * 2 + 1, mid + 1, end, left, right));
}

long long init_sum(int node, int start, int end) {
    if (start == end) return tree_sum[node] = v[start];
    int mid = (start + end) / 2;
    return tree_sum[node] = init_sum(node * 2, start, mid) + init_sum(node * 2 + 1, mid + 1, end);
}



long long sum(int node, int start, int end, int left, int right) {


    if (left > end || right < start) return 0;
    if (left <= start && end <= right) return tree_sum[node];
    int mid = (start + end) / 2;
    return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
}



long long solve(int start, int end) {
    if (start > end) return 0;
    if (start == end) return v[start] * v[start];
    int index = idx(1, 1, n, start, end);
    long long res = v[index] * sum(1, 1, n, start, end);
    if (start < index) res = max(res, solve(start, index - 1));
    if (index < end) res = max(res, solve(index + 1, end));
    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> v[i];
    }


    init_idx(1, 1, n);
    init_sum(1, 1, n);

    cout << solve(1, n) << "\n";
}
