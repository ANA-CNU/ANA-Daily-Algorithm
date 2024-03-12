#include <iostream>
using namespace std;

int main() {
    int n;
    int count5 = 0;
    cin >> n;

    for(int i = 1; i < n + 1; i++)
    {
        int temp = i;
        while (temp % 5 == 0) {
            count5++;
            temp /= 5;
        }
    }

    cout << count5;
    
    return 0;
}