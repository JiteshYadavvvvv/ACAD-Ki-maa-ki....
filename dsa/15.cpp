
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

void inorder(Node* root) {
    Node* s[100];
    int top = -1;
    Node* t = root;

    while (t != NULL || top != -1) {
        while (t != NULL) {
            s[++top] = t;
            t = t->left;
        }

        t = s[top--];
        cout << t->data << " ";
        t = t->right;
    }
}

void levelOrder(Node* root) {
    if (root == NULL) return;

    Node* q[100];
    int f = 0, r = 0;
    q[r++] = root;

    while (f < r) {
        Node* t = q[f++];
        cout << t->data << " ";

        if (t->left != NULL) q[r++] = t->left;
        if (t->right != NULL) q[r++] = t->right;
    }
}

void search(Node* root, int x) {
    while (root != NULL) {
        if (root->data == x) {
            cout << "Found";
            return;
        }
        if (x < root->data)
            root = root->left;
        else
            root = root->right;
    }
    cout << "Not Found";
}

int main() {
    Node* root = NULL;
    int ch, x;

    do {
        cout << "\n1.Insert 2.Inorder 3.Level Order 4.Search 5.Exit\n";
        cin >> ch;

        switch (ch) {
            case 1: cin >> x; root = insert(root, x); break;
            case 2: inorder(root); break;
            case 3: levelOrder(root); break;
            case 4: cin >> x; search(root, x); break;
        }
    } while (ch != 5);
}
