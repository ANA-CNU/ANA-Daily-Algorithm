#include <iostream>
#include <queue>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
        
    int k, tmp, qsize, a, cnt;
    cin >> k;
    
    while (k-- > 0) {
        queue<pair<int,int>> q;
        priority_queue<int> pq;
        
        cin >> qsize >> a;
        for (int i = 0; i < qsize; i++) {
            cin >> tmp;
            pq.push(tmp);
            q.push({ i,tmp });
        }
        cnt = 1;

        while (!q.empty()) {
            if (q.front().second == pq.top()) {
                if (q.front().first == a) break;
                q.pop();
                pq.pop();
                cnt++;
            }
            else {
                q.push(q.front());
                q.pop();
            }
        }

        cout << cnt << "\n";
    }
}