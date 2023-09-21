#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <string>
using namespace std;

vector<char> v;

bool cango(int num) {
    string str = to_string(num);

    for (int i = 0; i < v.size(); i++) {
        if (str.find(v[i]) != string::npos)
            return false;
    }

    return true;
}

int main() {
    int key, k;
    char tmp;
    int up = INT_MAX, down = INT_MAX;
    int gap;

    cin >> key >> k;

    while (k-- > 0) {
        cin >> tmp;
        v.push_back(tmp);
    }

    gap = abs(key - 100);

    // 위로 검사
    for (int i = 0; i < gap; i++) {
        if (cango(key + i)) {
            up = i + to_string(key + i).length();
            break;
        }
    }

    // 아래로 검사
    for (int j = 0; j < gap; j++) {
        if (cango(key - j)) {
            down = j + to_string(key - j).length();
            break;
        }
    }

    // cout << "gap : " << gap << endl;
    // cout << "up : " << up << endl;
    // cout << "down : " << down << endl;

    cout << min(gap, min(up, down));
}