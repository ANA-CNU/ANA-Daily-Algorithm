#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

#define inf 1000001

using namespace std;
using ll = long long;
using Point = pair<int, int>;
using Fence = pair<Point, Point>;

vector<int> adj[1000];
vector<vector<Point>> fences;
Point points[1000];
bool visited[1000];
int N, C;

void BtR() {
    for (int i = 0; i < 1000; i++) {
        visited[i] = false;
    }
}

int CCW(Point p1, Point p2, Point p3) {
    ll S = 0;
    S += ((ll) p1.first * p2.second + (ll) p2.first * p3.second + (ll) p3.first * p1.second);
    S -= ((ll) p1.second * p2.first + (ll) p2.second * p3.first + (ll) p3.second * p1.first);

    return S == 0 ? 0 : S < 0 ? -1 : 1;
}

bool isCross(Point p1, Point p2, Point p3, Point p4) {
    int A = CCW(p1, p2, p3), B = CCW(p1, p2, p4);
    int C = CCW(p3, p4, p1), D = CCW(p3, p4, p2);

    return (A * B) < 0 && (C * D) < 0 ? true : false;    
}

bool cmp(vector<Point> v1, vector<Point> v2) {
    Point p1 = v2[0];
    Point p2 = Point(inf, p1.second + 1);

    int cnt = 0, size = v1.size();

    for (int i = 0; i < size - 1; i++) {
        Point p3 = v1[i], p4 = v1[i + 1];
        if (isCross(p1, p2, p3, p4)) ++cnt;
    }
    if (isCross(p1, p2, v1[0], v1[size - 1])) ++cnt;

    if (cnt % 2 == 1) return true;

    return false;
}

void dfs(int cur, int i) {
    visited[cur] = true;
    fences[i].push_back(points[cur]);

    for (int next : adj[cur]) {
        if (!visited[next]) dfs(next, i);
    }
}

void swap(int i, int j) {
    if (i == j) return;
    vector<Point> temp = fences[i];
    fences[i] = fences[j];
    fences[j] = temp;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    BtR();

    int n = 0;
    cin >> N >> C;
    map<Point, int> temp;

    for (int i = 0; i < N; i++) {
        int x1, y1, x2, y2; cin >> x1 >> y1 >> x2 >> y2;
        Point p1 = Point(x1, y1), p2 = Point(x2, y2);

        if (temp.insert(make_pair(p1, n)).second) {
            ++n;
        } if (temp.insert(make_pair(p2, n)).second) {
            ++n;
        }

        int pp1 = temp[p1], pp2 = temp[p2];
        points[pp1] = p1; points[pp2] = p2;
        adj[pp1].push_back(pp2);
        adj[pp2].push_back(pp1);
    }

    int size = 0;
    for (int i = 0; i < N; i++) {
        if (visited[i]) continue;

        fences.push_back(vector<Point>());
        dfs(i, size++);
    }

    for (int i = 0; i < size; i++) {
        int minidx = i;
        for (int j = i + 1; j < size; j++) {
            if (cmp(fences[minidx], fences[j])) minidx = j;
        }
        swap(i, minidx);
    }

    vector<int> ans(size + 1, 0);

    for (int i = 0; i < C; i++) {
        bool flag = true;
        int x, y; cin >> x >> y;
        Point p1(x, y), p2 = Point(inf, y + 1);

        for (int j = 0; j < size; j++) {
            int fsize = fences[j].size(), cnt = 0;

            for (int k = 0; k < fsize - 1; k++) {
                Point p3 = fences[j][k], p4 = fences[j][k + 1];
                if (isCross(p1, p2, p3, p4)) ++cnt;
            }

            Point p3 = fences[j][0], p4 = fences[j][fsize - 1];
            if (isCross(p1, p2, p3, p4)) ++cnt;
            
            if (cnt % 2 == 1) {
                flag = false;
                ++ans[j];
                break;
            }
        }

        if (flag) ++ans[size];
    }

    int M = -1;
    for (int i = 0; i < size + 1; i++) {
        M = max(ans[i], M);
    }

    cout << M;
   
    return 0;
}