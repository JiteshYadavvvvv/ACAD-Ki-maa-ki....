
#include <iostream>
using namespace std;

int h[10];

void insert(int x) {
    int i = x % 10, start = i;

    while (h[i] != -1) {
        i = (i + 1) % 10;
        if (i == start) {
            cout << "Table Full";
            return;
        }
    }

    h[i] = x;
}

void search(int x) {
    int i = x % 10, start = i;

    while (h[i] != -1) {
        if (h[i] == x) {
            cout << "Found at " << i;
            return;
        }
        i = (i + 1) % 10;
        if (i == start) break;
    }

    cout << "Not Found";
}

void display() {
    for (int i = 0; i < 10; i++)
        cout << i << " : " << h[i] << endl;
}

int main() {
    int ch, x;

    for (int i = 0; i < 10; i++)
        h[i] = -1;

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
