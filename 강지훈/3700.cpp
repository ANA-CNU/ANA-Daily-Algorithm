#include <iostream>
#include <vector>
#include <algorithm>

#define INF 500000

using namespace std;
using Point = pair<int, int>;
using Contour = pair<int, vector<Point>>;
using ll = long long;

int up, down;
vector<Contour> sun, san;
vector<Point> tempc;

int CCW(Point p1, Point p2, Point p3) {
    ll S = (ll) p1.first * p2.second + (ll) p2.first * p3.second + (ll) p3.first * p1.second;
    S -= ((ll) p1.second * p2.first + (ll) p2.second * p3.first + (ll) p3.second * p1.first);

    if (S > 0) return 1;
    else if (S < 0) return -1;
    else return 0;
}

bool isCrossed(Point p1, Point p2, Point p3, Point p4) {
    int S1 = CCW(p1, p2, p3), S2 = CCW(p1, p2, p4), S3 = CCW(p3, p4, p1), S4 = CCW(p3, p4, p2);
    if (S1 * S2 < 0 && S3 * S4 < 0) return true;
    else return false;
}

bool Lay_with_temp(Point p1, int n) {
    Point p2 = Point(INF, p1.second + 1);

    int count = 0;

    for (int i = 0; i < n; i++) {
        Point p3 = tempc[i], p4 = tempc[i + 1];

        if (isCrossed(p1, p2, p3, p4)) {
            ++count;
        }
    }

    if (count % 2 == 1) return true;
    else return false;
}

bool cmp(Contour c1, Contour c2) {
    Point p1 = c1.second[0], p2 = Point(INF, p1.second + 1);

    int n = c2.second.size() - 1;
    int count = 0;

    for (int i = 0; i < n; i++) {
        Point p3 = c2.second[i], p4 = c2.second[i + 1];
        if (isCrossed(p1, p2, p3, p4)) {
            ++count;
        }
    }

    if (count % 2 == 1) return true;
    else return false;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int T; cin >> T;
    while (T--) {
        int N; cin >> N;
        sun.clear(); san.clear();
        up = 0; down = 0;

        for (int i = 0; i < N; i++) {
            int h, n; cin >> h >> n;
            tempc.clear();

            for (int j = 0; j < n; j++) {
                int x, y; cin >> x >> y;
                tempc.push_back(Point(x, y));
            }
            tempc.push_back(tempc[0]);

            bool sunf = Lay_with_temp(Point(0, 0), n), sanf = Lay_with_temp(Point(100000, 0), n);
            if (sunf && !sanf) {
                sun.push_back(Contour(h, tempc));
            } else if (!sunf && sanf) {
                san.push_back(Contour(h, tempc));
            }
        }

        sort(sun.begin(), sun.end(), cmp);
        sort(san.begin(), san.end(), cmp);

        int P = sun.size(), Q = san.size();
        int cur = 0;
        if (P > 0) cur = sun[0].first;

        for (int i = 1; i < P; i++) {
            int next = sun[i].first;
            int dis = next - cur;
            cur = next;

            if (dis < 0) {
                down -= dis;
            } else {
                up += dis;
            }
        }

        if (cur == 0 && Q > 0) cur = san[Q - 1].first;

        for (int i = Q - 1; i >= 0; i--) { 
            int next = san[i].first;
            int dis = next - cur;
            cur = next;

            if (dis < 0) {
                down -= dis;
            } else {
                up += dis;
            }
        }

        cout << up << ' ' << down << '\n';
    }
    
    return 0;
}