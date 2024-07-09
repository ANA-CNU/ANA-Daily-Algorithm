#include <bits/stdc++.h>

using namespace std;

struct node
{
    node *l, *r, *p;
    int cnt, lmx, rmx, mx;
    bool v, flip, dummy;

    node(bool v, node* p) : p(p), cnt(1), v(v) {
        l = r = nullptr;
        lmx = rmx = mx = v;
    }
    node(bool v) : node(v, nullptr) {}
} *tree, *nodes[100005];

bool arr[100000];

void propagate(node* x){
    if (!x->flip) return;
    swap(x->l, x->r);
    swap(x->lmx, x->rmx);
    if (x->l) x->l->flip ^= true;
    if (x->r) x->r->flip ^= true;
    x->flip = false;
}

void update(node* x){
    x->cnt = 1;
    node *&a = x->l, *&b = x->r;
    x->lmx = x->rmx = x->mx = x->v;
    if (a && b){
        propagate(a); propagate(b);
        x->cnt += a->cnt + b->cnt;
        x->lmx = a->cnt == a->mx ? (x->v ? a->mx + x->v + b->lmx : a->mx) : a->lmx;
        x->rmx = b->cnt == b->mx ? (x->v ? a->rmx + x->v + b->mx : b->mx) : b->rmx;
        x->mx = max(a->mx, b->mx);
        if (x->v) x->mx = max(x->mx, a->rmx + x->v + b->lmx);
    } else if (a){
        propagate(a);
        x->cnt += a->cnt;
        x->lmx = a->cnt == a->mx ? (a->mx + x->v) : a->lmx;
        x->rmx = x->v ? a->rmx + x->v : x->v;
        x->mx = max(a->mx, x->v ? a->rmx + x->v : x->v);
    } else if (b){
        propagate(b);
        x->cnt += b->cnt;
        x->lmx = x->v ? b->lmx + x->v : x->v;
        x->rmx = b->cnt == b->mx ? (b->mx + x->v) : b->rmx;
        x->mx = max(b->mx, x->v ? b->lmx + x->v : x->v);
    }
}

void rotate(node * x){
    node *p = x->p, *b = nullptr;
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
    (x->p ? (p==x->p->l ? x->p->l : x->p->r) : tree) = x;
    update(p); update(x);
}

void splay(node * x){
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

void initTree(const int& n){
    tree = new node(false); tree->dummy = true; // left dummy
    auto cur = tree;
    for (int i = 1; i <= n; ++i)
        nodes[i] = cur->r = new node(arr[i - 1], cur), cur = cur->r;
    cur->r = new node(false, cur); cur->r->dummy = true; // right dummy
    for (int i = n; i >= 1; --i) update(nodes[i]);
    if (n == 1) return;
    splay(nodes[n >> 1]);
}

void interval(const int& s, const int& e){
    findKth(s - 1);
    auto x = tree;
    tree = x->r;
    tree->p = nullptr;
    findKth(e - s + 1);
    x->r = tree;
    tree->p = x;
    tree = x;
}

void flip(const int& s, const int& e){
    interval(s, e);
    auto cur = tree->r->l;
    cur->flip = !cur->flip;
}

// for splay tree study
void prefix(node* cur, int level = 0, string str = "ROOT"){
    if (cur == nullptr) return;
    propagate(cur);
    for (int i = 0; i < level; i++) cout << "  ";
    cout << str << " (" << cur->v << " " << cur->cnt << " " << cur->lmx << " " << cur->mx << " " << cur->rmx;
    if (cur->dummy) cout << " Dummy";
    cout << ")\n";
    prefix(cur->l, level + 1, "L--");
    prefix(cur->r, level + 1, "R--"); 
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n, m; cin >> n;
    for (int i = 0; i < n; ++i) cin >> arr[i];
    cin >> m;

    initTree(n);
    for (int i = 0; i < m; ++i){
        int op, l, r; cin >> op >> l >> r;
        if (op == 1){
            flip(l, r);
        } else {
            interval(l, r);
            auto& cur = tree->r->l;
            cout << max(max(cur->lmx, cur->rmx), cur->mx) << '\n';
        }
    }

    return 0;
}