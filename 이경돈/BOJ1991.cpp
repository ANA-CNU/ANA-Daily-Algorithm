#include <iostream>
#include <vector>
using namespace std;

int n;
pair<char, char> BinTree[26];

void preorder(char curNode) {
    if (curNode == '.') return;

    cout << curNode;
    preorder(BinTree[curNode - 65].first);
    preorder(BinTree[curNode - 65].second);
}

void inorder(char curNode) {
    if (curNode == '.') return;

    inorder(BinTree[curNode - 65].first);
    cout << curNode;
    inorder(BinTree[curNode - 65].second);
}

void postorder(char curNode) {
    if (curNode == '.') return;

    postorder(BinTree[curNode - 65].first);
    postorder(BinTree[curNode - 65].second);
    cout << curNode;
}

int main() {
    char root, left, right;

    cin >> n;

    while (n-- > 0) {
        cin >> root >> left >> right;

        BinTree[root - 65].first = left;
        BinTree[root - 65].second = right;
    }

    preorder('A');
    cout << "\n";
    inorder('A');
    cout << "\n";
    postorder('A');
}