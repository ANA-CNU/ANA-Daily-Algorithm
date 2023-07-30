#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T,day;
    long long stock_price[1000001];
    cin>>T;

    for(int i=0; i<T; i++){
        cin>>day;
        for(int j=0; j<day; j++){
            cin>>stock_price[j];
            
        }
        long long max_price = 0;
        long long sum = 0;
        for(int k=day-1; k>=0; k--){
            if(stock_price[k] >= max_price){
                max_price = stock_price[k];
            }
            sum +=(max_price - stock_price[k]);
        }
        cout<<sum<<endl;
    }
}