#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

    int k, tmp, cnt;
    cin >> k;

    vector<int> v1;
    vector<int> v2;

    while(k-- >0){
        cin >> tmp;
        v1.push_back(tmp);
    }

    cin >> k;

    sort(v1.begin(), v1.end());

    while(k-- > 0){
        cnt = 0;
        cin >> tmp;
        cout << upper_bound(v1.begin(), v1.end(), tmp) - lower_bound(v1.begin(), v1.end(), tmp) << " ";
    }
}