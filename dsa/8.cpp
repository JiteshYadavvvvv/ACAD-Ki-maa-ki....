#include <iostream>
using namespace std;

class Stack {
    char s[100];
    int top;

public:
    Stack() {
        top = -1;
    }

    void push(char x) {
        s[++top] = x;
    }

    char pop() {
        return s[top--];
    }

    bool empty() {
        return top == -1;
    }

    bool check(char exp[]) {
        for (int i = 0; exp[i] != '\0'; i++) {
            char x = exp[i];

            if (x == '(' || x == '{' || x == '[')
                push(x);

            else if (x == ')' || x == '}' || x == ']') {
                if (empty()) return false;

                char y = pop();

                if ((x == ')' && y != '(') ||
                    (x == '}' && y != '{') ||
                    (x == ']' && y != '['))
                    return false;
            }
        }

        return empty();
    }
};

int main() {
    Stack st;
    char exp[100];

    cout << "Enter expression: ";
    cin >> exp;

    if (st.check(exp))
        cout << "Balanced";
    else
        cout << "Not Balanced";
}