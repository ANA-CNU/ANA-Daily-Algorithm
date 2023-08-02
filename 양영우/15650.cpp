#include <iostream>

using namespace std;

int n,m;
bool isused[9];// ~숫자를 썼는지 여부
int arr[9]; //~번째 수가 --이다.

void func(int k){
    if(k == m){
        for(int i=0; i<k; i++){
            cout<<arr[i] << ' ';
        }
        cout<<'\n';
        return;
    }
    for(int i=1; i<=n; i++){
        if(!isused[i]){
            if(k<=0 || arr[k-1] <= i){
                arr[k] = i;
                isused[i] = 1;
                func(k+1);
                isused[i] = 0;
            }
        }
    }

}


int main(){
    cin>>n>>m;
    func(0);


}