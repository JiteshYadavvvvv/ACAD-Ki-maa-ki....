
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node *left, *right;
};

Node* insert(Node* root, int x) {
    if (root == NULL) {
        Node* t = new Node{x, NULL, NULL};
        return t;
    }
    if (x < root->data)
        root->left = insert(root->left, x);
    else if (x > root->data)
        root->right = insert(root->right, x);
    return root;
}

Node* minNode(Node* root) {
    while (root->left != NULL)
        root = root->left;
    return root;
}

Node* del(Node* root, int x) {
    if (root == NULL) return root;

    if (x < root->data)
        root->left = del(root->left, x);
    else if (x > root->data)
        root->right = del(root->right, x);
    else {
        if (root->left == NULL) return root->right;
        if (root->right == NULL) return root->left;

        Node* t = minNode(root->right);
        root->data = t->data;
        root->right = del(root->right, t->data);
    }
    return root;
}

void inorder(Node* root) {
    if (root == NULL) return;
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}

void preorder(Node* root) {
    if (root == NULL) return;
    cout << root->data << " ";
    preorder(root->left);
    preorder(root->right);
}

void search(Node* root, int x) {
    if (root == NULL) {
        cout << "Not Found";
        return;
    }
    if (root->data == x) cout << "Found";
    else if (x < root->data) search(root->left, x);
    else search(root->right, x);
}

int main() {
    Node* root = NULL;
    int ch, x;

    do {
        cout << "\n1.Insert 2.Delete 3.Inorder 4.Preorder 5.Search 6.Exit\n";
        cin >> ch;

        switch (ch) {
            case 1: cin >> x; root = insert(root, x); break;
            case 2: cin >> x; root = del(root, x); break;
            case 3: inorder(root); break;
            case 4: preorder(root); break;
            case 5: cin >> x; search(root, x); break;
        }
    } while (ch != 6);
}
