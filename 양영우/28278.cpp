#include <iostream>
#include <stack>


using namespace std;


int command;
stack<int> s;
int n;
int num;



void stack_command(int n){
    for(int i=0; i<n; i++){
        cin>>command;

        if(command == 1){

            cin>>num;
            s.push(num);
        }
        else if(command == 2){
            if(s.empty() == 1){
                cout<<-1<<'\n';
            }
            else{
                cout<<s.top()<<'\n';
                s.pop();

            }
        }
        else if(command == 3){
            cout<<s.size()<<'\n';
        }
        else if(command == 4){
            if(s.empty() == 1){
                cout<<1<<'\n';
            }
            else{
                cout<<0<<'\n';
            }
        }
        else{
            if(s.empty() == 1){
                cout<<-1<<'\n';
            }
            else{
                cout<<s.top()<<'\n';
            }
        }


    }
}



int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int k;
    cin>>k;

    stack_command(k);







}