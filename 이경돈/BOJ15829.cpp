#include <iostream>
#include <cmath>
#include <string>
using namespace std;


long long m = 1234567891;

int main() {
    int k;
    cin >> k;
    (void)getchar();

    string buf;
    cin >> buf;

    long long h = 0, r = 1;

    for (int i = 0; i < k; i++) {
        h = (h + (buf[i] - 96) * r) % m;
        r = (r * 31) % m;
    }

    cout << h;
}