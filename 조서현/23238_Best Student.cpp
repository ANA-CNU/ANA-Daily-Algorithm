#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

int n, sq = 316, q;

struct query
{
    int l, r, idx;
    bool operator<(const query& other) const{
        if (l / sq == other.l / sq) return r < other.r;
        return l / sq < other.l / sq;
    }
} queries[100000];

int arr[100000], tmp[100000], cnt[100010], ccnt[320][100010], res[100010], bkt[320], most = 0;

inline void add(const int& k){
    const int& e = arr[k];

    if (cnt[e] == bkt[e / sq]) ++bkt[e / sq];
    --ccnt[e / sq][cnt[e]];
    ++cnt[e];
    ++ccnt[e / sq][cnt[e]];
}

inline void sub(const int& k){
    const int& e = arr[k];

    --ccnt[e / sq][cnt[e]];
    --cnt[e];
    ++ccnt[e / sq][cnt[e]];
    if (!ccnt[e / sq][bkt[e / sq]]) --bkt[e / sq];
}

inline int get(){
    int most = 0;
    for (int i = 0; i < 320; i++){
        most = max(most, bkt[i]);
    }

    for (int j = sq; j >= 0; --j){
        if (bkt[j] != most) continue;
        for (int k = sq; k >= 0; --k){
            if (n + 2 > j * sq + k && cnt[j * sq + k] == most){
                return j * sq + k;
            }
        }
    }
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    // freopen("test.txt", "r", stdin);
    // freopen("out1.txt", "w", stdout);

    cin >> n >> q;

    unordered_map<int, int> comp(n), uncomp(n);
    for (int i = 0; i < n; ++i) cin >> arr[i], tmp[i] = arr[i];
    sort(tmp, tmp + n); int idx = 1;
    for (int i = 0; i < n; ++i){
        if (comp.find(tmp[i]) == comp.end())
            comp[tmp[i]] = idx, uncomp[idx] = tmp[i], ++idx;
    }
    for (int i = 0; i < n; ++i)
        arr[i] = comp[arr[i]];

    for (int i = 0; i < q; ++i) cin >> queries[i].l >> queries[i].r, queries[i].idx = i, --queries[i].l, --queries[i].r;
    sort(queries, queries + q);

    int x, y;
    for (int i = 0; i < q; ++i){
        const int &l = queries[i].l, &r = queries[i].r, &idx = queries[i].idx;
        if (!i) x = l, y = l - 1;
        while (y < r) add(++y);
        while (y > r) sub(y--);
        while (x > l) add(--x);
        while (x < l) sub(x++);

        int ans = get();
        res[idx] = uncomp[ans];
    }

    for (int i = 0; i < q; ++i){
        cout << res[i] << '\n';
    }


    return 0;
}