#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int n;
    vector<int> v;
    
    cin >> n;
    
    while (n > 0) {
        v.push_back(n % 10);
        n /= 10;
    }

    sort(v.begin(), v.end());

    for (auto it = v.crbegin(); it < v.crend(); it++) {
        cout << *it;
    }
}