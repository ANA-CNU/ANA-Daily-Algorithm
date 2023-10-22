#include <iostream>
#include <cmath>
using namespace std;
int len(int n){
    if(n==0) return 1;
    int result=0;
    while(n>0){
        n/=10;
        result++;
    }
    return result;
}
int main(){
    int n,m,result,length;
    cin>>n;
    cin>>m;
    bool arr[10];
    for(int i=0; i<10; ++i) arr[i] = true;
    for(int i=0;i<m;i++){
        int t;
        cin>>t;
        arr[t]=false;
    }
    result=abs(n-100);
    for(int i=0;i<=1000000;i++){
        int temp = i;
        length=len(temp);
        bool flag=true;
        for(int j=0;j<length;j++){
            if(arr[temp%10]==false){
                flag=false;
                break;
            }
            temp/=10;
        }
        if(flag)
            result=min(result,length+abs(n-i));
    }
    cout<<result;
}
