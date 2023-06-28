#include <iostream>
#include <map>
#include <string>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, n, sum;
    cin >> k;
    map<string, int> m;
    string name, part;

    while (k-- > 0) {
        cin >> n;

        while (n-- > 0) {
            cin >> name >> part;
            if (m.find(part) == m.end())
                m[part] = 1;
            else
                m[part]++;
        }

        sum = 1;
        
        for (auto iter = m.begin(); iter != m.end(); iter++)
            sum *= (iter->second + 1);

        cout << sum - 1 << "\n";
        m.clear();
    }

}