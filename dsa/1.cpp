
#include <iostream>
using namespace std;

int linear(int a[], int n, int x) {
    for (int i = 0; i < n; i++)
        if (a[i] == x)
            return i;
    return -1;
}

int binary(int a[], int n, int x) {
    int l = 0, r = n - 1;

    while (l <= r) {
        int m = (l + r) / 2;

        if (a[m] == x) return m;
        else if (x < a[m]) r = m - 1;
        else l = m + 1;
    }

    return -1;
}

int main() {
    int a[100], n, x;

    cout << "Enter number of IDs: ";
    cin >> n;

    cout << "Enter IDs in ascending order:\n";
    for (int i = 0; i < n; i++)
        cin >> a[i];

    cout << "Enter ID to search: ";
    cin >> x;

    int p = linear(a, n, x);
    if (p == -1) cout << "Linear: Not Found\n";
    else cout << "Linear: Found at position " << p + 1 << endl;

    p = binary(a, n, x);
    if (p == -1) cout << "Binary: Not Found";
    else cout << "Binary: Found at position " << p + 1;
}
