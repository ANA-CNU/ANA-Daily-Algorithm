#include "bits/stdc++.h"
#define int long long
#define INF 987654321

using namespace std;

/**
 * 종빈이는 아주 큰 그룹의 총수다. 이 그룹은 1부터 N번까지의 번호로 구분할 수
있는 N개의 기업을 운영하고 있다. 현재 각 기업은 서로 독립적인 자체 컴퓨팅 및
통신센터를 가지고 있다.

어느 날 종빈이는 계열사의 CTO인 서현이에게 서비스 개선을 위해 각 기업의 서버를
네트워크로 연결하여 단일 통신센터에서 관리 가능한 클러스터 형태로 구성할 것을
제안했다. 종빈이의 제안을 들은 서현이는 다음과 같은 병합 과정을 고안해냈다.

클러스터 A를 제공하는 기존에 존재하는 센터 I를 고른다.
클러스터 B를 제공하는 기업 J를 고른다. B는 A가 아닌 임의의 클러스터이며, J는
센터가 아닐 수 있다. I와 J를 통신 라인으로 연결한다. 이때 기업 I와 J를 잇는
라인의 길이는 |I – J|(mod 1000)이다. 위 방식을 통해 클러스터 A와 B는 새로운
클러스터로 합쳐지며, 이 클러스터는 B의 센터에 의해 제공된다. 이러한 병합 과정을
거치던 중에, 각 기업에서 현재 센터까지 연결되는 라인의 길이가 총 얼마나 되는지에
관한 문의가 들어왔다. 서현이를 위해 병합하는 과정과 그 과정에서 통신센터와 각
기업을 잇는 라인의 길이를 구하는 프로그램을 작성해보자.
*/

vector<int> parent;
vector<int> dist;

int _find(int u) {
    if (u == parent[u]) return u;
    int v = _find(parent[u]);
    dist[u] += dist[parent[u]];
    return parent[u] = v;
}

void _union(int u, int v) {
    dist[u] = abs(u - v) % 1000;
    parent[u] = v;
}

void solve() {
    int n;
    cin >> n;
    parent.resize(n);
    dist.resize(n);

    for (int i = 0; i < n; ++i) {
        dist[i] = 0; // 자기 자신
        parent[i] = i;
    }

    while (true) {
        string cmd;
        cin >> cmd;
        if (cmd == "E") {
            int x;
            cin >> x;
            _find(x);
            cout << dist[x] << '\n';
        }
        else if (cmd == "I") {
            int i, j;
            cin >> i >> j;
            _union(i, j);
        }
        else {
            return;
        }
    }
}

int32_t main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);

    int t;
    cin >> t;
    while (t--) solve();  

    return 0;
}