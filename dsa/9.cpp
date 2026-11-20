#include <iostream>
using namespace std;

char s[100];
int top = -1;

void push(char x) {
    s[++top] = x;
}

char pop() {
    return s[top--];
}

int priority(char x) {
    if (x == '^') return 3;
    if (x == '*' || x == '/') return 2;
    if (x == '+' || x == '-') return 1;
    return 0;
}

int main() {
    char in[100], post[100];
    int j = 0;

    cout << "Enter infix: ";
    cin >> in;

    for (int i = 0; in[i] != '\0'; i++) {
        char x = in[i];

        if (isalnum(x))
            post[j++] = x;

        else if (x == '(')
            push(x);

        else if (x == ')') {
            while (top != -1 && s[top] != '(')
                post[j++] = pop();
            if (top != -1) pop();
        }

        else {
            while (top != -1 && priority(s[top]) >= priority(x))
                post[j++] = pop();
            push(x);
        }
    }

    while (top != -1)
        post[j++] = pop();

    post[j] = '\0';
    cout << "Postfix: " << post;
}