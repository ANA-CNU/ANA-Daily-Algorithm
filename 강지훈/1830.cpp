#include <iostream>
#include <algorithm>
#include <set>
#include <stack>
#include <cmath>

#define x first
#define y second
#define SIZE 100'000
#define INF 1'000'000'000

using namespace std;
using point = pair<int, int>;

int N;
point x_sorted_arr[SIZE], y_sorted_arr[SIZE], plus_sorted_arr[SIZE], minus_sorted_arr[SIZE];

struct y_set_sort {
    bool operator()(point p1, point p2) const {
        return p1.y == p2.y ? p1.x < p2.x : p1.y < p2.y;
    }
};

point operator+(point p1, point p2) {
    return point(p1.x+p2.x, p1.y+p2.y);
}

point operator-(point p1, point p2) {
    return point(p1.x-p2.x, p1.y-p2.y);
}

bool y_sort(point p1, point p2) {
    return p1.y == p2.y ? p1.x < p2.x : p1.y < p2.y;
}

bool plus_sort(point p1, point p2) {
    return p1.x+p1.y < p2.x+p2.y;
}

bool minus_sort(point p1, point p2) {
    return p1.x-p1.y < p2.x-p2.y;
}

int ccw(point p1, point p2, point p3) {
    int S = p1.x*p2.y+p2.x*p3.y+p3.x*p1.y;
    S -= (p1.y*p2.x+p2.y*p3.x+p3.y*p1.x);
    return S == 0 ? 0 : S > 0 ? 1 : -1;
}

int cccw(point p1, point p2, point p3, point p4) {
    point p = p1+p3-p2;
    return ccw(p, p3, p4);
}

int distance(point p1, point p2) {
    int x1 = p1.x-p2.x, y1 = p1.y-p2.y;
    return x1*x1+y1*y1;
}

int man_distance(point p1, point p2) {
    return abs(p1.x-p2.x)+abs(p1.y-p2.y);
}

int cheb_distance(point p1, point p2) {
    return max(abs(p1.x-p2.x), abs(p1.y-p2.y));
}

int get_min(int type) {
    set<point, y_set_sort> st;
    int ans = INF;
    int j = 0;

    for (int i = 0; i < N; i++) {
        point cur = x_sorted_arr[i];

        while (j != i) {
            if (type == 0) {
                if ((cur.x-x_sorted_arr[j].x)*(cur.x-x_sorted_arr[j].x) < ans) break;
            } else {
                if (cur.x-x_sorted_arr[j].x < ans) break;
            }
            st.erase(x_sorted_arr[j++]);
        }
        int d;
        if (type == 0) d = (int)sqrt((double)ans);
        else d = ans;
        point l = point(-10001, cur.y-d), r = point(10001, cur.y+d);
        for (auto it = st.lower_bound(l); it != st.upper_bound(r); it++) {
            if (type == 0) ans = min(ans, distance(*it, cur));
            else if (type == 1) ans = min(ans, man_distance(*it, cur));
            else ans = min(ans, cheb_distance(*it, cur));
        }

        st.insert(cur);
    }

    return ans;
}

int euclidean_min() {
    return get_min(0);
}

int euclidean_max() {
    stack<point> temp, under, over;
    for (int i = 0; i < N; i++) {
        point cur = x_sorted_arr[i];

        while (temp.size() > 1) {
            point pre = temp.top();
            temp.pop();
            point ppre = temp.top();
            if (ccw(ppre, pre, cur) > 0) {
                temp.push(pre);
                break;
            }
        }
        while (over.size() > 1) {
            point pre = over.top();
            over.pop();
            point ppre = over.top();
            if (ccw(ppre, pre, cur) < 0) {
                over.push(pre);
                break;
            }
        }

        temp.push(cur);
        over.push(cur);
    }

    while (!temp.empty()) {
        under.push(temp.top());
        temp.pop();
    } 

    point p1, p2, p3, p4;
    p1 = under.top(); under.pop();
    p3 = over.top(); over.pop();
    
    int ans = distance(p1, p3);
    while (!under.empty() && !over.empty()) {
        p2 = under.top(); p4 = over.top();
        if (cccw(p1, p2, p3, p4) > 0) {
            over.pop();
            p3 = p4;
        } else {
            under.pop();
            p1 = p2;
        }
        ans = max(ans, distance(p1, p3));
    }

    while (under.empty() && !over.empty()) {
        ans = max(ans, distance(p1, over.top()));
        over.pop();
    }

    while (!under.empty() && over.empty()) {
        ans = max(ans, distance(p3, under.top()));
        under.pop();
    }

    return ans;
}

int manhattan_min() {
    return get_min(1);
}

int manhattan_max() {
    return max(man_distance(plus_sorted_arr[N-1], plus_sorted_arr[0]), man_distance(minus_sorted_arr[N-1], minus_sorted_arr[0]));
}

int chebyshev_min() {
    return get_min(2);
}

int chebyshev_max() {
    return max(cheb_distance(x_sorted_arr[N-1], x_sorted_arr[0]), cheb_distance(y_sorted_arr[N-1], y_sorted_arr[0]));
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        int x0, y0; cin >> x0 >> y0;
        x_sorted_arr[i] = y_sorted_arr[i] = plus_sorted_arr[i] = minus_sorted_arr[i] = point(x0, y0);
    }

    sort(x_sorted_arr, x_sorted_arr+N);
    sort(y_sorted_arr, y_sorted_arr+N, y_sort);
    sort(plus_sorted_arr, plus_sorted_arr+N, plus_sort);
    sort(minus_sorted_arr, minus_sorted_arr+N, minus_sort);

    cout << euclidean_max() << '\n';
    cout << euclidean_min() << '\n';
    cout << manhattan_max() << '\n';
    cout << manhattan_min() << '\n';
    cout << chebyshev_max() << '\n';
    cout << chebyshev_min() << '\n';
        
    return 0;
}