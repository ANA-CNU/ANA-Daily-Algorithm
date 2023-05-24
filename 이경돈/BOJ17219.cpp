#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    int k, n;
    cin >> k >> n;

    map<string, string> m;
    string site, pw, buf;

    while (k-- > 0) {
        cin >> site >> pw;
        m.insert(pair<string, string>(site, pw));
    }

    while (n-- > 0) {
        cin >> buf;
        cout << m[buf] << "\n";
    }
}
