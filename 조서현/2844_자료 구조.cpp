#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

constexpr int sz = 100'000;
constexpr ll inf = 1e18;

struct node
{
    node *l, *r, *p;
    int cnt;
    ll v, sum; ll mul; ll add, cumul;
    bool dummy;
    node(ll v, node *p = nullptr) : l(nullptr), r(nullptr), p(p), cnt(1), v(v), sum(v), mul(1), add(0), cumul(0) {}
} *tree, *nodes[sz + 5];

int arr[sz];

void propagate(node* x){
    auto &a = x->add, &c = x->cumul; auto &m = x->mul;
    auto &l = x->l, &r = x->r;
    if (a == 0 && m == 1 && c == 0) return;
    int lc = l ? l->cnt : 0;
    x->v = x->v * m + a + (lc + 1) * c;
    x->sum = x->sum * m + a * x->cnt + c * x->cnt * (x->cnt + 1) / 2;
    if (l){
        l->add = l->add * m + a;
        l->cumul = l->cumul * m + c;
        l->mul *= m;
    }
    if (r){
        r->add = r->add * m + a + (lc + 1) * c;
        r->cumul = r->cumul * m + c;
        r->mul *= m;
    }

    a = 0, m = 1, c = 0;
}

void update(node* x){
    x->cnt = 1;
    x->sum = x->v;
    if (x->l){
        propagate(x->l);
        x->cnt += x->l->cnt;
        x->sum += x->l->sum;
    }
    if (x->r){
        propagate(x->r);
        x->cnt += x->r->cnt;
        x->sum += x->r->sum;
    }
}

void rotate(node* x){
    node* p = x->p, *b = nullptr;
    if (!p) return;
    propagate(p); propagate(x);
    if (x == p->l){
        p->l = b = x->r;
        x->r = p;
    } else {
        p->r = b = x->l;
        x->l = p;
    }
    x->p = p->p; p->p = x;
    if (b) b->p = p;
    (x->p ? (p == x->p->l ? x->p->l : x->p->r) : tree) = x;
    update(p); update(x);
}

void splay(node* x){
    while (x->p){
        node *p = x->p, *g = p->p;
        if (g){
            if ((x==p->l) == (p==g->l)) rotate(p);
            else rotate(x);
        }
        rotate(x);
    }
}

void findKth(int k){
    node* x = tree;
    propagate(x);
    while (true){
        while (x->l && x->l->cnt > k)
            x = x->l, propagate(x);
        if (x->l) k -= x->l->cnt;
        if (!k--) break;
        x = x->r;
        propagate(x);
    }
    splay(x);
}

void initTree(const int n){
    nodes[0] = tree = new node(-inf); tree->dummy = true;
    auto cur = tree;
    for (int i = 1; i <= n; ++i)
        nodes[i] = cur->r = new node(arr[i - 1], cur), cur = cur->r;
    nodes[n + 1] = cur->r = new node(inf, cur); cur->r->dummy = true;
    for (int i = n; i >= 0; --i) update(nodes[i]);
    if (n == 1) return;
    splay(nodes[n >> 1]);
}

void interval(const int s, const int e){
    findKth(s - 1);
    auto x = tree;
    tree = x->r;
    tree->p = nullptr;
    findKth(e - s + 1);
    x->r = tree;
    tree->p = x;
    tree = x;
}

void insertKth(const int k, const int v){
    findKth(k);
    auto x = tree->r; propagate(x);
    while (x->l) x = x->l, propagate(x);
    x->l = new node(v);
    x->l->p = x; update(x);
    splay(x->l);
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    // freopen("data/5.in", "r", stdin);
    // freopen("data/1.out", "w", stdout);

    int n, q; cin >> n >> q;
    for (int i = 0; i < n; ++i) cin >> arr[i];
    initTree(n);
    while (q--){
        int op; cin >> op;
        if (op == 1){
            int a, b, x; cin >> a >> b >> x;
            interval(a, b);
            auto& cur = tree->r->l;
            propagate(cur);
            cur->mul = 0, cur->add = x, cur->cumul = 0;
            splay(cur);
        } else if (op == 2){
            int a, b, x; cin >> a >> b >> x;
            interval(a, b);
            auto& cur = tree->r->l;
            propagate(cur);
            cur->mul = 1, cur->add = 0, cur->cumul = x;
            splay(cur);
        } else if (op == 3){
            int c, x; cin >> c >> x;
            insertKth(c - 1, x);
        } else {
            int a, b; cin >> a >> b;
            interval(a, b);
            auto& cur = tree->r->l;
            propagate(cur);
            cout << cur->sum << '\n';
        }
    }
}