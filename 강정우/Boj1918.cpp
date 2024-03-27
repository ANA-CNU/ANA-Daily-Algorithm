#include <iostream>
#include <stack>
#include <string>
using namespace std;
int precedence(char c) {
    if(c == '+' || c == '-') return 1;
    if(c == '*' || c == '/') return 2;
    return 0;
}
int main() {
    string s;
    cin >> s;
    stack<char> st;
    string result;
    for(char& c : s) {
        if (c == '(') {
            st.push(c);
        } else if (c == ')') {
            while (!st.empty() && st.top() != '(') {
                result += st.top();
                st.pop();
            }
            if (!st.empty())
                st.pop();
        } else if (c=='+'||c=='-'||c=='*'||c=='/') {
            while (!st.empty() && precedence(st.top()) >= precedence(c)) {
                result += st.top();
                st.pop();
            }
            st.push(c);
        } else{
            result += c;
        }
    }
    while(!st.empty()) {
        result += st.top();
        st.pop();
    }
    cout << result;
}
