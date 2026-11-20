#include <iostream>
using namespace std;

struct Node {
    int roll;
    char name[20];
    float marks;
    Node *next;
};

Node *head1 = NULL, *head2 = NULL;

void create(Node *&head) {
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

void insert(Node *&head, int pos) {
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

void del(Node *&head, int pos) {
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

void display(Node *head) {
    Node *p = head;
    while (p != NULL) {
        cout << p->roll << " " << p->name << " " << p->marks << endl;
        p = p->next;
    }
}

void concatenate() {
    if (head1 == NULL) {
        head1 = head2;
        return;
    }

    Node *p = head1;
    while (p->next != NULL)
        p = p->next;

    p->next = head2;
}

int main() {
    int ch, pos;

    do {
        cout << "\n1.Create L1 2.Create L2 3.Insert L1 4.Delete L1";
        cout << "\n5.Display L1 6.Display L2 7.Concatenate 8.Exit\n";
        cin >> ch;

        if (ch == 1) create(head1);
        if (ch == 2) create(head2);
        if (ch == 3) { cin >> pos; insert(head1, pos); }
        if (ch == 4) { cin >> pos; del(head1, pos); }
        if (ch == 5) display(head1);
        if (ch == 6) display(head2);
        if (ch == 7) {
            concatenate();
            cout << "Concatenated List:\n";
            display(head1);
        }

    } while (ch != 8);
}