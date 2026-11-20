#include <iostream>
using namespace std;

struct Node {
    int roll;
    char name[20];
    float marks;
    Node *next;
};

Node *head = NULL;

void create() {
    Node *t = new Node;
    cin >> t->roll >> t->name >> t->marks;
    t->next = NULL;

    if (head == NULL)
        head = t;
    else {
        Node *p = head;
        while (p->next != NULL)
            p = p->next;
        p->next = t;
    }
}

void insert(int pos) {
    Node *t = new Node;
    cin >> t->roll >> t->name >> t->marks;

    if (pos == 1) {
        t->next = head;
        head = t;
        return;
    }

    Node *p = head;
    for (int i = 1; i < pos - 1 && p != NULL; i++)
        p = p->next;

    if (p == NULL) return;

    t->next = p->next;
    p->next = t;
}

void del(int pos) {
    Node *p = head;

    if (p == NULL) return;

    if (pos == 1) {
        head = p->next;
        delete p;
        return;
    }

    for (int i = 1; i < pos - 1 && p != NULL; i++)
        p = p->next;

    if (p == NULL || p->next == NULL) return;

    Node *t = p->next;
    p->next = t->next;
    delete t;
}

void display() {
    Node *p = head;
    while (p != NULL) {
        cout << p->roll << " " << p->name << " " << p->marks << endl;
        p = p->next;
    }
}

void search(int x) {
    Node *p = head;
    while (p != NULL) {
        if (p->roll == x) {
            cout << "Found";
            return;
        }
        p = p->next;
    }
    cout << "Not Found";
}

int main() {
    int ch, pos, x;

    do {
        cout << "\n1.Create 2.Insert 3.Delete 4.Display 5.Search 6.Exit\n";
        cin >> ch;

        if (ch == 1) create();
        if (ch == 2) { cin >> pos; insert(pos); }
        if (ch == 3) { cin >> pos; del(pos); }
        if (ch == 4) display();
        if (ch == 5) { cin >> x; search(x); }

    } while (ch != 6);
}