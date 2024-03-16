#include <iostream>

using namespace std;

int n;

int map[100][100];

long long dp[100][100];


int main(){

  cin>>n;

  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>map[i][j];
    }
  }

  dp[0][0] = 1;

  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      if(dp[i][j] == 0 || (i == n-1 && j == n-1)) continue;
      
      int right =  i + map[i][j];
      int down = j + map[i][j];

      if(right < n) dp[right][j] += dp[i][j];
      if(down < n) dp[i][down] += dp[i][j];



    }
  }
  cout<<dp[n-1][n-1];


  



}