#include <iostream>
using namespace std;

int main() {
    unsigned long long S;
    unsigned long long sum = 0, n = 0;

    cin >> S;

    while(sum + n + 1 <= S) {
    n++;
    sum += n;
    }

    cout << n;
    return 0;
}