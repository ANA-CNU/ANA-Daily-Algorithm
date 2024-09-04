#include <bits/stdc++.h>

using namespace std;

constexpr int sz = 100001;

struct node
{
    node *l, *r, *p;
    // itv: 구간 길이
    // l: 짝지어지지 않은 '('의 개수
    // r: 짝지어지지 않은 ')'의 개수
    // wl: 역으로 짝지어지지 않은 '('의 개수
    // wr: 역으로 짝지어지지 않은 ')'의 개수
    // 예시: ())) -> (4, 0, 2, 1, 3)
    // 이때 올바른 괄호 쌍의 개수 =-> (itv - l - r) / 2
    // 1번 쿼리 수행시 -> (itv, l, r, wl, wr) -> (itv, wr, wl, r, l)
    // 2번 쿼리 수행시 -> (itv, l, r, wl, wr) -> (itv, wl, wr, l, r)
    // 3번 쿼리 수행시 -> (itv, l, r, wl, wr) -> (itv, r, l, wr, wl)
    int cnt, lv, rv, wlv, wrv;
    // '(': false ')': true
    bool v, swch, dummy;
    node(bool v, node* p) : p(p), cnt(1), v(v) {
        l = r = nullptr;
        if (!v) lv = 1, wlv = 1;
        else rv = 1, wrv = 1;
    }
    node(bool v) : node(v, nullptr) {}
    int eval() { return (cnt - lv - rv) >> 1; }
    static void combineLeft(node* x, node* a){
        // a + x
        int p = min(a->lv, x->rv), wp = min(a->wrv, x->wlv);
        x->lv += a->lv - p;
        x->rv += a->rv - p;
        x->wlv += a->wlv - wp;
        x->wrv += a->wrv - wp;
    }
    static void combineRight(node* x, node* b){
        // x + b
        int p = min(x->lv, b->rv), wp = min(x->wrv, b->wlv);
        x->lv += b->lv - p;
        x->rv += b->rv - p;
        x->wlv += b->wlv - wp;
        x->wrv += b->wrv - wp;
    }
} *tree, *nodes[sz + 5];

char arr[sz + 2];

void propagate(node* x){
    if (x->swch){
        x->v ^= true;
        if (x->l) x->l->swch ^= true;
        if (x->r) x->r->swch ^= true;
        swap(x->lv, x->wrv);
        swap(x->rv, x->wlv);
        x->swch = false;
    }
}

void update(node* x){
    x->cnt = 1;
    auto &a = x->l, &b = x->r;
    if (!x->v) x->lv = 1, x->wlv = 1, x->rv = 0, x->wrv = 0;
    else x->rv = 1, x->wrv = 1, x->lv = 0, x->wlv = 0;

    if (a) x->cnt += a->cnt;
    if (b) x->cnt += b->cnt;

    if (a && b && !a->dummy && !b->dummy){
        propagate(a); propagate(b);
        node::combineLeft(x, a);
        node::combineRight(x, b);
    } else if (a && !a->dummy){
        propagate(a);
        node::combineLeft(x, a);
    } else if (b && !b->dummy){
        propagate(b);
        node::combineRight(x, b);
    }
}

void rotate(node* x){
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
    (x->p ? (p == x->p->l ? x->p->l : x->p->r) : tree) = x;
    update(p); update(x);
}

void splay(node* x){
    while (x->p){
        node *p = x->p, *g = p->p;
        if (g){
            if ((x==p->l) == (p==g->l)) rotate(p);
            else rotate(x);
        } rotate(x);
    }
}

void findKth(int k){
    node* x = tree; propagate(x);
    while (true){
        while (x->l && x->l->cnt > k)
            x = x->l, propagate(x);
        if (x->l) k -= x->l->cnt;
        if (!k--) break;
        x = x->r;
        propagate(x);
    } splay(x);
}

void initTree(const int& n){
    tree = new node(true); tree->dummy = true;
    auto cur = tree;
    for (int i = 1; i <= n; ++i)
        nodes[i] = cur->r = new node(arr[i - 1] == '(' ? false : true, cur), cur = cur->r;
    cur->r = new node(false, cur); cur->r->dummy = true;
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

void swch(const int& s, const int& e){
    interval(s, e);
    auto& cur = tree->r->l;
    cur->swch = !cur->swch;
}

void prefix(node* cur, int level = 0, string str = "ROOT"){
    if (cur == nullptr) return;
    propagate(cur);
    prefix(cur->l, level + 1, "L--");
    if (!cur->dummy) cout << (cur->v ? ')' : '(');
    prefix(cur->r, level + 1, "R--"); 
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n, q, ans = 0;
    cin >> arr;
    n = strlen(arr);
    if (n & 1) return cout << 0 << '\n', 0;

    cin >> q;
    initTree(n);
    for (int i = 0; i < q; ++i){
        int x; cin >> x;
        swch(x, x);
        update(tree->r->l);
        interval(1, n);
        auto& cur = tree->r->l;
        if (cur->eval() == (n >> 1)) ++ans;
        splay(cur);
        // prefix(tree), cout << endl;
    }
    cout << ans << '\n';
}