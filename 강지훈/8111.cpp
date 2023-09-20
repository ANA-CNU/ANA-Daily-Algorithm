#include <iostream>
#include <algorithm>
 
using namespace std;
using pii = pair<int, int>;

int N;
pii dist[101][20000];
bool visited[101][20000];
int pre = 0;

string solve(int i) {
    if (i == 101) return "";

    for (int j = 0; j < N; j++) {
        if (visited[i-1][j]) {
            if (!visited[i][j*10%N]) {
                visited[i][j*10%N] = 1;
                dist[i][j*10%N] = pii(j,0);
                if (j*10%N == 0) {
                    pre = j;
                    return "0";
                }
            }

            if (!visited[i][(j*10+1)%N]) {
                visited[i][(j*10+1)%N] = 1;
                dist[i][(j*10+1)%N] = pii(j,1);
                if ((j*10+1)%N == 0) {
                    pre = j;
                    return "1";
                }
            }
        }
    }
    
    string temp = solve(i+1);
    temp = to_string(dist[i][pre].second) + temp;
    pre = dist[i][pre].first;
    return temp;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    int T; cin >> T;
    while(T--) {
        cin >> N;
        for (int i = 0; i < 101; i++) {
            fill(visited[i], visited[i]+N, 0);
            fill(dist[i], dist[i]+N, pii(0,0));
        }
        visited[1][1] = 1;
        dist[1][1] = pii(0, 1);

        cout << "1" + solve(2) << '\n';
    }

    return 0;
}