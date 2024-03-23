#include <iostream>
#include <queue>
#include <unordered_map>
using namespace std;
unordered_map<long, long> m;
long find(long k) {
    if (m.find(k) == m.end())
        return -1;
    return m[k];
}

int main() {
    long a, b;
    cin >> a >> b;
    queue<long> q;
    q.push(a);
    m[a] = 1;
    while (!q.empty()) {
        long x = q.front();
        q.pop();
        long next = x * 2;
        if (next <= b && (m.find(next) == m.end() || m[next] > m[x] + 1)) {
            m[next] = m[x] + 1;
            q.push(next);
        }
        next = 10 * x + 1;
        if (next <= b && (m.find(next) == m.end() || m[next] > m[x] + 1)){
            m[next] = m[x] + 1;
            q.push(next);
        }
    }
    if (m.find(b) == m.end())
        cout << -1;
    else
        cout << m[b];

    return 0;
}
