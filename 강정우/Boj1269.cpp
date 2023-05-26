#include <iostream>
#include <set>
#include <algorithm>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    set<int> set1;
    set<int> set2;

    for (int i = 0; i < a; i++) {
        int k;
        cin >> k;
        set1.insert(k);
    }

    for (int i = 0; i < b; i++) {
        int k;
        cin >> k;
        set2.insert(k);
    }

    set<int> set3, set4, set5;
    set_difference(set1.begin(), set1.end(), set2.begin(), set2.end(), inserter(set3, set3.begin()));
    set_difference(set2.begin(), set2.end(), set1.begin(), set1.end(), inserter(set4, set4.begin()));
    set_union(set3.begin(), set3.end(), set4.begin(), set4.end(), inserter(set5, set5.begin()));

    cout << set5.size() << endl;

    return 0;
}
