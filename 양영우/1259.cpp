#include <iostream>

using namespace std;


int main(){

    string num;



    while(true){
        cin>>num;
        int cnt = 0;
        if(num == "0"){
            break;
        }
        for(int i=0; i<num.length()/2; i++){
            if(num[i] == num[num.length()-1-i]){
                cnt++;
            }
        }
        if(cnt == num.length()/2){
            cout<<"yes"<<endl;
        }
        else{
            cout<<"no"<<endl;
        }

    }

}