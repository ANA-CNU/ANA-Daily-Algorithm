#include <iostream>
#include <cmath>
using namespace std;

int cnt; 

void countz(int n, int r, int c) {
    int half = pow(2, n - 1);
    int block = half * half;

    if (n <= 0)
        return;

    if (r < half && c < half) {
        countz(n-1, r, c);
    }
    else if (r < half && c >= half) {
        cnt += block;
        countz(n-1, r, c - half);
    }
    else if (r >= half && c < half) {
        cnt += (2 * block);
        countz(n-1, r - half, c);
    }
    else {
        cnt += (3 * block);
        countz(n-1, r - half, c - half);
    }
}

int main() {
    int n, r, c;
    cin >> n >> r >> c;

    countz(n, r, c);

    cout << cnt;
}

