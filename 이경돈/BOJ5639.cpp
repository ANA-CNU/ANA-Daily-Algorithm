#include <iostream>
#include <string>
using namespace std;

struct Node {
    Node* parent = nullptr;
    Node* left = nullptr;
    Node* right = nullptr;

    int data = 0;
};

class BinTree {
public:
    Node* root = nullptr;

    void insert(int data);
};

void BinTree::insert(int data) {
    Node* newNode = new Node();
    newNode->data = data;

    if (root == nullptr) {
        root = newNode;
        return;
    }

    Node* curNode = root;
    Node* parentNode = nullptr;

    while (curNode) {
        parentNode = curNode;
        if (data < curNode->data)
            curNode = curNode->left;
        else
            curNode = curNode->right;
    }

    newNode->parent = parentNode;
    if (data < parentNode->data)
        parentNode->left = newNode;
    else
        parentNode->right = newNode;
}

void postOrder(Node* node) {
    if (node == nullptr) return;

    postOrder(node->left);
    postOrder(node->right);
    cout << node->data << "\n";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string input;
    int n;

    BinTree bst;
    
    while (cin >> input && input != "") {
        n = stoi(input);

        bst.insert(n);
    }

    postOrder(bst.root);
}