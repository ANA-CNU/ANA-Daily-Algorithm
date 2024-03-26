#include <iostream>
using namespace std;


int n,p;


int dp[3004][3004] = {};

int light[3004][3004];

const int PLUS = 1501;

int L_light[6011] = {};
int R_light[6011] = {};





int main() {

	scanf("%d", &n);

	for(int i=0; i<n; i++){
		int x,y;
		scanf("%d %d", &x, &y);
		light[y + PLUS][x + PLUS]++;
		

	}

	for(int i=1; i<3004; i++){
		for(int j=1; j<3004; j++){
			dp[i][j] = L_light[3004 + i-j] + dp[i-1][j] + R_light[i+j] + light[i][j];
			L_light[3004 + i-j] += light[i][j];
			R_light[i+j] += light[i][j];
		}
	}

	cin>>p;


	for(int i=0; i<p; i++){
		int x,y;
		scanf("%d %d", &x, &y);
		cout<<dp[y + PLUS][x + PLUS]<<'\n';
	}





	

}