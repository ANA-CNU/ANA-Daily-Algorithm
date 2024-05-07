#include <iostream>
#include <algorithm>

using namespace std;

int num[1000001];
int lis[1000001];

int binarysearch(int left, int right, int value){
    while(left < right){
        int mid = (left + right) / 2;

        if(lis[mid] < value){
            left = mid + 1;
        }
        else{
            right = mid;
        }
    }

    return right;
}



int main(){
    int n;
    cin>> n;

    for(int i=0; i<n; i++){
        cin>>num[i];
    }

    lis[0] = num[0];

    int k = 0;

    for(int i=1; i<n; i++){
        if(lis[k] < num[i]){
            lis[k+1] = num[i];
            k++;
        }
        else{
            int idx = binarysearch(0,k,num[i]);
            lis[idx] = num[i];
        }
    }

    cout<<k + 1;








}