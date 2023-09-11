#include <iostream>
#include <queue>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, n;
    float x;
    priority_queue<int, vector<int>, greater<int>> pq;
    priority_queue<int, vector<int>, greater<int>> npq;

    cin >> k;

    while (k-- > 0) {
        cin >> n;
        if (n != 0) {
            if (n > 0)
                pq.push(n);
            else
                npq.push(-n);
        }
        else {
            if (pq.empty() && npq.empty()) {
                cout << 0 << "\n";
            }
            else if (npq.empty()) {
                cout << pq.top() << "\n";
                pq.pop();
            }
            else if (pq.empty()) {
                cout << -npq.top() << "\n";
                npq.pop();
            }
            else if (pq.top() < npq.top()) {
                cout << pq.top() << "\n";
                pq.pop();
            }
            else if (pq.top() > npq.top()) {
                cout << -npq.top() << "\n";
                npq.pop();
            }
            else {
                cout << -npq.top() << "\n";
                npq.pop();
            }
        }
    }
}