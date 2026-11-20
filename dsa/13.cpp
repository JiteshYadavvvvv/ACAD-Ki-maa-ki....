
#include <iostream>
using namespace std;

int main() {
    int n, a[10][10], vis[10] = {0};
    int min, u, v, cost = 0;

    cout << "Enter vertices: ";
    cin >> n;

    cout << "Enter adjacency matrix:\n";
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
            cin >> a[i][j];
            if (a[i][j] == 0) a[i][j] = 999;
        }

    vis[0] = 1;

    for (int k = 0; k < n - 1; k++) {
        min = 999;

        for (int i = 0; i < n; i++)
            if (vis[i])
                for (int j = 0; j < n; j++)
                    if (!vis[j] && a[i][j] < min) {
                        min = a[i][j];
                        u = i;
                        v = j;
                    }

        if (min == 999) {
            cout << "Graph is disconnected";
            return 0;
        }

        cout << u << " - " << v << " : " << min << endl;
        cost += min;
        vis[v] = 1;
    }

    cout << "Minimum cost = " << cost;
}
