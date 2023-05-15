#include <iostream>
#include <vector>
using namespace std;

int narr[1001] = {0,};

int main(){
    int k, tmp;
    vector<int> v;

    cin >> k;

    while(k-->0){
        cin >> tmp;
        v.push_back(tmp);
    }

    int cnt = 0;

    for(int i=2; i<=1000; i++)
        narr[i] = i;

    for (int i = 2; i <= 1000; i++) {
		if (narr[i] == 0) continue;
		for (int j = 2 * i; j <= 1000; j += i)
			narr[j] = 0;
	}

    for(int i=0; i<v.size(); i++){
        if(narr[v[i]]!=0) cnt++;
    }

    cout << cnt;
}