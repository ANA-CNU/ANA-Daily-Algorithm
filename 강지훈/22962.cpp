#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <cmath>

#define x first
#define y second

using namespace std;
using ll = long long;
using point = pair<ll,ll>;

int N;
point arr[500000];
point root(1000000001, 1000000001);
vector<point> hull;

ll gcd(ll a, ll b) {
    return b==0 ? a : gcd(b, a%b);
}

ll ccw(point p1, point p2, point p3) {
    ll S = p1.x*p2.y+p2.x*p3.y+p3.x*p1.y;
    S -= p1.y*p2.x+p2.y*p3.x+p3.y*p1.x;
    return S;
}

int ccwd(point p1, point p2, point p3) {
    ll S = ccw(p1, p2, p3);
    if (S == 0) return 0;
    return S/abs(S);
}

ll powdis(point p1, point p2) {
    return (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);
}

bool cmp(point p1, point p2) {
    int S = ccwd(root, p1, p2);
    if (S == 0) return powdis(root, p1) < powdis(root, p2);
    return S < 0;
}

void convex() {
    stack<point> st;

    for (int i = 0; i < N; i++) {
        point cur = arr[i];

        while (st.size() > 1) {
            point pre = st.top();
            st.pop();
            point ppre = st.top();

            if (ccwd(ppre, pre, cur) < 0) {
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

ll area() {
    ll S = 0;
    for (int i = 2; i < N; i++) {
        S += ccw(hull[0], hull[i-1], hull[i]);
    }
    return S;
}

ll edges() {
    ll d = N;

    for (int i = 1; i < N; i++) {
        ll dx = abs(hull[i-1].x-hull[i].x), dy = abs(hull[i-1].y-hull[i].y);
        d += gcd(dx, dy)-1;
    }
    
    ll dx = abs(hull[N-1].x-hull[0].x), dy = abs(hull[N-1].y-hull[0].y);
    d += gcd(dx, dy) - 1;

    return d;
}

bool dequal(double d1, double d2) {
    double d = abs(d1-d2);
    return d < 1e-9;
}

bool bin_search(int l, int r, point p) {
    if (l+1 == r) {
        return ccwd(hull[l], hull[r], p) >= 0;
    }

    int mid = (l+r)/2;
    int S = ccwd(hull[0], hull[mid], p);
    if (S == 0) return bin_search(mid, mid+1, p);
    else if (S > 0) return bin_search(mid, r, p);
    else return bin_search(l, mid, p);
}

bool isIn(point p) {
    if (N == 1) {
        return p == root;
    } else if (N == 2) {
        if (ccwd(hull[0], hull[1], p) != 0) return false;
        int x1 = hull[0].x, y1 = hull[0].y, x2 = hull[1].x, y2 = hull[1].y;
        return min(x1,x2) <= p.x && p.x <= max(x1,x2) && min(y1,y2) <= p.y && p.y <= max(y1,y2);
    } else {
        if (ccwd(hull[0], hull[1], p) < 0 || ccwd(hull[0], hull[N-1], p) > 0) {
            return false;
        }
        return bin_search(1, N-1, p);
    }
}
 
int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    int M;
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        int x0, y0; cin >> x0 >> y0;
        arr[i] = point(x0, y0);
        if (root.y > arr[i].y) {
            root = arr[i];
        } else if (root.y == arr[i].y && root.x > arr[i].x) {
            root = arr[i];
        }
    }

    sort(arr, arr+N, cmp);
    convex();
    N = hull.size();
    
    ll S = abs(area());
    ll d = edges();
    
    ll ans = S/2+1+d/2+(S%2);
    
    while (M--) {
        int x0, y0; cin >> x0 >> y0;
        point p = point(x0, y0);

        if (isIn(p)) {
            --ans;
        }
    }

    cout << ans;

    return 0;
}