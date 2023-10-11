#include <iostream>

using namespace std;


int main(){

    int n;
    cin>>n;

    int cnt = 0;

    int a,b,c;

    if(n < 100){
        cout<< n;
        return 0;
    }
    else{
        cnt = 99;
        for(int i=100; i<= n; i++){
            a = i/100;
            b = (i/10) % 10;
            c = i % 10;
            if((a-b) == (b-c)){
                cnt++;
            }
        }

        cout<<cnt;
        return 0;

    }


}