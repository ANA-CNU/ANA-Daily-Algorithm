#include<bits/stdc++.h>
#define MAX 101010
#define MAX_T 404040
#define INF 1e18
#define INF2 -1e17

//나중에 이 문제에 흥미가 있어, 구현해보자 하는 분들에게 도움이 될까 싶어 올립니다.
//수열과 쿼리 41 Kinetic Segment tree and Seg Beats

using namespace std;

int N, Q;

typedef long long lint;

struct line {
    lint cnt = 0, mn = 0, b = 0;
    void setValue (lint v) {
        mn = v;
        cnt = 1;
    }

    lint sum () {
        return cnt * mn + b;
    }

    line getLoss (lint m) {
        line res;
        res.mn = m;
        if (mn == res.mn) {
            res.cnt = cnt;
            res.b = b;
        } else {
            res.b = sum();
        }
        return res;
    }

    void setLoss (lint m) {
        if (mn <= m) return;
        b = sum();
        cnt = 0;
        mn = m;
    }

    line operator+ (line &o) {
        line res;
        res.mn = min(mn, o.mn);

        if (res.mn == mn) {
            res.cnt += cnt;
            res.b += b;
        } else {
            res.b += sum();
        }

        if (res.mn == o.mn) {
            res.cnt += o.cnt;
            res.b += o.b;
        } else {
            res.b += o.sum();
        }

        return res;
    }

    bool operator< (line &r) {
        if (sum() == r.sum()) return cnt < r.cnt;
        return sum() < r.sum();
    }

    lint compare (line &o) {
        lint mnn = min(o.mn, mn);
        line o1 = getLoss(mnn);
        line o2 = o.getLoss(mnn);

        if (o1.cnt == o2.cnt) return INF;

        lint up = o1.b- o2.b;
        lint dn = o2.cnt - o1.cnt;

        if (dn < 0) {
            up *= -1;
            dn *= -1;
        }

        lint m = up < 0 ? -(-up / dn) : ((up + dn - 1)/ dn);
        if (m <= mnn) return INF;
        return m;
    }
};

struct box {
    lint mn, mn2, melt;
    line leftMax, rightMax, ans, sum;

    void setValue (lint v) {
        leftMax.setValue(v);
        rightMax.setValue(v);
        sum.setValue(v);
        ans.setValue(v);


        melt = INF;
        mn2 = INF;
        mn = v;
    }

    box operator+ (box o) {
        box res;

        res.mn = min(mn, o.mn);
        res.mn2 = min(mn2, o.mn2);
        res.melt = min(melt, o.melt);
        res.sum = sum + o.sum;

        if (res.mn != mn) res.mn2 = min(res.mn2, mn);
        if (res.mn != o.mn) res.mn2 = min(res.mn2, o.mn);

        line now = rightMax + o.leftMax;
        res.ans = ans < o.ans ? o.ans : ans;
        res.ans.setLoss(res.mn);

        res.melt = min(res.melt, o.ans.compare(ans));

        if (res.ans < now) {
            res.ans = now;
        }

        res.ans.setLoss(res.mn);

        res.melt = min(res.melt, res.ans.compare(now));
        res.melt = min({res.melt, res.ans.compare(ans), res.ans.compare(o.ans)});

        line temp = sum + o.leftMax;
//        temp.setLoss(res.mn);

        res.leftMax = leftMax < temp ?
                      temp : leftMax;

        res.melt = min({res.melt, temp.compare(leftMax)});

        temp = rightMax + o.sum;
//        temp.setLoss(res.mn);

        res.rightMax = o.rightMax < temp ?
                       temp : o.rightMax;

        res.melt = min(res.melt, temp.compare(o.rightMax));



        res.leftMax.setLoss(res.mn);
        res.ans.setLoss(res.mn);
        res.rightMax.setLoss(res.mn);
        res.sum.setLoss(res.mn);
        return res;
    }
};

struct kinetic {
    box tree[MAX_T];
    lint lazy[MAX_T];
    int p[MAX_T];
    int size;

    void pull (int n) {
        tree[n] = tree[n << 1] + tree[n << 1 | 1];
    }

    void push (int n, bool pro = false) {
        if (!p[n]) return;
        tree[n].mn = max(tree[n].mn, lazy[n]);
        tree[n].ans.mn = tree[n].mn;
        tree[n].leftMax.mn = tree[n].mn;
        tree[n].rightMax.mn = tree[n].mn;
        tree[n].sum.mn = tree[n].mn;

        if (pro) {
            lazy[n << 1] = max(lazy[n << 1], lazy[n]);
            lazy[n << 1 | 1] = max(lazy[n << 1 | 1], lazy[n]);
            p[n << 1] = p[n << 1 | 1] = 1;
        } else {

        }

        lazy[n] = INF2;
        p[n] = 0;
    }

    void init (vector<int> &l) {
        for (int i=0;i<MAX_T;i++) lazy[i] = INF2;

        size = l.size();
        init(1, 0, size-1, l);
    }

    void init (int node, int s, int e, vector<int> &l) {
        if (s == e) {
            tree[node].setValue(l[s]);
            return;
        }

        int mid = s + e >> 1;
        init(node << 1, s, mid, l);
        init(node << 1 | 1, mid+1, e, l);

        pull(node);
    }

    void maxQuery (int node, int s, int e, int left, int right, lint v) {
        push(node, left != right);

        if (right <s || e < left || v <= tree[node].mn) return;

        if (s <= left && right <= e && tree[node].mn < v && v <tree[node].mn2 && v <= tree[node].melt) {
            lazy[node] = v;
            p[node] = 1;
            push(node, left != right);
            return;
        }
        int mid = left + right >> 1;

        maxQuery(node << 1, s, e, left, mid, v);
        maxQuery(node << 1 | 1, s, e, mid+1, right, v);

        pull(node);
    }

    box query (int node, int s, int e, int left, int right) {
        push(node, left != right);
        if (right < s || e < left) {
            box dummy;
            dummy.setValue(0LL);
            return dummy;
        }

        if (s <= left && right <= e)
            return tree[node];

        int m = left + right >> 1;

        box res = query(node << 1, s, e, left, m) + query(node << 1 | 1, s, e, m+1, right);
        return res;
    }
} kst;

vector<int> arr;


int main () {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);

    cin >> N >> Q;

    int k;
    for (int i=0;i<N;i++) {
        cin >> k;
        arr.push_back(k);
    }

    kst.init(arr);
    int m, l, r, x;
    for (int i=0;i<Q;i++) {
        cin >> m;

        if (m) {
            cin >> l >> r;
            box ans = kst.query(1, l-1, r-1, 0, N-1);
            cout << ans.ans.sum() << '\n';
        } else {
            cin >> l >> r >> x;
            kst.maxQuery(1, l-1, r-1, 0, N-1, x);
        }
    }
}
