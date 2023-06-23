#include <iostream>
#include <string>
using namespace std;

int fcnt;
int tmp;

int fac(int n) {
    tmp = n;
    while (tmp % 5 == 0) {
        fcnt++;
        tmp /= 5;
    }
    if (n <= 1) return 1;
    else return n * fac(n - 1);
}

int main() {
    int k;
    cin >> k;


    if (k == 0) {
        cout << 0;
        return 0;
    }

    k = fac(k);


    cout << fcnt;
}