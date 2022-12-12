#include<bits/stdc++.h>
#define MAX 1010101
#define MAX_T 4040404
#define INF 4e18
#define INF2 -400000000000

using namespace std;

typedef long long ll;

int N;

struct line {
    ll a, b, oriB;
    int idx;

    ll compare (const line &x, ll t = 0) {
        if (x.a == a) return INF;

        ll u = b - x.b;
        ll d = x.a - a;

        if (d < 0) {
            u *= -1;
            d *= -1;
        }

        //Math.ceil
        ll cMoment = u <= 0 ? (-((-u) / d)) : ((u + d - 1) / d);

        if (cMoment > 0) return cMoment;
        return INF;
    }

};

struct Seg {
    ll sumT[MAX_T] = {0};

    void update (int node, int s, int e, int target, ll value = 1) {
        if (s == e) {
            sumT[node] += value;
            return;
        }

        int mid = s + e >> 1;

        if (target <= mid) {
            update(node << 1, s, mid, target, value);
        } else {
            update(node << 1 | 1, mid+1, e, target, value);
        }

        sumT[node] = sumT[node << 1] + sumT[node << 1 | 1];
    }

    ll query (int node, int s, int e, int left, int right) {
        if (right < s || e < left) return 0;

        if (s <= left && right <= e) return sumT[node];

        int mid = left + right >> 1;

        return query(node << 1, s, e, left, mid) +
                query(node << 1 | 1, s, e, mid+1, right);
    }
};

Seg *one, *slope;

struct kineticSeg {
    int size;
    line tree[MAX_T];
    ll melt[MAX_T] = {0}, lazy[MAX_T] = {0}, add[MAX_T] = {0};
    ll p[MAX_T] = {};

    void pull (int n, int left, int right) {
        ll l = tree[n<<1].b, r = tree[n << 1 | 1].b;

        tree[n] = (l > r || (l == r && tree[n << 1].a > tree[n << 1 | 1].a))
            ? tree[n << 1] : tree[n << 1 | 1];

        melt[n] = min({melt[n << 1], melt[n << 1 | 1]
        , tree[n << 1].compare(tree[n << 1 | 1])});
    }

    void init (vector<line> &l) {
        size = l.size();
        init (1, 0, size-1, l);
    }

    void init (int node, int s, int e, vector<line> &l) {
        if (s == e) {
            tree[node] = l[s];
            melt[node] = INF;
            return;
        }

        int mid = s + e >> 1;

        init(node << 1, s, mid, l);
        init(node << 1 | 1, mid+1, e, l);

        pull(node, s, e);
    }

    void update (int node, int s, int e, int target, line l) {
        push(node, s, e);

        if (target < s || e < target) return;
        if (s == e) {
            tree[node] = l;
            return;
        }

        int mid = s + e>> 1;
        update(node << 1, s, mid, target, l);
        update(node << 1 | 1, mid+1, e, target, l);

        pull(node, s, e);
    }

    void push (int node, int left, int right) {
        if (!p[node]) return;

        tree[node].b += tree[node].a * lazy[node] + add[node];
        melt[node] -= lazy[node];

        if (left != right) {
            lazy[node << 1] += lazy[node];
            lazy[node << 1 | 1] += lazy[node];
            add[node << 1] += add[node];
            add[node << 1 | 1] += add[node];

            p[node << 1] = 1;
            p[node << 1 | 1] = 1;
        }
        p[node] = lazy[node] = add[node] = 0;
    }

    void heaten (int left, int right) {
        //left right 는 인덱스로 관리해야함.
        heaten(1, left, right, 0, size-1);
    }

    void heaten (int node, int s, int e, int left, int right) {
        push(node, left, right);

        if (right <s || e < left) return;

        if (s <= left && right <= e) {
            heat(node, s, e, left, right);
            return;
        }

        int mid = left + right >> 1;

        heaten(node << 1, s, e, left, mid);
        heaten(node << 1 | 1, s, e, mid +1 , right);

        pull(node, left, right);
    }

    void heat (int node, int s, int e, int left, int right) {
        push(node, left, right);

        if (melt[node] > 1) {
            lazy[node]++;
            p[node] = 1;
            push(node, left, right);
            return;
        }

        int mid = left + right >> 1;
        heat(node << 1, s, e, left, mid);
        heat(node << 1 | 1, s, e, mid+1, right);

        pull(node, left, right);
    }

    void adds (int node, int s, int e, int left, int right, ll value) {
        push(node, left, right);

        if (right < s || e < left) return;

        if (s <= left && right <=e ) {
            p[node] = 1;
            add[node] += value;
            push(node, left, right);
            return;
        }

        int mid = left + right >> 1;

        adds(node <<1, s, e, left, mid, value);
        adds(node << 1 | 1, s, e, mid+1, right, value);

        pull(node, left, right);
    }
}kst;


bool cmp (line &a, line &b) {
    return a.a < b.a;
}

vector<line> dragons;

int main() {
    cin.tie(nullptr); ios_base::sync_with_stdio(false);
    cin >> N;

    ll a, b;

    dragons.resize(N);

    for (int i=0;i<N;i++) {
        cin >> a>> b;
        dragons[i] = {a, b, b, -1};
    }

    sort(dragons.begin(), dragons.end(), cmp);

    for (int i=0;i<N;i++) {
        dragons[i].idx = i;
    }

    kst.init(dragons);
    one = new Seg();
    slope = new Seg();

    ll adding = 0;

    for (int i=0;i<N;i++) {
        line ans = kst.tree[1];
        cout << ans.b + adding << '\n';

        int idx = ans.idx;

        ll s = one->query(1, 0, idx, 0, N-1);
        one->update(1, 0, N-1, idx);

        ll temp = (s+1) * ans.a + ans.oriB;

        ll right = slope->query(1, idx, N-1, 0, N-1);
        slope->update(1, 0, N-1, idx, ans.a);

        adding += right;
        kst.adds(1, 0, idx, 0, N-1, temp);
        kst.adds(1, idx, N-1, 0, N-1, s * ans.a + ans.oriB);

        kst.heaten(idx, N-1);

        kst.update(1, 0, N-1, idx, {0, INF2, INF2, -1});
    }
}
