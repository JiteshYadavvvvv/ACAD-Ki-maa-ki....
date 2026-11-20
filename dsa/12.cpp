
#include <iostream>
using namespace std;

int p[10];

int find(int x) {
    while (p[x] != x)
        x = p[x];
    return x;
}

int main() {
    int n, e, u[20], v[20], w[20], t, cost = 0;

    cout << "Enter vertices and edges: ";
    cin >> n >> e;

    for (int i = 0; i < n; i++)
        p[i] = i;

    cout << "Enter edges and weights:\n";
    for (int i = 0; i < e; i++)
        cin >> u[i] >> v[i] >> w[i];

    for (int i = 0; i < e; i++)
        for (int j = i + 1; j < e; j++)
            if (w[i] > w[j]) {
                t = w[i]; w[i] = w[j]; w[j] = t;
                t = u[i]; u[i] = u[j]; u[j] = t;
                t = v[i]; v[i] = v[j]; v[j] = t;
            }

    cout << "Selected edges:\n";

    for (int i = 0, count = 0; i < e && count < n - 1; i++) {
        int a = find(u[i]), b = find(v[i]);

        if (a != b) {
            cout << u[i] << " - " << v[i] << " : " << w[i] << endl;
            p[a] = b;
            cost += w[i];
            count++;
        }
    }

    cout << "Minimum cost = " << cost;
}
