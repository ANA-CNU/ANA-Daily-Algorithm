#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

int n, m;
vector<int> v;
vector<int> nums;
int visited[10001];

void func(int idx) {
    if (idx == m) {
        for (int i = 0; i < v.size(); i++)
            cout << v[i] << " ";
        cout << "\n";
        return;
    }

    for (int i = 0; i < n; i++) {
        if (visited[nums[i]]==0) {
            visited[nums[i]] = 1;
            v.push_back(nums[i]);

            func(idx + 1);

            v.pop_back();
            visited[nums[i]] = 0;
        }
    }

}

int main() {
    cin >> n >> m;
    int tmp;

    for (int i = 0; i < n; i++) {
        cin >> tmp;
        nums.push_back(tmp);
    }

    sort(nums.begin(), nums.end());
    
    func(0);
}