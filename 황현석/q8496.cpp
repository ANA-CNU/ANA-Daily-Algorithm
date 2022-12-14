#include<bits/stdc++.h>
#define MAX 101010
#define x first
#define y second

using namespace std;

int N, M;

typedef pair<int, int> pp;
typedef long long ll;

struct sccMaker{
    vector<int> seed, load[MAX], re[MAX], stack;
    int mySCC[MAX], visit[MAX];

    void addEdge (int from, int go) {
        load[from].push_back(go);
        re[go].push_back(from);

        seed.push_back(from);
        seed.push_back(go);
    }

    void clear () {
        for (int & i : seed) {
            mySCC[i] = visit[i] = 0;
            load[i].clear(); re[i].clear();
        }

        stack.clear();
        seed.clear();
    }

    void function () {
        for (int & i : seed) {
            if (!visit[i]) dfs(i);
        }

        reverse(begin(stack), end(stack));
        int cnt = 1;

        for (int & i : stack) {
            if (!mySCC[i]) dfs2(i, -1, cnt++);
        }
    }

    void dfs (int node, int prev = -1) {
        visit[node] = 1;

        for (int & i : load[node]) if (i != prev) {
                if (!visit[i]) dfs(i, node);

            }

        stack.push_back(node);
    }

    void dfs2 (int node, int prev, int mySccNum) {
        mySCC[node] = mySccNum;

        for (int & i : re[node]) if (i != prev){
                if (!mySCC[i]) dfs2(i, node, mySccNum);
            }
    }

    bool isSame (int n1, int n2) {
        if (!mySCC[n1] || !mySCC[n2]) return false;
        return mySCC[n1] == mySCC[n2];
    }
};

ll nowAnswer = 0;
ll parent[MAX], indegree[MAX];

int find (int node) {
    if (parent[node] == node) return node;
    return parent[node] = find(parent[node]);
}

void unions (int n1, int n2) {
    int p1 = find(n1), p2 = find(n2);

    if (p1 == p2) return;


    indegree[p1] += indegree[p2];
    parent[p2] = p1;
}

int from[MAX], go[MAX];
vector<int> answer[MAX];

sccMaker scc;

void dnc (int l, int r, vector<int> & edges) {
    if (l == r) {
        for (int & i : edges) unions(from[i], go[i]);
        for (int & i : edges) answer[l].push_back(i);
        return;
    }

    int mid = l + r >> 1;
    scc.clear();

    for (int & i : edges) {
        if (i <= mid) scc.addEdge(find(from[i]), find(go[i]));
        // i는 시간순서 일 뿐, 합치는건 유파로 최적화 되어있는 집함들임.
        // if (i > mid) break;
    }

    scc.function();

    vector<int> left, right;
    for (int & i : edges) {
        if (scc.isSame(find(from[i]), find(go[i]))) {
            left.push_back(i);
        } else {
            right.push_back(i);
        }
    }

    dnc(l, mid, left);
    dnc(mid+1, r, right);
}


vector<pp> pairs;
vector<int> edges, inputs;

int in[MAX], ans[MAX];


int main () {
    cin.tie(nullptr); ios_base::sync_with_stdio(false);
    cin >> N >> M;

    for (int i=0;i<MAX;i++) {
        parent[i] = i;
        indegree[i] = 0;
    }

    int n1, n2;

    for (int i=0;i<M;i++) {
        cin >> n1 >> n2;
        pairs.push_back(make_pair(n1, n2));
    }

    int Q, idx;
    cin >> Q;


    for (int i=0;i<Q;i++) {
        cin >> idx;
        from[M-1-i] = pairs[idx-1].x;
        go[M-1-i] = pairs[idx-1].y;

        in[idx-1] = 1;
    }

    for (int i=0,j=0;i<M;i++) {
        if (!in[i]) {
            from[j] = pairs[i].x;
            go[j] = pairs[i].y;
            j++;
        }
    }

    vector<int> edges;
    for (int i=0;i<M;i++) edges.push_back(i);

    dnc(0, M, edges);
    nowAnswer = N;
    for (int i=0;i<MAX;i++) {
        parent[i] = i;
        indegree[i] = in[i] = 0;
    }

    for (int i=0;i<M;i++) {
        ans[i] = nowAnswer;

        if (find(from[i]) != find(go[i])) {
            in[i] = 1;
            if (indegree[find(go[i])]++ == 0) {
                nowAnswer--;
            }
        }

        for (int & j : answer[i]) {
            if (!in[j]) continue;

            unions(from[j], go[j]);

            if (--indegree[find(go[j])] == 0) {
                nowAnswer++;
            }
        }
    }


    for (int i=M-1;i>=M-Q;i--) {
        cout << ans[i] << '\n';
    }
}
