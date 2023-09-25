#include <iostream>

using namespace std;

int main(){
    int n;
    cin>>n;

    int cnt = 0;

    while(n>=0){
        if(n%5==0){
            cnt += n/5;
            cout<<cnt;
            return 0;
        }
        n-=2;
        cnt++;
    }
    if(n!=0){
        cout<<-1;
    }
    else{
        cout<<cnt;
    }
    return 0;

}