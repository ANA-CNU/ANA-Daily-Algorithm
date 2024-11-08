#include <iostream>
using namespace std;

int main() {
    int n, k;

    while (cin >> n >> k) {
        int total = n;
        int extra = n;


        while (extra >= k) {
            int newChicken = extra / k;
            total += newChicken;
            extra = extra % k + newChicken;
        }

        cout << total << endl;
    }

    return 0;
}
