#include <iostream>
#include <vector>
using namespace std;

void tree(const vector<int>& in, const vector<int>& post, int in_start, int in_end, int post_start, int post_end) {
    if (post_start > post_end) {
        return;
    }
    int root = post[post_end];
    cout << root << " ";
    if (in_start == in_end) {
        return;
    }
    int idx1 = 0;
    for (int i = in_start; i <= in_end; i++) {
        if (in[i] == root) {
            idx1 = i;
            break;
        }
    }
    int left_size = idx1 - in_start;

    tree(in, post, in_start, idx1 - 1, post_start, post_start + left_size - 1);
    tree(in, post, idx1 + 1, in_end, post_start + left_size, post_end - 1);
}

int main() {
    int n;
    cin >> n;
    vector<int> in(n), post(n);
    for (int i = 0; i < n; i++) {
        cin >> in[i];
    }
    for (int i = 0; i < n; i++) {
        cin >> post[i];
    }
    tree(in, post, 0, n - 1, 0, n - 1);
    return 0;
}
