#pragma GCC optimize ("O3")
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2")
#include<bits/stdc++.h>
#include <unistd.h>

using namespace std;

typedef long long integer;

struct node
{
	integer range_max, range_sum, second_max, cnt_max;
};

inline node combine(const node a, const node b){
	if (a.range_max == b.range_max){
		return {a.range_max, a.range_sum + b.range_sum, max(a.second_max, b.second_max), a.cnt_max + b.cnt_max};
	}
	if (a.range_max > b.range_max){
		return {a.range_max, a.range_sum + b.range_sum, max(a.second_max, b.range_max), a.cnt_max};
	}
	return {b.range_max, a.range_sum + b.range_sum, max(a.range_max, b.second_max), b.cnt_max};
}

int arr[1000000];
node tree[2097152];

node init(int left, int right, int i){
	if (left == right){
		return tree[i] = {arr[left], arr[left], -1, 1};
	}
	int mid = (left + right) >> 1;
	tree[i] = combine(init(left, mid, i << 1), init(mid + 1, right, (i << 1) + 1));
	return tree[i];
}

void propagate_lazy(const int& start, const int& end, int i){
	if (start == end)
		return;
	int l = i << 1, r = (i << 1) + 1;
	if (tree[i].range_max < tree[l].range_max){
		tree[l].range_sum -= (tree[l].range_max - tree[i].range_max) * tree[l].cnt_max;
		tree[l].range_max = tree[i].range_max;
	}
	if (tree[i].range_max < tree[r].range_max){
		tree[r].range_sum -= (tree[r].range_max - tree[i].range_max) * tree[r].cnt_max;
		tree[r].range_max = tree[i].range_max;
	}
}

integer search_range_sum(int start, int end, const int& left, const int& right, int i){
	propagate_lazy(start, end, i);
	if (end < left || start > right)
		return 0;
	if (left <= start && end <= right){
		return tree[i].range_sum;
	}
	int mid = (start + end) >> 1;
	return search_range_sum(start, mid, left, right, i << 1) + search_range_sum(mid + 1, end, left, right, (i << 1) + 1);
}

integer search_range_max(int start, int end, const int& left, const int& right, int i){
	propagate_lazy(start, end, i);
	if (end < left || start > right)
		return 0;
	if (left <= start && end <= right){
		return tree[i].range_max;
	}
	int mid = (start + end) >> 1;
	return max(search_range_max(start, mid, left, right, i << 1), search_range_max(mid + 1, end, left, right, (i << 1) + 1));
}

void update_range(int start, int end, const int& left, const int& right, int i, const int& val){
	propagate_lazy(start, end, i);
	// break condition
	if (end < left || start > right || tree[i].range_max <= val)
		return;
	if (left <= start && end <= right && tree[i].second_max < val){
		// tag
		tree[i].range_sum -= (tree[i].range_max - val) * tree[i].cnt_max;
		tree[i].range_max = val;
		propagate_lazy(start, end, i);
		return;
	}
	if (start == end)
		return;
	int mid = (start + end) >> 1;
	update_range(start, mid, left, right, i << 1, val);
	update_range(mid + 1, end, left, right, (i << 1) + 1, val);
	tree[i] = combine(tree[i << 1], tree[(i << 1) + 1]);
}

int main()
{
	cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(false);
	// freopen("input.txt", "rw", stdin);

	int n; cin >> n;
	for(int i = 0; i < n; ++i)
		cin >> arr[i];
	int m; cin >> m;
	init(0, n - 1, 1);
	for (int i = 0; i < m; ++i){
		int mode;
		cin >> mode;
		if (mode == 1){
			int a, b, c;
			cin >> a >> b >> c;
			update_range(0, n - 1, --a, --b, 1, c);
		} else if (mode == 2){
			int a, b;
			cin >> a >> b;
			cout << search_range_max(0, n - 1, --a, --b, 1) << '\n';
		} else{
			int a, b;
			cin >> a >> b;
			cout << search_range_sum(0, n - 1, --a, --b, 1) << '\n';
		}
	}
	return 0;
}
