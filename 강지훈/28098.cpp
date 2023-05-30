#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

#define INF 1000000001LL

using namespace std;
using ll = long long;
using Point = pair<ll, ll>;

Point points[500000];
Point root(INF, INF);
vector<Point> hull;

int CCW(Point p1, Point p2, Point p3) {
    ll S = p1.first*p2.second + p2.first*p3.second + p3.first*p1.second;
    S -= p1.second*p2.first + p2.second*p3.first + p3.second*p1.first;
    return S == 0 ? 0 : S < 0 ? -1 : 1;
}

ll distance(Point p1, Point p2) {
    return (p1.first-p2.first)*(p1.first-p2.first) + (p1.second-p2.second)*(p1.second-p2.second);
}

bool cmp(Point p1, Point p2) {
    int ccw = CCW(root, p1, p2);
    if (ccw == 0) {
        ll d1 = distance(root, p1), d2 = distance(root, p2);
        return d1 < d2;
    }
    return ccw > 0;
}

void setConvexHull(int N) {
    sort(points, points + N, cmp);
    stack<Point> st;
    st.push(points[0]);
    
    for (int i = 1; i < N; i++) {
        Point cur = points[i];

        while(st.size() > 1) {
            Point pre = st.top(); st.pop();
            Point ppre = st.top();

            int ccw = CCW(ppre, pre, cur);
            if (ccw > 0) {
                st.push(pre);
                break;
            }
        }
        
        st.push(cur);
    }

    while (!st.empty()) {
        hull.push_back(st.top());
        st.pop();
    }
}

bool isPossible(int x0, int y0) {
    int N = hull.size();
    Point p(x0, y0);

    if (N == 1 || N == 2) return true;

    hull.push_back(hull[0]);
    for (int i = 1; i < N + 1; i++) {
        if (CCW(hull[i - 1], hull[i], p) >= 0) return true;
    }
    return false;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    int N; cin >> N;
    for (int i = 0; i < N; i++) {
        ll x, y; cin >> x >> y;
        points[i] = Point(x, y);

        if (root.second >= y) {
            if (root.second == y && root.first > x || root.second > y) {
                root = Point(x, y);
            } 
        }
    }
    
    setConvexHull(N);

    if (isPossible(0, 0)) cout << "Yes";
    else cout << "No";

    return 0;
}