#include <iostream>
#include <algorithm>
#include <set>
#include <map>
#include <cmath>

#define SIZE 150'000
#define INF 8'000'000'000'000LL
#define x first
#define y second

using namespace std;
using point = pair<int, int>;
using point3 = pair<point, int>;
using ll = long long;


struct y_set_sort {
    bool operator()(point p1, point p2) const {
        return p1.y==p2.y ? p1.x < p2.x : p1.y < p2.y;
    }
};

int N;
point3 arr[SIZE];

ll distance(int p1, int p2) {
    ll x_ = p1-p2;
    return x_*x_;
}

ll distance(point p1, point p2) {
    ll x_ = p1.x-p2.x, y_ = p1.y-p2.y;
    return x_*x_+y_*y_;
}

ll distance(point3 p1, point3 p2) {
    ll x_ = p1.x.x-p2.x.x, y_ = p1.x.y-p2.x.y, z_ = p1.y-p2.y;
    return x_*x_+y_*y_+z_*z_;
}

string solve() {
    map<point, set<int>, y_set_sort> y_map;
    int j = 0;
    ll ans = INF;
    int count = 1;
    
    for (int i = 0; i < N; i++) {
        point3 cur = arr[i];
        point curp = cur.x;
        int curx = curp.x, cury = curp.y, curz = cur.y;

        while (j != i) {
            point3 p3 = arr[j];
            point p = p3.x;
            int px = p.x, pz = p3.y;

            if (ans >= distance(px, curx)) break;
            ++j;

            y_map[p].erase(pz);
            if (y_map[p].empty()) {
                y_map.erase(p);
            }
        }

        ll d = (ll)sqrt((double)ans)+1;
        point l = point(-1'000'001, cury-d), r = point(1'000'001, cury+d);

        for (auto it = y_map.lower_bound(l); it != y_map.upper_bound(r); it++) {
            for (auto it2 = (*it).second.lower_bound(curz-d); it2 != (*it).second.upper_bound(curz+d); it2++) {
                ll temp = distance(cur, point3((*it).first, (*it2)));
                if (temp < ans) {
                    ans = temp;
                    count = 1;
                } else if (temp == ans) {
                    ++count;
                }
            }
        }

        if (y_map.find(curp) == y_map.end()) {
            set<int> st;
            y_map.insert(make_pair(curp, st));
        }
        y_map[curp].insert(curz);
    }

    return to_string(ans) + '\n' + to_string(count);
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    set<point3> points;

    cin >> N;
    for (int i = 0; i < N; i++) {
        int x0, y0, z0; cin >> x0 >> y0 >> z0;
        points.insert(point3(point(x0, y0), z0));
    }

    N = 0;
    for (point3 p3 : points) {
        arr[N++] = p3;
    }

    cout << solve();
        
    return 0;
}