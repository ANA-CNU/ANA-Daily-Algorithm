#include <iostream>
#include <string>
#include <algorithm>
#include <stack>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    string str, bomb, res;
    stack<char> s;
    cin >> str >> bomb;

    int slen = str.length();
    int blen = bomb.length();

    for (int i = 0; i < slen; i++) {
        string tmp;

        s.push(str[i]);

        if (str[i] == bomb[blen - 1]) {
            for (int j = 0; j < blen; j++) {
                if (!s.empty()) {
                    tmp.push_back(s.top());
                    s.pop();
                }
            }

            reverse(tmp.begin(), tmp.end());

            if (tmp != bomb) {
                for (int k = 0; k < tmp.length(); k++) {
                    s.push(tmp[k]);
                }
            }
        }
    }

    if (s.empty()) {
        cout << "FRULA";
        return 0;
    }
    else
        while (!s.empty()) {
            res.push_back(s.top());
            s.pop();
        }

    reverse(res.begin(), res.end());
    cout << res;

    return 0;
}