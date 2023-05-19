#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int u, d, v;
    cin >> u >> d >> v;

    int day = 0;
    int h = 0;
    if (u >= v) cout << 1;
    else if ((v - u) % (u - d)!=0) cout << ((v - u) / (u - d)) +2;
    else cout << ((v - u) / (u - d)) + 1;
}