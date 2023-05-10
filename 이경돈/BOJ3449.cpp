#include <iostream>
#include <vector>
using namespace std;

int main(){
    cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

    int k, cnt;
    cin >> k;

    string a;
    string b;

    while(k-->0){
        cnt = 0;

        cin >> a;
        cin >> b;

        for(int i=0; i<a.length(); i++)
            if(a[i]!=b[i])
            cnt++;

        cout << "Hamming distance is " << cnt << ".\n";
    }
}