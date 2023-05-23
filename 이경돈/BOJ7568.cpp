#include <iostream>
#include <vector>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, a, b;
    cin >> k;

    vector<pair<int, int>> v;
    int* result = new int[k];

    for (int i = 0; i < k; i++) {
        cin >> a >> b;
        v.push_back({ a,b });
    }

    int cnt = 1;

    for (int i = 0; i < k; i++) {
        cnt = 1;
        for (int j = 0; j < k; j++) {
            if (v[i].first < v[j].first && v[i].second < v[j].second)
                cnt++;
        }
        result[i] = cnt;
    }

    for (int i = 0; i < v.size(); i++)
        cout << result[i] << " ";

}