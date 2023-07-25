#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> v;

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

    // 1부터 n까지 중의 숫자 num에 대해
    for (int num = 1; num <= n; num++) {
        if(idx==0 || v[idx-1] <= num) // 순열이 비내림차순 (중복도 가능)
            { // 이미 사용한 수가 아니면
                v.push_back(num); // num을 선택

                func(idx + 1); // 다음 인덱스로

                v.pop_back(); // num을 다시 제거
            }
    }
}

int main() {
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    cin >> n >> m;
    func(0);
}