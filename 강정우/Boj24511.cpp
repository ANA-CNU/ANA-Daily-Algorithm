#include <iostream>
#include <deque>
using namespace std;

int main() {
    int n1;
    cin >> n1;
    int arr[n1];
    for(int i = 0; i < n1; i++) {
        cin >> arr[i];
    }
    int stq[n1];
    for(int i = 0; i < n1; i++) {
        cin >> stq[i];
    }
    int n2;
    cin >> n2;
    int arr2[n2];
    for(int i = 0; i < n2; i++) {
        cin >> arr2[i];
    }
    deque<int>queue1;
    for(int i=0;i<n1;i++){
        if(arr[i]==0){
            queue1.push_back(stq[i]);
        }
    }
    for(int i:arr2){
        int save;
        queue1.push_front(i);
        save=queue1.back();
        queue1.pop_back();
        cout<<save<<" ";
    }
    return 0;
}
