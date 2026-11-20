
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

Node* h[10] = {NULL};

void insert(int x) {
    int i = x % 10;
    Node* t = new Node{x, h[i]};
    h[i] = t;
}

void search(int x) {
    int i = x % 10;
    Node* t = h[i];

    while (t != NULL) {
        if (t->data == x) {
            cout << "Found";
            return;
        }
        t = t->next;
    }

    cout << "Not Found";
}

void display() {
    for (int i = 0; i < 10; i++) {
        cout << i << " : ";
        Node* t = h[i];

        while (t != NULL) {
            cout << t->data << " -> ";
            t = t->next;
        }

        cout << "NULL\n";
    }
}

int main() {
    int ch, x;

    do {
        cout << "\n1.Insert 2.Search 3.Display 4.Exit\n";
        cin >> ch;

        switch (ch) {
            case 1: cin >> x; insert(x); break;
            case 2: cin >> x; search(x); break;
            case 3: display(); break;
        }
    } while (ch != 4);
}
