#include <iostream>
#include <algorithm>

using namespace std;

int n,m;

int Candy[301][301];

int dp[301][301];

int main()
{
  cin>>n>>m;

  for(int i=0; i<n; i++){
    int x,y;
    cin>>x>>y;
    Candy[x][y] = m - (x+y);
    if(Candy[x][y] < 0){
      Candy[x][y] = 0;
    }
    dp[x][y] = Candy[x][y];
  }

  int max_candy = 0;


  for(int i=1; i<300; i++){
    for(int j=1; j<300; j++){
      dp[j][i] = Candy[j][i] + max(dp[j-1][i], dp[j][i-1]);
      max_candy = max(dp[j][i], max_candy);
    }
  }

  cout<<max_candy;




  
  



}