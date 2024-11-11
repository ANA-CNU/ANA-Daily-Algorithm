#include <iostream>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;

    const int MAX_NUM = 10000;
    vector<int> count(MAX_NUM + 1, 0);

    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        count[num]++;
    }

    for (int i = 1; i <= MAX_NUM; i++) {
        while (count[i] > 0) {
            cout << i << "\n";
            count[i]--;
        }
    }

    return 0;
}
