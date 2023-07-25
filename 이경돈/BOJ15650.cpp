#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> v;
int visited[9];

void func(int idx) {
    if (idx == m) {
        for (int i = 0; i < v.size(); i++)
            cout << v[i] << " ";
        cout << "\n";
        return;
    }

    for (int num = 1; num <= n; num++) {
        if(idx==0 || v[idx-1] < num)
            if (!visited[num]) {
                visited[num] = 1;
                v.push_back(num);

                func(idx + 1);

                v.pop_back();
                visited[num] = 0;
            }
    }
}

int main() {
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    cin >> n >> m;
    func(0);
}