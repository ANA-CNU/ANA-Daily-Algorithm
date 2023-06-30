#include <iostream>
#include <queue>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int n, k;
    cin >> k;

    priority_queue<int> pq;

    while (k-- > 0) {
        cin >> n;

        if (n == 0) {
            if (pq.empty())
                cout << 0 << "\n";
            else {
                cout << pq.top() << "\n";
                pq.pop();
            }
        }
        else
            pq.push(n);
    }
}