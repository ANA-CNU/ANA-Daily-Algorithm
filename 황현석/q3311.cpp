#include <bits/stdc++.h>

using namespace std;
#define MAX 300001

typedef pair<int, int> pp;

int N, M, A, B, mn, mx;

vector<pp> starts, goals, realGoals;
vector<int> load[MAX], reverseLoad[MAX];

int up[MAX], down[MAX], myLoc[MAX];
bool ignored[MAX], visits[MAX], isGoal[MAX];

void clear () {
    for (bool & visit : visits) visit = false;
}

bool cmp (pp p1, pp p2) {
    return p1.first < p2.first;
}

void dfs (int node) {
    for (int & go : load[node]) {
        if (!visits[go]) {
            visits[go] = true;
            dfs(go);
        }
    }
}

void dfs2 (int node) {
    for (int & go : reverseLoad[node]) {
        if (!visits[go]) {
            visits[go] = true;
            dfs2(go);
        }
    }
}

void dfs3 (int node) {
    for (int & go : load[node]) {
        if (!visits[go]) {
            visits[go] = true;

            if (isGoal[go]) {
                mn = min(mn, myLoc[go]);
                mx = max(mx, myLoc[go]);
            }

            dfs3(go);
        }
    }
}

int main () {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);

    cin >> N >> M >> A >> B;

    int x, y, m;

    for (int i=1;i<=N;i++) {
        cin >> x >> y;

        if (x == 0) {
            starts.push_back(make_pair(y, i));
        } else if (x == A) {
            goals.push_back(make_pair(y, i));
        }
    }

    for (int i=0;i<M;i++) {
        cin >> x >> y >> m;

        load[x].push_back(y);
        reverseLoad[y].push_back(x);

        if (m == 2) {
            load[y].push_back(x);
            reverseLoad[x].push_back(y);
        }
    }

    for (auto & p : starts) {
        if (!visits[p.second]) {
            visits[p.second] = true;

            dfs(p.second);
        }
    }

    for (auto & p : goals ) {
        if (visits[p.second]) {
            realGoals.push_back(p);
        }
    }

    sort(begin(realGoals), end(realGoals), cmp);
    sort(begin(starts), end(starts), cmp);
    clear();

    for (auto & p : realGoals) {
        if (!visits[p.second]) {
            dfs2(p.second);
        }
    }

    for (int i=0;i<starts.size();i++) {
        ignored[i] = !visits[starts[i].second];
    }

    for (int i=0;i<realGoals.size();i++) {
        myLoc[realGoals[i].second] = i+1;
        isGoal[realGoals[i].second] = true;
    }

    clear();
    mx = 0;

    for (int i=0;i<starts.size();i++) {
        if (!visits[starts[i].second]) {
            visits[starts[i].second] = true;
            dfs3(starts[i].second);
        }

        up[i] = mx;
    }

    clear();
    mn = 1e8;

    for (int i=starts.size()-1;i>=0;i--) {
        if (!visits[starts[i].second]) {
            visits[starts[i].second] = true;
            dfs3(starts[i].second);
        }

        down[i] = mn;
    }



    for (int i=starts.size()-1;i>=0;i--) {
        if (ignored[i]) {
            cout << 0 <<'\n';
        } else {
            cout << up[i] - down[i] + 1<<'\n';
        }
    }



}
