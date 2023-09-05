#include <iostream>
#include <string>
#include <vector>
#include <cstring>
#include <climits>
using namespace std;

int visited[100001];
vector<string> vm;
int n;

int dist(string a, string b) {
    int cnt = 0;
    for (int i = 0; i < a.length(); i++)
        if (a[i] != b[i])
            cnt++;

    return cnt;
}

int dist_trio(string a, string b, string c) {
    return dist(a, b) + dist(b, c) + dist(a, c);
}

int min_dist() {
    int mdist = INT_MAX;

    for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++)
            for (int k = j + 1; k < n; k++) {
                mdist = min(mdist, dist_trio(vm[i], vm[j], vm[k]));
                if (mdist == 0)
                    return 0;
            }

    return mdist;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k;
    string buf;

    cin >> k;
    while (k-- > 0) {
        cin >> n;

        for (int i = 0; i < n; i++) {
            cin >> buf;
            vm.push_back(buf);
        }

        if (n > 32)
            cout << 0 << "\n";
        else
            cout << min_dist() << "\n";

        vm.clear();
        memset(visited, 0, sizeof(visited));
    }
}