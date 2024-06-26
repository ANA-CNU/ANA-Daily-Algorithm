#include <bits/stdc++.h>

using namespace std;

struct node
{
    node *l, *r, *p;
    int cnt; 
    char v;
    bool flip, dummy;

    node(char v, node* p) : l(nullptr), r(nullptr), p(p), cnt(1), v(v) {}
    node(char v) : node(v, nullptr) {}
    node() : node(0) {}

    ~node() {
        // if (l) delete l;
        // if (r) delete r;
    }
} *tree, *nodes[2500010];

char arr[2500010];

void update(node* x){
    x->cnt = 1;
    if (x->l) {
        x->cnt += x->l->cnt;
    }
    if (x->r) {
        x->cnt += x->r->cnt;
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
    tree = new node(numeric_limits<char>::min()); tree->dummy = true; // left dummy
    auto cur = tree;
    for (int i = 1; i <= n; i++){
        nodes[i] = cur->r = new node(arr[i-1], cur);
        cur = cur->r;
    }
    cur->r = new node(numeric_limits<char>::max(), cur); cur->r->dummy = true; // right dummy
    for (int i = n + 1; i >= 0; i--){
        if (nodes[i])
            update(nodes[i]);
    }
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

void flip(int s, int e){
    interval(s, e);
    auto cur = tree->r->l;
    cur->flip = !cur->flip;
}

void print(node* cur){
    if (cur == nullptr) return;
    propagate(cur);
    print(cur->l);
    if (!cur->dummy) cout << cur->v;
    print(cur->r);
}

// for splay tree study
void prefix(node* cur, int level=0, string str="ROOT:"){
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

    cin >> arr;
    int n = strlen(arr), q; cin >> q;
    initTree(n);

    for (int i = 0; i < q; i++)
    {
        int a, b; cin >> a >> b;
        flip(a, b);
        // update(tree);
    }
    print(tree); cout << '\n';
}