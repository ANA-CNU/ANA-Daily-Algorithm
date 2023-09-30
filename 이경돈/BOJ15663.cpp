#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<int> v;
vector<int> nums;
int visited[9]; // 방문을 표시

// 0~idx-1까지는 이미 결정되었음
// 인덱스 idx ~ n-1 까지를 결정하는 함수
void func(int idx) {
    //수열이 완성되었으면 출력
    if (idx == m) {
        for (int i = 0; i < v.size(); i++)
            cout << v[i] << " ";
        cout << "\n";
        return; 
    }

    int last = 0;

    // 1부터 n까지 중의 숫자 nums[k]에 대해
    for (int k = 0; k < n; k++) {
        if (!visited[k] && nums[k]!=last) { // 이미 사용한 수가 아니면
            last = nums[k];
            visited[k] = 1;
            v.push_back(nums[k]); // num을 선택

            func(idx + 1); // 다음 인덱스로

            v.pop_back(); // num을 다시 제거
            visited[k] = 0;
        }
    }
}

int main() {
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int tmp;

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> tmp;
        nums.push_back(tmp);
    }

    sort(nums.begin(), nums.end());


    func(0);
}