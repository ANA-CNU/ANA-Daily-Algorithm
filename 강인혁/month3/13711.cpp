#include<string>
#include<sstream>
#include<fstream>
#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<regex>
#include<queue>
#include<set>
#include <cmath>

#define endl '\n'

typedef long long ll;
using namespace std;

const int INF= 0x3f3f3f3f;

int A[111111];
int B[111111];
pair<int,int> C[111111];
int A2Idx[111111];
int n;

vector<int> memo;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> A[i];
        A2Idx[A[i]] = i;
    }
    for(int i=1; i<=n; i++){
        cin >> B[i];
        C[i].first = A2Idx[B[i]];
        C[i].second = i;
    }

    
    memo.push_back(C[1].first);
    for(int i=2; i<=n; i++) {
        if(memo.back() < C[i].first) {
            memo.push_back(C[i].first);
            C[i].first = memo.size();
        }
        else {
            auto it = lower_bound(memo.begin(), memo.end(), C[i].first);
            *it = C[i].first;
            C[i].second = it - memo.begin();
        }
    }

    cout << memo.size() << endl;

    return 0;
}

