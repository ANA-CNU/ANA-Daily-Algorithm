#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    int k, n;
    queue<int> q;
    string input;
    
    cin >> k;

    while (k-- > 0) {
        cin >> input;
        if (input == "push") {
            cin >> n;
            q.push(n);
        }
        else if (input == "front")
            if (q.empty())
                cout << -1 << "\n";
            else
                cout << q.front() << "\n";
        else if (input == "back")
            if (q.empty())
                cout << -1 << "\n";
            else
                cout << q.back() << "\n";
        else if (input == "size")
            cout << q.size() << "\n";
        else if (input == "empty")
            if (q.empty())
                cout << 1 << "\n";
            else
                cout << 0 << "\n";
        else if (input == "pop") {
            if (q.empty())
                cout << -1 << "\n";
            else {
                cout << q.front() << "\n";
                q.pop();
            }
        }
        
    }
}