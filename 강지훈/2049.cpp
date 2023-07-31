#include <iostream>
#include <algorithm>
#include <cmath>
#include <stack>

using namespace std;
using point = pair<int, int>;

point arr[100000];
stack<point> over, utemp, under;

point operator+(point p1, point p2) {
    return point(p1.first+p2.first, p1.second+p2.second);
}

point operator-(point p1, point p2) {
    return point(p1.first-p2.first, p1.second-p2.second);
}

int distance(point p1, point p2) {
    int x1 = p1.first, y1 = p1.second;
    int x2 = p2.first, y2 = p2.second;

    return (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
}

bool cmp(point p1, point p2) {
    int x1 = p1.first, y1 = p1.second;
    int x2 = p2.first, y2 = p2.second;

    if (x1 == x2) return y1 < y2;
    return x1 < x2;
}

int CCW(point p1, point p2, point p3) {
    int S = p1.first*p2.second+p2.first*p3.second+p3.first*p1.second;
    S -= p1.second*p2.first+p2.second*p3.first+p3.second*p1.first;
    return S == 0 ? 0 : S < 0 ? -1 : 1;
}

int CCW(point p1, point p2, point p3, point p4) {
    point p = p2 + p3 - p1;
    return CCW(p, p3, p4);
}

int Rotating() {
    point l = under.top(), r = over.top();
    int ans = distance(l, r);
    under.pop(); over.pop();

    while(!under.empty() && !over.empty()) {
        point nextl = under.top(), nextr = over.top();
        int C = CCW(l, nextl, r, nextr);
        if (C < 0) {
            r = nextr;
            over.pop();
        } else {
            l = nextl;
            under.pop();
        }
        ans = max(ans, distance(l, r));
    }

    while (!under.empty()) {
        l = under.top();
        under.pop();
        ans = max(ans, distance(l, r));
    }

    while (!over.empty()) {
        r = over.top();
        over.pop();
        ans = max(ans, distance(l, r));
    }

    return ans;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);
    
    int N; cin >> N;
    for (int i = 0; i < N; i++) {
        int x, y; cin >> x >> y;
        arr[i] = point(x, y);
    }

    sort(arr, arr + N);
    for (int i = 0; i < N; i++) {
        point next = arr[i];

        while(utemp.size() > 1) {
            point cur = utemp.top();
            utemp.pop();
            point pre = utemp.top();

            int o = CCW(pre, cur, next);
            if (o > 0) {
                utemp.push(cur);
                break;
            }
        }

        while(over.size() > 1) {
            point cur = over.top();
            over.pop();
            point pre = over.top();

            int o = CCW(pre, cur, next);
            if (o < 0) {
                over.push(cur);
                break;
            }
        }

        utemp.push(next);
        over.push(next);
    }

    while (!utemp.empty()) {
        under.push(utemp.top());
        utemp.pop();
    }

    cout << Rotating();

    return 0;
}