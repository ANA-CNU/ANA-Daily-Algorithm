#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, q, x, y;
    int cnt = 0;
    int note[100001];
    int psum[100001]; // i번째까지 실수하는 횟수
    cin>>n;

    for(int i=1; i<=n; i++){
        cin>>note[i];
    }
    cin>>q;

    for(int i=1; i<n; i++){
        if(note[i] > note[i+1]){
            cnt ++;
        }
        psum[i+1] = cnt;
    }



    for(int i=0; i<q; i++){
        cin>>x>>y;
        cout<<psum[y] - psum[x]<<'\n';
    }
}


