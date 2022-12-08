#include<bits/stdc++.h>
#define MAX 202020

using namespace std;

typedef long long ll;

struct node {
    ll taste, tSum;
    node *p = nullptr, *r = nullptr, *l = nullptr;
    int parent = 0, roof = 0;

    node(ll taste = 0) : taste(taste), tSum(taste) {}

    void setTaste (ll t){
        tSum = taste = t;
        update();
    }

    void update () {
        tSum = taste;

        if (l) {
            tSum += l->tSum;
        }

        if (r) {
            tSum += r->tSum;
        }
    }
};

node *nodes[MAX];

bool isRoot (node* a) {
    return !a->p || (a->p->l != a && a->p->r != a);
}

void rotate (node* a) {
    node* p = a->p, *temp = nullptr;

    if (a->p->l == a) {
        temp = p->l = a->r;
        a->r = p;
    } else {
        temp = p->r = a->l;
        a->l = p;
    }

    if (temp) temp->p = p;

    a->p = p->p;
    p->p = a;

    if (a->p) {
        if (a->p->l == p) {
            a->p->l = a;
        } else if (a->p->r == p) {
            a->p->r = a;
        }
    }

    p->update(); a->update();
}

void splay (node* a) {
    a->update();
    while(!isRoot(a)) {
        if (!isRoot(a->p))
            rotate((a->p->p->l == a->p) == (a->p->l == a) ? a->p : a);
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

node* getRoot (node* a) {
    access(a);

    while(a->l) {
        a = a->l;
    }

    return a;
}

node* getLca (node* a, node* b) {
    access(a); access(b);
    splay(a);

    return a->p ? a->p : a;
}

bool isConnect (node* a, node* b) {
    return getRoot(a) == getRoot(b);
}

void link (node* a, node* b) {
    access(a); access(b);
    a->l = b;
    b->p = a;
    a->update();
}

void cut (node * a) {
    access(a);

    if (a->l) {
        a->l->p = nullptr;
    }

    a->l = nullptr;
    a->parent = a->roof = 0;
    a->update();
}

ll query (node* a, node* b) {
    if (a == b) return a->taste;

    node* lca = getLca(a, b);

    ll res = 0;

    access(a);
    splay(lca);

    if (lca->r) res += lca->r->tSum;

    access(b);
    splay(lca);

    if(lca->r) res += lca->r->tSum;

    res += lca->taste;

    return res;
}

ll query (node* a) {
    node* root = getRoot(a);

    while (root->roof) {
        if (!isConnect(root, nodes[root->parent])) {
            link(root, nodes[root->parent]);
            root->roof = 0;
            
            root = getRoot(a);
        } else {
            break;
        }
    }

    if (root->roof) {
        node* second = nodes[root->parent];

        if (second == a) return query(root, a);

        node* lca = getLca(a, second);

        if (lca == root) return query(a, second);
        if (lca == a || lca == second) return max(query(root, a), query(root, second));

        ll temp = query(root, lca);
        ll x = query(lca, a);
        ll y = query(lca, second);

        return temp + x + y - lca->taste * 2;
    } else {
        return query(root, a);
    }

}

int N, Q;

int main () {
    cin.tie(nullptr); ios_base::sync_with_stdio(false);

    cin >> N >> Q;

    for (int i=1;i<=N;i++) {
        nodes[i] = new node();
    }

    int x;

    for (int i=1;i<=N;i++) {
        cin >> x;
        nodes[i]->parent = x;

        if (x == i) continue;

        if (isConnect(nodes[i], nodes[x])) {
            nodes[i]->roof = 1;
        } else {
            link(nodes[i], nodes[x]);
        }
    }

    for (int i=1;i<=N;i++) {
        cin >> x;
        access(nodes[i]);
        nodes[i]->setTaste(x);
    }

    int m, i, j;

    while(Q-->0) {
        cin >> m;

        if (m == 1) {
            cin >> i >> j;
            cut(nodes[i]);

            nodes[i]->parent = j;

            if (i == j) continue;

            if (isConnect(nodes[i], nodes[j])) {
                nodes[i]->roof = 1;
            } else {
                link(nodes[i], nodes[j]);
            }
        } else if (m == 2) {
            cin >> i >> x;

            access(nodes[i]);
            nodes[i]->setTaste(x);
        } else {
            cin >> x;
            cout << query(nodes[x]) << '\n';

        }
    }

}
