#include <iostream>

using namespace std;

int gate, p, gateNumber;
int airport[100001];
int cnt = 0;


int find(int x){
    if(airport[x] == x) return x;

    return airport[x] = find(airport[x]);
}


void merge(int a, int b){
    a = find(a);
    b = find(b);

    if(a == b) return;

    if(a<b) airport[b] = a;
    else airport[a] = b;
}




int main(){
    cin>>gate;

    cin>>p;

    for(int i=1; i<=gate; i++){
        airport[i] = i;
    }


    for(int i=0; i<p; i++){
        cin>>gateNumber;


        if(find(gateNumber) == 0) break;
        else{
            cnt++;
            merge(airport[gateNumber], airport[gateNumber] - 1);

        }


    }

    cout<<cnt;








}