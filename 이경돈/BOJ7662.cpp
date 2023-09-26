#include <iostream>
#include <set>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, n, num;
    char cmd;
    
    cin >> k;
    while (k-- > 0) {
        multiset<int> m; // 원소는 오름차순으로 정렬되어 저장, 중복 허용

        cin >> n;
        while (n-- > 0) {
            cin >> cmd >> num;
            if (cmd == 'I') {
                m.insert(num);
            }
            else if (cmd == 'D') {
                if (m.empty())
                    continue;
                
                if (num == 1) {
                    // 마지막 원소로 이동, 삭제
                    auto iter = m.end();
                    iter--;
                    m.erase(iter); 
                }
                else if (num == -1) {
                    m.erase(m.begin());
                }
            }
        }

        if (m.size() <= 0)
            cout << "EMPTY";
        else {
            // 마지막 원소를 출력
            auto iter = m.end();
            iter--;
            cout << *iter << " " << *m.begin();
        }
        cout << "\n";
    }
}