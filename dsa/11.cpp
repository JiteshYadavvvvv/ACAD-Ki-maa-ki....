
#include <iostream>
using namespace std;

int a[10][10], l[10][10], c[10], vis[10];

void DFS(int v, int n) {
    cout << v << " ";
    vis[v] = 1;

    for (int i = 0; i < n; i++)
        if (a[v][i] && !vis[i])
            DFS(i, n);
}

void BFS(int s) {
    int q[100], f = 0, r = 0, seen[10] = {0};

    q[r++] = s;
    seen[s] = 1;

    while (f < r) {
        int v = q[f++];
        cout << v << " ";

        for (int i = 0; i < c[v]; i++) {
            int x = l[v][i];
            if (!seen[x]) {
                seen[x] = 1;
                q[r++] = x;
            }
        }
    }
}

int main() {
    int n, e, u, v;
    cout << "Enter vertices and edges: ";
    cin >> n >> e;

    for (int i = 0; i < e; i++) {
        cin >> u >> v;
        a[u][v] = a[v][u] = 1;
        l[u][c[u]++] = v;
        l[v][c[v]++] = u;
    }

    cout << "\nAdjacency Matrix:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cout << a[i][j] << " ";
        cout << endl;
    }

    cout << "\nAdjacency List:\n";
    for (int i = 0; i < n; i++) {
        cout << i << " -> ";
        for (int j = 0; j < c[i]; j++)
            cout << l[i][j] << " ";
        cout << endl;
    }

    cout << "\nDFS: ";
    DFS(1, n);

    cout << "\nBFS: ";
    BFS(1);
}
