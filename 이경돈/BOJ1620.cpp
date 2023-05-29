#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    int n, m;
    cin >> n >> m;

    string tmp;
    map<int, string> dic1;
    map<string, int> dic2;

    for (int i = 1; i <= n; i++) {
        cin >> tmp;
        dic1.insert(make_pair(i, tmp));
        dic2.insert(make_pair(tmp, i));
    }

    while (m-- > 0) {
        cin >> tmp;
        
        if (atoi(tmp.c_str()) != 0) {
            cout << dic1[stoi(tmp)] << "\n";
        }
        else
            cout << dic2[tmp] << "\n";
    }
}