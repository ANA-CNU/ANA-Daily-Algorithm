#include <iostream>
#include <algorithm>
using namespace std;

int n;
int ldp[3];
int sdp[3];

int main() {
    int a, b, c;
    cin >> n;

    cin >> ldp[0] >> ldp[1] >> ldp[2];

    for (int i = 0; i < 3; i++)
        sdp[i] = ldp[i];

    for (int i = 1; i < n; i++) {
        // 새로 들어온 행
        cin >> a >> b >> c;

        int x, y, z;

        // 최대값 계산 (dp : 직전 행)
        x = max(ldp[0], ldp[1]) + a;
        y = max({ ldp[0], ldp[1], ldp[2] }) + b;
        z = max(ldp[1], ldp[2]) + c;

        // dp 갱신
        ldp[0] = x;
        ldp[1] = y;
        ldp[2] = z;

        // 최소값 계산 (dp : 직전 행)
        x = min(sdp[0], sdp[1]) + a;
        y = min({ sdp[0], sdp[1], sdp[2] }) + b;
        z = min(sdp[1], sdp[2]) + c;

        // dp 갱신
        sdp[0] = x;
        sdp[1] = y;
        sdp[2] = z;
    }

    cout << max({ ldp[0], ldp[1], ldp[2] }) << " " << min({ sdp[0], sdp[1], sdp[2] });
}