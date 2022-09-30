#include <bits/stdc++.h>
#define MAX 500001

using namespace std;

int N;
vector<int> load[MAX], goals[MAX];

int sp[26][MAX] = {0};
int answer[MAX] = {0}, level[MAX] = {0};

struct Box {
    int node, length, idx;
};

Box trains[MAX];

int tight (int node, int rem) {
    for (int i=25;i>=0;i--) {
        if (rem & (1 << i)) node = sp[i][node];
    }
    return node;
}

void clear (int node, int prev) {
    for (int i=0;i<load[node].size();i++) {
        int go = load[node][i];
        if (go == prev) continue;

        sp[0][go] = node;
        level[go] = level[node] + 1;
        clear(go, node);
    }
}

struct cmp1 {
    bool operator()(Box o1, Box o2) {
        return o1.length > o2.length;
    }
};
struct cmp2 {
    bool operator()(Box o1, Box o2) {
        return level[o1.node] > level[o2.node];
    }
};
struct cmp3 {
    bool operator()(Box o1, Box o2) {
        return o1.length < o2.length;
    }
};
struct cmp4 {
    bool operator()(Box o1, Box o2) {
        return level[o1.node] < level[o2.node];
    }
};

Box dfs (int node, int prev) {
    priority_queue<Box, vector<Box>, cmp1> pq;
    priority_queue<Box, vector<Box>, cmp2> remain;
    priority_queue<Box, vector<Box>, cmp3> rtr;
    priority_queue<Box, vector<Box>, cmp4> notused;

    for (int i=0;i<load[node].size();i++) {
        int go = load[node][i];
        if (go == prev) continue;

        Box temp = dfs(go, node);
        if (temp.length == -1) {
            remain.push(temp);
        } else if (temp.length == 0){
            answer[temp.idx] = node;
        } else {
            pq.push(temp);
        }
    }

    for (int i=0;i<goals[node].size();i++) {
        pq.push(trains[goals[node][i]]);
    }

    while(!remain.empty() && (rtr.size() + pq.size() > 0)) {
        Box re = remain.top();
        remain.pop();

        int rem = level[re.node] - level[node];

        while(!pq.empty()) {
            Box tr = pq.top();

            if (rem >= tr.length) {
                rtr.push(tr);
                pq.pop();
            } else {
                break;
            }
        }

        if (!rtr.empty()) {
            Box k = rtr.top();
            rtr.pop();

            answer[k.idx] = tight(re.node, rem - k.length);
        } else {
            notused.push(re);
        }
    }

    if (rtr.size() + pq.size() > 1) {
        Box f;
        f.length = 2000000;
        return f;
    }

    if (pq.size() == 1) {
        Box r = pq.top();
        r.length = r.length - 1;
        return r;
    }

    if (rtr.size() == 1) {
        Box r = rtr.top();
        r.length = r.length - 1;
        return r;
    }

    if(!remain.empty() || !notused.empty()) {
        while(!remain.empty()) {
            notused.push(remain.top());
            remain.pop();
        }

        return notused.top();
    }

    Box rea;
    rea.length = -1;
    rea.node = node;
    return rea;
}

int main(){
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);

    cin >> N;
    int a, b;
    for (int i=1;i<N;i++) {
        cin >> a>> b;
        load[a].push_back(b);
        load[b].push_back(a);
    }

    clear(1, 0);
    for (int i=1;i<26;i++) {
        for (int j=1;j<=N;j++) {
            sp[i][j] = sp[i-1][sp[i-1][j]];
        }
    }

    int queries;
    cin >> queries;
    for (int i=0;i<queries;i++) {
        cin >> a >> b;
        trains[i].node = a;
        trains[i].length = b;
        trains[i].idx = i;
        goals[a].push_back(i);
    }


    Box k = dfs(1, 0);
    if (k.length >= 0) {
        cout << "NO\n";
        return 0;
    }


    cout << "YES\n";
    for (int i=0;i<queries;i++) {
        cout << trains[i].node << ' ' << answer[i] << '\n';
    }

    return 0;
}
