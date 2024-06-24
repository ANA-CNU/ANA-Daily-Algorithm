#include <iostream>
#include <cmath>
using namespace std;
pair<long long, long long> getCoordinates(long long n) {
    long long i = 0;
    while (true) {
        if (n > i * i && n <= (i + 1) * (i + 1)) {
            long long l = n - i * i;
            if (l % 2 == 0) {
                return make_pair(i * 2, l / 2);
            } else {
                return make_pair(i * 2 + 1, l / 2 + 1);
            }
        }
        i++;
    }
}
int main() {
    long long a, b;
    cin >> a >> b;
    pair<long long, long long> pa = getCoordinates(a);
    pair<long long, long long> pb = getCoordinates(b);
    long long h = abs(pb.first - pa.first);
    long long len = abs(pb.second - pa.second);
    long long result = h;
    if (len > (h + 1) / 2) {
        result += (len - (h + 1) / 2) * 2;
    }
    cout << result << endl;
    return 0;
}
