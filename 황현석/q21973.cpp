#include <bits/stdc++.h>
#define MAX 100001

using namespace std;

typedef long long ll;

struct node {
    int sum, cnt;
    bool re = false;

    node* p = nullptr, *l = nullptr, *r = nullptr;

    node(int cnt) : cnt(cnt), sum(cnt) {}

    void update () {
        sum = cnt;
        if (l) sum += l->sum;
        if (r) sum += r->sum;
    }

    void propagate () {
        if (re) {
            swap(l, r);
            if (l) l->re ^= true;
            if (r) r->re ^= true;
        }

        re = false;
    }

};

node* nodes[MAX];

bool isRoot (node* a) {
    return !a->p || (a->p->l != a && a->p->r != a);
}

void rotate (node* a) {
    node* parent = a->p, *temp;

    parent->propagate(); a->propagate();

    if (a->p->l == a) {
        parent->l = temp = a->r;
        a->r = parent;
    } else {
        parent->r = temp = a->l;
        a->l = parent;
    }

    if (temp) temp->p = parent;

    a->p = parent->p;
    parent->p = a;

    if (a->p) {
        if (a->p->l == parent) {
            a->p->l = a;
        } else if (a->p->r == parent) {
            a->p->r = a;
        }
    }

    parent->update();
    a->update();
}

void splay (node* a) {
    a->propagate();
    while(!isRoot(a)) {
        if (!isRoot(a->p)) rotate((a->p->p->l == a->p) == (a->p->l == a) ? a->p : a);
        rotate(a);
    }
}

void access (node* a) {
    splay(a);
    a->r = nullptr;

    a->update();

    while(a->p) {
        splay(a->p);
        a->p->r = a;

        a->p->update();
        splay(a);
    }
}

void makeRoot (node* a) {
    access(a);
    a->re ^= true;
    a->propagate();
}

void link (node* a, node* b) {
    access(a); access(b);
    a->l = b;
    b->p = a;

    a->update();
}

void connect (node* a, node* b) {
    makeRoot(a);
    link(a, b);
}

node* root (node* a) {
    access(a);

    while(a->l) {
        a->l->propagate();
        a=a->l;
    }
    splay(a);
    return a;
}

bool isConnect (node* a, node* b) {
    return root(a) == root(b);
}

node* getLca (node* a, node* b) {
    access(a);
    access(b);
    splay(a);

    return a->p ? a->p : a;
}

int query (node* a, node* b) {
    node* lca = getLca(a, b);
    int res = 0;

    access(a);
    splay(lca);

    if (lca->r) res += lca->r->sum;

    access(b);
    splay(lca);

    if (lca->r) res += lca->r->sum;

    res += lca->cnt;
    return res;
}




int T, N, Q;

int main () {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);

    cin >> N;
    int p;
    for (int i=1;i<=N;i++) {
        cin >> p;
        nodes[i] = new node(p);
    }

    cin >> T;
    string s;
    int a, b;

    while(T-->0) {
        cin >> s;
        cin >> a >> b;

        if (s[0] == 'b') {
            if (isConnect(nodes[a], nodes[b])) {
                cout << "no" << '\n';
            } else {
                cout << "yes" << '\n';
                connect(nodes[a], nodes[b]);
            }
        } else if (s[0] == 'p') {
            access(nodes[a]);
            nodes[a]->cnt = b;
            nodes[a]->update();
        } else {
            if (isConnect(nodes[a], nodes[b])) {
                cout << query(nodes[a], nodes[b]) << '\n';
            } else {
                cout << "impossible" << '\n';
            }
        }
        cout << flush;
    }



}
