#include <iostream>
using namespace std;
bool Prime(long long n) {
    if (n < 2) return false;
    for (long long i = 2; i * i <= n; i++) 
        if (n % i == 0) return false;
    return true;
}
int main() {
    int k;
    cin >> k;
    for (int t = 0; t < k; t++) {
        long long n;
        cin >> n;
        while (!Prime(n)) 
            n++;
        cout << n <<endl;
    }
    return 0;
}
