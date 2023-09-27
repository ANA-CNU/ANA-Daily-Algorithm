#include <iostream>
#include <string>
#include <stack>
using namespace std;

int level(char c) {
    if (c == '+' || c == '-')
        return 1;
    else if (c == '*' || c == '/')
        return 2;
    else
        return 0;
}

string to_postfix(string src) {
    stack<char> s;
    char c;
    string dst;
    
    for (int i = 0; i < src.length(); i++) {
        c = src[i];
        
        if ('A' <= c && c <= 'Z')
            dst += c;
        else if (c == '(') {
            s.push(c);
        }
        else if (c == ')') {
            while (!s.empty() && s.top() != '(') {
                dst += s.top();
                s.pop();
            }
            s.pop();
        }
        else {
            while (!s.empty() && level(c) <= level(s.top())) {
                dst += s.top();
                s.pop();
            }

            s.push(c);
        }
    }

    while (!s.empty()) {
        dst += s.top();
        s.pop();
    }

    return dst;
}

int main() {
    string src;
    cin >> src;
    
    cout << to_postfix(src);
}