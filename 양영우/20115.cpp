#include <iostream>
#include <algorithm>


using namespace std;


int n;

double arr[100000];


int main(){
    cin.tie(0);
    cin>>n;

    double num;

    for(int i=0; i<n; i++){
        cin>>arr[i];
        
    }

    sort(arr, arr + n);

    double sum = arr[n-1];


    for(int i=0; i<n-1; i++){
        sum+= (arr[i]/2);
    }


    cout<<sum;


    







}


