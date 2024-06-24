#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

const int inf = 1e9;

struct node
{
    node *l, *r, *p;
    ll cnt;
    ll sum, v, mn, mx;
    bool flip, dummy;

    node(ll v, node* p) : l(nullptr), r(nullptr), p(p), cnt(1), sum(v), v(v), mn(v), mx(v) {}
    node(ll v) : node(v, nullptr) {}
    node() : node(0) {}

    ~node() {
        if (l) delete l;
        if (r) delete r;
    }
} *tree, *nodes[300010];

void update(node* x){
    x->cnt = 1;
    x->sum = x->mn = x->mx = x->v;
    if (x->l) {
        x->cnt += x->l->cnt;
        x->sum += x->l->sum;
        x->mn = min(x->mn, x->l->mn);
        x->mx = max(x->mx, x->l->mx);
    }
    if (x->r) {
        x->cnt += x->r->cnt;
        x->sum += x->r->sum;
        x->mn = min(x->mn, x->r->mn);
        x->mx = max(x->mx, x->r->mx);
    }
}

void propagate(node* x){
    if (!x->flip) return;
    swap(x->l, x->r);
    if (x->l) x->l->flip = !x->l->flip;
    if (x->r) x->r->flip = !x->r->flip;
    x->flip = false;
}

void rotate(node* x){
    node* p = x->p;
    node* b = nullptr;
    if (!p) return; // x가 루트라면 종료
    propagate(p); propagate(x);
    if (x == p->l) { // x가 왼쪽 자식
        p->l = b = x->r;
        x->r = p;
    } else { // x가 오른쪽 자식
        p->r = b = x->l;
        x->l = p;
    } // x가 p의 부모가 됨
    x->p = p->p;
    p->p = x;
    if (b) b->p = p;
    (x->p ? (p==x->p->l ? x->p->l : x->p->r) : tree) = x;
    update(p); update(x);
}

void splay(node* x){
    while (x->p){ // x가 루트가 될 때까지
        node* p = x->p;
        node* g = p->p; // x의 조상의 조상
        if (g){
            // g의 왼쪽 왼쪽이 or 오른쪽 오른쪽이 x일 경우
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
        while (x->l && x->l->cnt > k){
            x = x->l; propagate(x);
        }
        if (x->l) k -= x->l->cnt;
        if (!k--) break;
        x = x->r;
        propagate(x);
    }
    splay(x);
}

void initTree(int n){
    memset(nodes, 0, sizeof(nodes));

    tree = new node(-inf); tree->dummy = true; // left dummy
    auto cur = tree;
    for (int i = 1; i <= n; i++){
        nodes[i] = cur->r = new node(i, cur);
        cur = cur->r;
    }
    cur->r = new node(inf, cur); cur->r->dummy = true; // right dummy
    for (int i = n; i >= 1; i--) update(nodes[i]);
    if (n == 1) return;
    splay(nodes[n >> 1]);
}

void interval(int s, int e){
    findKth(s - 1);
    node* x = tree;
    tree = x->r;
    tree->p = nullptr; // 일시적으로 연결을 끊고
    findKth(e - s + 1);
    x->r = tree;
    tree->p = x; // 다시 연결
    tree = x;
}

void printTree(node* cur){
    if (cur == nullptr) return;
    propagate(cur);
    printTree(cur->l);
    if (!cur->dummy) cout << cur->v << " ";
    printTree(cur->r);
}

// for splay tree study
void prefix(node* cur, int level, string str){
    if (cur == nullptr) return;
    for (int i = 0; i < level; i++) cout << "  ";
    cout << str << " (" << cur->v << " " << cur->cnt << ")\n";
    prefix(cur->l, level + 1, "L--");
    prefix(cur->r, level + 1, "R--"); 
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    // freopen("testcase.txt", "r", stdin);
    // freopen("out1.txt", "w", stdout);

    int n, q; cin >> n >> q;
    initTree(n);
    // printTree(tree);
    for (int i = 0; i < q; i++){
        int op; cin >> op;
        if (op == 0){
            int i; cin >> i;
            findKth(i);
            prefix(tree, 0, "Root: "); cout << endl;
        } else 
        if (op == 1){
            int l, r; cin >> l >> r;
            interval(l, r);
            auto cur = tree->r->l;
            cout << cur->mn << " " << cur->mx << " " << cur->sum << '\n';
            cur->flip = !cur->flip;
            update(tree);
        } else if (op == 2){
            int l, r, x; cin >> l >> r >> x;
            interval(l, r);
            auto cur = tree->r->l;
            cout << cur->mn << " " << cur->mx << " " << cur->sum << '\n';
            x %= (r - l + 1);
            if (x == 0) continue;
            cur->flip = !cur->flip;
            update(tree);
            int mid = x > 0 ? l + x - 1 : r + x;
            interval(l, mid);
            cur = tree->r->l;
            cur->flip = !cur->flip;
            update(tree);
            interval(mid + 1, r);
            cur = tree->r->l;
            cur->flip = !cur->flip;
            update(tree);
        } else if (op == 3){
            int i; cin >> i;
            findKth(i);
            cout << tree->v << '\n';
        } else {
            int x; cin >> x;
            splay(nodes[x]);
            if (!tree->l){
                cout << tree->cnt - 1 << '\n';
                continue;
            }
            cout << tree->l->cnt << '\n';
        }
    }
    printTree(tree); cout << '\n';
}