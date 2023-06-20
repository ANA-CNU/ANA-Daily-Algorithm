#include <iostream>
#include <string>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, num;
    string buf;

    cin >> k;

    int set = 0;

    while (k-- > 0) {
        cin >> buf;
        
        if (buf == "all") {
            set = -1;
            continue;
        }
        else if (buf == "empty") {
            set = 0;
            continue;
        }

        cin >> num;

        if (buf == "add") {
            set = set | (1 << num);
        }
        else if(buf=="remove") {
            set = set & ~(1 << num);
        }
        else if (buf == "check") {
            cout << ((set >> num) & 1) << "\n";
        }
        else if (buf == "toggle") {
            set = set ^ (1 << num);
        }
    }
}