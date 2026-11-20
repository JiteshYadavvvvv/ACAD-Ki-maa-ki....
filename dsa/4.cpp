
#include <iostream>
using namespace std;

int main() {
    int a[10][10], t[100][3], tr[100][3];
    int r, c, k = 0;

    cout << "Enter rows and columns: ";
    cin >> r >> c;

    cout << "Enter matrix:\n";
    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            cin >> a[i][j];

    t[0][0] = r;
    t[0][1] = c;

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (a[i][j] != 0) {
                k++;
                t[k][0] = i;
                t[k][1] = j;
                t[k][2] = a[i][j];
            }

    t[0][2] = k;

    cout << "\nTriplet Representation:\n";
    for (int i = 0; i <= k; i++)
        cout << t[i][0] << " " << t[i][1] << " " << t[i][2] << endl;

    tr[0][0] = c;
    tr[0][1] = r;
    tr[0][2] = k;

    int x = 1;

    for (int j = 0; j < c; j++)
        for (int i = 1; i <= k; i++)
            if (t[i][1] == j) {
                tr[x][0] = t[i][1];
                tr[x][1] = t[i][0];
                tr[x][2] = t[i][2];
                x++;
            }

    cout << "\nTranspose:\n";
    for (int i = 0; i <= k; i++)
        cout << tr[i][0] << " " << tr[i][1] << " " << tr[i][2] << endl;

    return 0;
}
