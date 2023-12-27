#include <iostream>
using namespace std;

int main(){
    int n;
    cin>>n;

    int inc = 1, dec = 1, max = 1, a, b;
    cin>>a;

    for(int i=1; i<n; i++){
        cin>>b;
        if(a >= b){
            inc++;
        }
        else{
            inc = 1;
        }

        if(a <= b){
            dec++;
        }
        else{
            dec = 1;
        }
        a = b;
        
        if(inc > max){
            max = inc;
        }
        if(dec > max){
            max = dec;
        }
    }

    cout<<max;
    return 0;
}
