#include <bits/stdc++.h>
#define deb(x) cout << #x << " : " << (x) << "\n"
#define deb_pair(x, y)                                                         \
    cout << "(" << #x << ", " << #y << ") : (" << (x) << ", " << (y) << ")\n"
#define deb_tuple(x, y, z)                                                     \
    cout << "(" << #x << ", " << #y << ", " << #z << ") : (" << (x) << ", "    \
         << (y) << ", " << (z) << ")\n"
#define ALL(x) (x).begin(), (x).end()
#define SIZE(x) (int)((x).size())
using namespace std;

class Node {
public:
    Node* children[2];

    Node() {
        fill(children, children + 2, nullptr);
    }

    ~Node() {
        if (children[0] != nullptr) delete children[0];
        if (children[1] != nullptr) delete children[1];
    }

    // x[i]부터 재귀적으로 삽입
    void insert(int i, int x) {
        if (i < 0) return;
        int there = (bool)(x & (1 << i));
        if (children[there] == nullptr) children[there] = new Node();
        children[there]->insert(i - 1, x);
    }

    // x[i]부터 xor해서 가장 큰 값을 찾는다
    int find(int i, int x) {
        if (i < 0) return 0;
        if (children[0] != nullptr && children[1] != nullptr) {
            if (x & (1 << i)) {
                return (x & (1 << i)) + children[0]->find(i - 1, x);
            } else {
                return ((x & (1 << i)) ^ (1 << i)) + children[1]->find(i - 1, x);
            }
        } else if (children[0] != nullptr) {
            return (x & (1 << i)) + children[0]->find(i - 1, x);
        } else {
            return ((x & (1 << i)) ^ (1 << i)) + children[1]->find(i - 1, x);
        }
    }
};

void solve() {
    int n;
    cin >> n;
    vector<int> s(n);
    Node* root = new Node();
    root->insert(31, 0);
    int max = 0;
    for (int i = 0; i < n; i++) {
        cin >> s[i];
        if (i - 1 >= 0) s[i] ^= s[i - 1];
        root->insert(31, s[i]);
        max = ::max(max, root->find(31, s[i]));
    }
    cout << max << "\n";
    delete root;
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int tc;
    cin >> tc;
    while (tc--) {
        solve();
    }
}
