#include <iostream>
#include <deque>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, n;
    int isErr, isRev;
    deque<int> v;
    string input;
    string arrs;
    string buf;
    cin >> k;
    
    while (k-- > 0) {
        cin >> input >> n;
        cin >> arrs;
        
        isErr = 0;
        isRev = 0;
        
        buf = "";
        int j = 1;

        while (n > 0) {
            if (isdigit(arrs[j]))
                buf += arrs[j];
            else if (arrs[j] == ',' || arrs[j] == ']') {
                v.push_back(stoi(buf));
                buf = "";
                n--;
            }
            j++;
        }

        for (int i = 0; i < input.length(); i++) {
            if (input[i] == 'R')
                isRev = !isRev;
            else {
                if (v.empty()) {
                    cout << "error" << "\n";
                    isErr = 1;
                    break;
                }
                if (isRev)
                    v.pop_back();
                else
                    v.pop_front();
            }
        }

        if (isErr) continue;

        if(isRev)
            reverse(v.begin(), v.end());

        if (v.empty())
            cout << "[]" << "\n";
        else {
            cout << "[";
            for (int i = 0; i < v.size() - 1; i++)
                cout << v[i] << ",";
            cout << v[v.size() - 1];
            cout << "]" << "\n";
        }
        v.clear();
    }
}