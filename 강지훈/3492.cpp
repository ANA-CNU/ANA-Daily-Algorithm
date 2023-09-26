#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
const int MAX = 20001;
 
string S;
int N, d, sa[MAX], pos[MAX], lcp[MAX];

bool cmp(int i, int j) {
    if(pos[i] != pos[j]) return pos[i] < pos[j];
    i += d;
    j += d;
    return (i < N && j < N) ? (pos[i] < pos[j]) : (i < j);
}
 
void constructSA() {
    N = S.size();

    for (int i = 0; i < N; i++) {
        sa[i] = i;
        pos[i] = S[i];
    }

    for (d = 1; ; d *= 2) {
        sort(sa, sa + N, cmp);

        int temp[MAX] = {0};
        for(int i = 1; i < N; i++) {
            temp[i] = temp[i - 1] + cmp(sa[i - 1], sa[i]);
        }
            
        for(int i = 0; i < N; i++) {
            pos[sa[i]] = temp[i];
        }
            
        if(temp[N - 1] == N - 1) break;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T; cin >> T;
    while (T--) {
        cin >> S;
        int n = S.size();
        S += S;

        constructSA();

        int M = MAX;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (M > pos[i]) {
                ans = i;
                M = pos[i];
            }
        }

        cout << ans + 1 << '\n';
    }

    return 0;
}