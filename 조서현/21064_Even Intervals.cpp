#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

constexpr int MAXN = 50001, MAXM = 200001, INF = numeric_limits<int>::max(), MOD = 1e9 + 7, SQN = 225;

struct splayTree
{
    struct node
    {
        node *l, *r, *p;
        int cnt; ll v, esum, osum;
        bool dummy;
        node(int v, node* p) : p(p), cnt(1), v(v), esum(v), osum(0){
            l = r = nullptr;
        }
        node(int v) : node(v, nullptr) {}
        node() : node(-1) {}
    } *tree;

    void update(node* x){
        x->cnt = 1;
        x->esum = x->osum = 0;
        if (x->l && x->r && !x->l->dummy && !x->r->dummy){
            x->cnt += x->l->cnt + x->r->cnt;
            x->esum += x->l->esum, x->osum += x->l->osum;
            if (x->l->cnt & 1){
                x->esum += x->r->esum;
                x->osum += x->v + x->r->osum;
            } else {
                x->esum += x->v + x->r->osum;
                x->osum += x->r->esum;
            }

        } else if (x->l && !x->l->dummy){
            x->cnt += x->l->cnt;
            x->esum += x->l->esum, x->osum += x->l->osum;
            if (x->l->cnt & 1){
                x->osum += x->v;
            } else {
                x->esum += x->v;
            }
        } else if (x->r && !x->r->dummy){
            x->cnt += x->r->cnt;
            x->esum += x->v;
            x->esum += x->r->osum, x->osum += x->r->esum;
        } else {
            x->esum += x->v;
        }
        x->esum %= MOD, x->osum %= MOD;
    }

    splayTree(){
        tree = new node(-INF); tree->dummy = true;
        tree->r = new node(INF, tree), tree->r->dummy = true;
        update(tree);
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

    void insert(int v){
        node *p = tree, **b = nullptr;
        while (true){
            if (v < p->v){
                if (!p->l){
                    b = &p->l;
                    break;
                }
                p = p->l;
            } else {
                if (!p->r){
                    b = &p->r;
                    break;
                }
                p = p->r;
            }
        }
        *b = new node(v, p);
        splay(*b);
    }
    
    void find(int v){
        node* p = tree;
        while (p){
            if (v == p->v) break;
            if (v < p->v) p = p->l;
            else p = p->r;
        }
        splay(p);
    }

    void remove(int v){
        find(v);
        node* p = tree;
        tree = p->l; tree->p = nullptr;
        node* x = tree;
        while (x->r) x = x->r;
        x->r = p->r; p->r->p = x;
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

    node*& interval(int s, int e){
        findKth(s - 1);
        node* x = tree;
        tree = x->r; tree->p = nullptr;
        findKth(e - s + 1);
        x->r = tree; tree->p = x;
        tree = x;
        return tree->r->l;
    }

    void printTree(node* cur){
        if (cur == nullptr) return;
        printTree(cur->l);
        if (!cur->dummy) cout << cur->v << " ";
        printTree(cur->r);
    }
}sTree;

struct query
{
    int l, r, idx;
    bool operator<(const query& rhs) const {
        if (l / SQN == rhs.l / SQN) return r < rhs.r;
        return l / SQN < rhs.l / SQN;
    }
}queries[MAXM];

int arr[MAXN], ans[MAXM];

inline void add(int k){
    const int& v = arr[k];
    sTree.insert(v);
}

inline void sub(int k){
    const int& v = arr[k];
    sTree.remove(v);
}

inline int get(int s, int e){
    return sTree.interval(s, e)->esum;
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n, m; cin >> n >> m;
    for (int i = 0; i < n; ++i) cin >> arr[i];
    for (int i = 0; i < m; ++i) cin >> queries[i].l >> queries[i].r, queries[i].idx = i;
    sort(queries, queries + m);

    int x = queries[0].l, y = x - 1;
    for (int i = 0; i < m; ++i){
        const int &l = queries[i].l, &r = queries[i].r, &idx = queries[i].idx;
        while (y < r) add(++y);
        while (y > r) sub(y--);
        while (x > l) add(--x);
        while (x < l) sub(x++);

        ans[idx] = get(1, r - l + 1);
    }

    for (int i = 0; i < m; ++i) cout << ans[i] << "\n";
}