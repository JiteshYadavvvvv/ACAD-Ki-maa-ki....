
#include <iostream>
using namespace std;

int convert(int a[][10], int r, int c, int t[][3]) {
    int k = 1;
    t[0][0] = r;
    t[0][1] = c;

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (a[i][j] != 0) {
                t[k][0] = i;
                t[k][1] = j;
                t[k][2] = a[i][j];
                k++;
            }

    t[0][2] = k - 1;
    return k;
}

void add(int a[][3], int b[][3], int c[][3]) {
    int i = 1, j = 1, k = 1;

    c[0][0] = a[0][0];
    c[0][1] = a[0][1];

    while (i <= a[0][2] && j <= b[0][2]) {
        if (a[i][0] == b[j][0] && a[i][1] == b[j][1]) {
            int sum = a[i][2] + b[j][2];
            if (sum != 0) {
                c[k][0] = a[i][0];
                c[k][1] = a[i][1];
                c[k][2] = sum;
                k++;
            }
            i++;
            j++;
        }
        else if (a[i][0] < b[j][0] ||
                (a[i][0] == b[j][0] && a[i][1] < b[j][1])) {
            c[k][0] = a[i][0];
            c[k][1] = a[i][1];
            c[k][2] = a[i][2];
            i++;
            k++;
        }
        else {
            c[k][0] = b[j][0];
            c[k][1] = b[j][1];
            c[k][2] = b[j][2];
            j++;
            k++;
        }
    }

    while (i <= a[0][2]) {
        c[k][0] = a[i][0];
        c[k][1] = a[i][1];
        c[k][2] = a[i][2];
        i++;
        k++;
    }

    while (j <= b[0][2]) {
        c[k][0] = b[j][0];
        c[k][1] = b[j][1];
        c[k][2] = b[j][2];
        j++;
        k++;
    }

    c[0][2] = k - 1;
}

void display(int t[][3]) {
    for (int i = 0; i <= t[0][2]; i++)
        cout << t[i][0] << " " << t[i][1] << " " << t[i][2] << endl;
}

int main() {
    int a[10][10], b[10][10];
    int t1[101][3], t2[101][3], t3[201][3];
    int r, c;

    cout << "Enter rows and columns: ";
    cin >> r >> c;

    cout << "Enter first matrix:\n";
    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            cin >> a[i][j];

    cout << "Enter second matrix:\n";
    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            cin >> b[i][j];

    convert(a, r, c, t1);
    convert(b, r, c, t2);

    add(t1, t2, t3);

    cout << "\nResult in Triplet Representation:\n";
    display(t3);
}
