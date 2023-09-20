#include <iostream>
#include <algorithm>
#include <queue>
 
using namespace std;
using pii = pair<int, int>;

int N;
bool visited[1000001];
int trace[1000001];
char digits[1000001];

string trace_back() {
    string temp = "";
    for (int i = 0; i != -1; i = trace[i]) temp = digits[i] + temp;
    return temp;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    int T; cin >> T;
    while(T--) {
        queue<int> q;
        cin >> N;

        if (N == 1) {
            cout << "1\n";
            continue;
        }

        fill(visited, visited+N, 0);
        fill(trace, trace+N, -1);
        fill(digits, digits+N, ' ');

        visited[1] = 1;
        digits[1] = '1';
        trace[1] = -1;
        q.push(1);
        string ans;

        while (!q.empty()) {
            int cur = q.front();
            q.pop();

            for (int n = 0; n < 2; n++) {
                int next = (cur*10+n)%N;
                if (!visited[next]) {
                    digits[next] = n+'0';
                    visited[next] = 1;
                    trace[next] = cur;

                    q.push(next);
                }
            }

            if (visited[0]) break;
        }

        cout << trace_back() << '\n';
    }

    return 0;
}