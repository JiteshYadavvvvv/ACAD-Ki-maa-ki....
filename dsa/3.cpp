#include <iostream>
using namespace std;

void insertion(float a[], int n) {
    int c = 0, s = 0;

    for (int i = 1; i < n; i++) {
        int j = i;

        while (j > 0) {
            c++;
            if (a[j] < a[j-1]) {
                swap(a[j], a[j-1]);
                s++;
                j--;
            }
            else break;
        }

        for (int k = 0; k < n; k++)
            cout << a[k] << " ";
        cout << endl;
    }

    cout << "Comparisons: " << c << "\nSwaps: " << s << endl;
}

void bubble(float a[], int n) {
    int c = 0, s = 0;

    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            c++;
            if (a[j] > a[j+1]) {
                swap(a[j], a[j+1]);
                s++;
            }
        }

        for (int k = 0; k < n; k++)
            cout << a[k] << " ";
        cout << endl;
    }

    cout << "Comparisons: " << c << "\nSwaps: " << s << endl;
}

int main() {
    float a[50], b[50];
    int n;

    cout << "Enter number of employees: ";
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
        b[i] = a[i];
    }

    cout << "\nInsertion Sort:\n";
    insertion(a, n);

    cout << "\nBubble Sort:\n";
    bubble(b, n);
}