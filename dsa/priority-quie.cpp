
#include <iostream>
using namespace std;

struct Item {
    int data, priority;
};

Item h[100];
int n = 0;

void insert(int x, int p) {
    int i = n++;
    h[i].data = x;
    h[i].priority = p;

    while (i > 0 && h[i].priority > h[(i-1)/2].priority) {
        Item t = h[i];
        h[i] = h[(i-1)/2];
        h[(i-1)/2] = t;
        i = (i-1)/2;
    }
}

void del() {
    if (n == 0) {
        cout << "Empty";
        return;
    }

    cout << "Deleted: " << h[0].data;
    h[0] = h[--n];

    int i = 0;

    while (2*i+1 < n) {
        int j = 2*i+1;

        if (j+1 < n && h[j+1].priority > h[j].priority)
            j++;

        if (h[i].priority >= h[j].priority) break;

        Item t = h[i];
        h[i] = h[j];
        h[j] = t;

        i = j;
    }
}

void search(int x) {
    for (int i = 0; i < n; i++) {
        if (h[i].data == x) {
            cout << "Found";
            return;
        }
    }
    cout << "Not Found";
}

void display() {
    for (int i = 0; i < n; i++)
        cout << h[i].data << "(" << h[i].priority << ") ";
}

int main() {
    int ch, x, p;

    do {
        cout << "\n1.Insert 2.Delete 3.Search 4.Display 5.Exit\n";
        cin >> ch;

        switch (ch) {
            case 1: cin >> x >> p; insert(x, p); break;
            case 2: del(); break;
            case 3: cin >> x; search(x); break;
            case 4: display(); break;
        }
    } while (ch != 5);
}
