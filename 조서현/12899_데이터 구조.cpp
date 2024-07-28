#include <bits/stdc++.h>

using namespace std;

struct node
{
    node *l, *r, *p;
    int cnt, v;
    node(int v, node* p) : v(v), p(p){
        l = r = nullptr;
        cnt = 1;
    }
    node(int v) : node(v, nullptr) {}
    node() : node(0) {}
} *tree;

void update(node* x){
    x->cnt = 1;
    if (x->l) x->cnt += x->l->cnt;
    if (x->r) x->cnt += x->r->cnt;
}

void rotate(node* x){
    node *p = x->p, *b = nullptr;
    if (!p) return;
    if (x == p->l) p->l = b = x->r, x->r = p;
    else p->r = b = x->l, x->l = p;
    x->p = p->p, p->p = x;
    if (b) b->p = p;
    (x->p ? (p == x->p->l ? x->p->l : x->p->r) : tree) = x;
    update(p); update(x);
}

void splay(node* x){
    while (x->p){
        node *p = x->p, *g = p->p;
        if (g){
            if ((x == p->l) == (p == g->l)) rotate(p);
            else rotate(x);
        }
        rotate(x);
    }
}

void findKth(int k){
    node* x = tree;
    while (true){
        while (x->l && x->l->cnt > k) x = x->l;
        if (x->l) k -= x->l->cnt;
        if (!k--) break;
        x = x->r;
    }
    splay(x);
}

void deleteKth(int k){
    findKth(k);
    node *p = tree;
    // p->l && p->r임이 보장된다.
    tree = p->l; tree->p = nullptr;
    node *x = tree;
    while (x->r) x = x->r;
    x->r = p->r; p->r->p = x;
    update(x->r); update(x); update(tree);
}

void insert(int v){
    if (!tree){
        tree = new node(v);
        return;
    }
    node *x = tree, *p = nullptr, **b = nullptr;
    while (x){
        p = x;
        if (x->v < v) x = x->r, b = &p->r;
        else x = x->l, b = &p->l;
    }
    *b = x = new node(v, p);
    update(x); update(p);
    splay(x);
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    tree = new node(numeric_limits<int>::min());
    tree->r = new node(numeric_limits<int>::max(), tree);
    update(tree);

    int n; cin >> n;
    while (n--){
        int s, x; cin >> s >> x;
        if (s == 1) insert(x);
        else{
            findKth(x);
            cout << tree->v << endl;
            deleteKth(x);
        }
    }
}