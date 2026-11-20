#include <iostream>
using namespace std;

int s[100], top = -1;

void push(int x) {
    s[++top] = x;
}

int pop() {
    return s[top--];
}

int main() {
    char exp[100];
    cout << "Enter postfix: ";
    cin >> exp;

    for (int i = 0; exp[i] != '\0'; i++) {
        char x = exp[i];

        if (x >= '0' && x <= '9')
            push(x - '0');

        else {
            int b = pop();
            int a = pop();

            if (x == '+') push(a + b);
            if (x == '-') push(a - b);
            if (x == '*') push(a * b);
            if (x == '/') push(a / b);
        }
    }

    cout << "Result: " << pop();
}