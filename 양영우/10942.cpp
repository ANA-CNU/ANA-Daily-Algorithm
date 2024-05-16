#include <iostream>

using namespace std;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;

    cin>>n;

    int num[2001];

    bool palindrome[2001][2001] = {false};

    for(int i=1; i<=n; i++){
        cin>>num[i];
    }



    int m;

    cin>>m;

    for(int i=1; i<=n; i++){
        palindrome[i][i] = 1;
        if(i != n && num[i] == num[i+1]){
            palindrome[i][i+1] = 1;
        }
        else{
            palindrome[i][i+1] = 0;
        }
    }

    
    for(int len=3; len<=n; len++){
        for(int i=1; i<=n-len+1; i++){
            int j=i+len-1;
            if(palindrome[i + 1][j - 1] && num[i] == num[j]){
                palindrome[i][j] = 1;
            }
        }
    }



    


    for(int i=0; i<m; i++){
        int st,en;

        cin>>st>>en;

        if(palindrome[st][en]){
            cout<<1<<'\n';
        }
        else{
            cout<<0<<'\n';
        }

        


    }


}