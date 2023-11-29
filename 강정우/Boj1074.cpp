#include <iostream>
#include <cmath>
using namespace std;

int solve(int n, int r, int c) {
    if(n==0) return 0;
    int half = pow(2, n-1);
    if(r<half && c<half)
        return solve(n-1, r, c);
    else if(r<half && c>=half)
        return half*half + solve(n-1, r, c-half);
    else if(r>=half && c<half)
        return 2*half*half + solve(n-1, r-half, c);
    else
        return 3*half*half + solve(n-1, r-half, c-half);
}

int main() {
    int n, r, c;
    cin >> n >> r >> c;
    cout << solve(n, r, c) << "\n";
    return 0;
}
