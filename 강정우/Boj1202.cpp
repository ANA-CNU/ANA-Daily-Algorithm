#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    int n, k;
    long result = 0;
    cin >> n >> k;
    vector<pair<int, int>> items(n);
    vector<int> bags(k);
    for (int i = 0; i < n; ++i) {
        cin >> items[i].first >> items[i].second;
    }
    for (int i = 0; i < k; ++i) {
        cin >> bags[i];
    }
    sort(items.begin(), items.end());
    sort(bags.begin(), bags.end());
    priority_queue<int> pq;
    int itemIndex = 0;
    for (int i = 0; i < k; ++i) {
        while (itemIndex < n && items[itemIndex].first <= bags[i]) {
            pq.push(items[itemIndex].second);
            ++itemIndex;
        }
        if (!pq.empty()) {
            result += pq.top();
            pq.pop();
        }
    }
    cout << result;
    return 0;
}
