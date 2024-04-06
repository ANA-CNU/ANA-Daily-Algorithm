// #include <iostream>
// using namespace std;

// long long power_dq(long long a, long long b, long long c) {
//     if (b == 0)
//         return 1;

//     if (b % 2 == 0)
//         return power_dq(a, b/2, c) * power_dq(a, b/2, c) % c;
//     else
//         return a * power_dq(a, (b-1)/2, c) * power_dq(a, (b-1)/2, c) % c;
// }

// int main() {
//     long long a, b, c;
//     cin >> a >> b >> c;
//     cout << power_dq(a, b, c) % c;
// }

#include <iostream>
using namespace std;

long long int c;

long long int power_dq(long long int a, long long int b) {
    if (b == 1)
        return a % c;

    long long int x = power_dq(a, b / 2) % c;

    if (b % 2 == 0)
        return x * x % c;
    else
        return ((a % c) * (x * x % c));
}

int main() {
    long long int a, b;
    cin >> a >> b >> c;

    cout << power_dq(a, b) % c;
}