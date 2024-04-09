#include <bits/stdc++.h>
using namespace std;

int main() {
  cin.tie(0)->sync_with_stdio(0);

  int n;
  cin >> n;

  int a[n + 1];
  int cnt[n + 1];
  int near[n + 1];
  vector<int> v;

  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    cnt[i] = 0;
    near[i] = 0;
  }

  for (int i = 1; i <= n; i++) {
    while (!v.empty() && a[v.back()] <= a[i]) {
      v.pop_back();
    }
    v.push_back(i);
    cnt[i] += v.size() - 1;
    if (v.size() > 1) {
      near[i] = v[v.size() - 2];
    }
  }
  v.clear();

  for (int i = n; i >= 1; i--) {
    while (!v.empty() && a[v.back()] <= a[i]) {
      v.pop_back();
    }
    v.push_back(i);
    cnt[i] += v.size() - 1;
    if (v.size() > 1) {
      if (near[i] == 0 || i - v[v.size() - 2] > near[i] - i) {
        near[i] = v[v.size() - 2];
      }
    }
  }

  for (int i = 1; i <= n; i++) {
    cout << cnt[i];
    if (near[i] != 0) {
      cout << " " << near[i];
    }
    cout << '\n';
  }

  return 0;
}
