#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    int k, n;
    int cnt = 1;
    
    cin >> k;

    stack<int> s;
    string result;
    
    while (k-- > 0) {
        cin >> n;

        while (cnt <= n) {
            s.push(cnt++);
            result += "+\n";
        }

        if (s.top() == n) {
            s.pop();
            result += "-\n";
        }
        else {
            cout << "NO";
            return 0;
        }
    }

    cout << result;
}
