#include <iostream>

using namespace std;

int psum[100002] = {0};
int n, k;
int num;
int sum_max = -100000001;



int main(){
    cin>>n>>k;



    for(int i=1; i<=n; i++){
        cin>>num;
        psum[i] = num + psum[i-1];
    }

    for(int i= k; i<=n; i++){
        sum_max = max(sum_max, psum[i] - psum[i-k]);
    }

    cout<<sum_max;


}
