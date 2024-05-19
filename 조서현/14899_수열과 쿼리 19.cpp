#pragma GCC optimize ("O3")
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#include<bits/stdc++.h>

// #include <algorithm>
// #include <iostream>
// #include <stdlib.h>

using namespace std;

typedef long long ll;

constexpr ll MAX = 9223372036854775807LL;

struct node
{
	ll range_min, range_sum, range_max;
};

inline ll floor(ll a, ll b) {
	return (ll)floor(static_cast<long double>(a) / static_cast<long double>(b));
}

inline node combine(node a, node b) {
	return { min(a.range_min, b.range_min), a.range_sum + b.range_sum, max(a.range_max, b.range_max) };
}

int arr[100000];
ll lazy[262144];
ll lazy2[262144];
node tree[262144];

node init(int left, int right, int i) {
	if (left == right) {
		return tree[i] = { arr[left], arr[left], arr[left] };
	}
	int mid = (left + right) >> 1;
	return tree[i] = combine(init(left, mid, i << 1), init(mid + 1, right, i << 1 | 1));
}

void propagate_lazy(int start, int end, int i) {
	if (lazy2[i] <= -MAX){
		tree[i].range_max += lazy[i];
		tree[i].range_min += lazy[i];
		tree[i].range_sum += (end - start + 1) * lazy[i];
		if (start != end){
			lazy[i << 1] += lazy[i];
			lazy[i << 1 | 1] += lazy[i];
		}
	} else {
		tree[i].range_max = lazy[i] + lazy2[i];
		tree[i].range_min = lazy[i] + lazy2[i];
		tree[i].range_sum = (end - start + 1) * (lazy[i] + lazy2[i]);
		if (start != end){
			lazy[i << 1] = lazy[i];
			lazy[i << 1 | 1] = lazy[i];
			lazy2[i << 1] = lazy2[i];
			lazy2[i << 1 | 1] = lazy2[i];
		}
	}
	lazy[i] = 0; lazy2[i] = -MAX;
}

ll search_range(int start, int end, int left, int right, int mode, int i = 1) {
	propagate_lazy(start, end, i);
	if (end < left || start > right)
		return mode == 3 ? MAX : 0;
	if (left <= start && end <= right)
		return (mode == 3 ? tree[i].range_min : tree[i].range_sum);
	int mid = (start + end) / 2;
	ll left_seg = search_range(start, mid, left, right, mode, i << 1), right_seg = search_range(mid + 1, end, left, right, mode, i << 1 | 1);
	return mode == 3 ? min(left_seg, right_seg) : left_seg + right_seg;
}

void add_range(int start, int end, int left, int right, int val, int i = 1) {
	propagate_lazy(start, end, i);
	// break condition
	if (end < left || start > right)
		return;
	// tag condition
	if (left <= start && end <= right) {
		// tag
		lazy[i] = val;
		propagate_lazy(start, end, i);
		return;
	}
	int mid = (start + end) / 2;
	add_range(start, mid, left, right, val, i << 1);
	add_range(mid + 1, end, left, right, val, i << 1 | 1);
	tree[i] = combine(tree[i << 1], tree[i << 1 | 1]);
	return;
}

void div_range(int start, int end, int left, int right, int val, int i = 1) {
	propagate_lazy(start, end, i);
	// break condition
	if (end < left || start > right)
		return;
	// tag condition
	if (left <= start && end <= right) {
		int floor_min = floor(tree[i].range_min, val);
		if (floor_min == floor(tree[i].range_max, val)){
			lazy2[i] = floor_min;
			propagate_lazy(start, end, i);
			return;
		}
		if (tree[i].range_min + 1 == tree[i].range_max){
			lazy[i] = floor_min - tree[i].range_min;
			propagate_lazy(start, end, i);
			return;
		}
	}
	int mid = (start + end) / 2;
	div_range(start, mid, left, right, val, i << 1);
	div_range(mid + 1, end, left, right, val, i << 1 | 1);
	tree[i] = combine(tree[i << 1], tree[i << 1 | 1]);
	return;
}

int main()
{
	cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(false);
	// freopen("input2.txt", "rw", stdin);
	// freopen("output.txt", "w", stdout);

	fill_n(lazy2, 262144, -MAX);

	int n, q; cin >> n >> q;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	init(0, n - 1, 1);

	for (int i = 0; i < q; i++) {
		int mode; cin >> mode;
		if (mode == 1) {
			int l, r, c; cin >> l >> r >> c;
			add_range(0, n - 1, l, r, c);
		}
		else if (mode == 2) {
			int l, r, d; cin >> l >> r >> d;
			div_range(0, n - 1, l, r, d);
		}
		else {
			int l, r; cin >> l >> r;
			cout << search_range(0, n - 1, l, r, mode) << '\n';
		}
	}

	return 0;
}
