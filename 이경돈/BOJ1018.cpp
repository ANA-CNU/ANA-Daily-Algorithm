#include <iostream>
using namespace std;

char bChess[8][8] = {
	{'B','W','B','W','B','W','B','W'},
	{'W','B','W','B','W','B','W','B'},
	{'B','W','B','W','B','W','B','W'},
	{'W','B','W','B','W','B','W','B'},
	{'B','W','B','W','B','W','B','W'},
	{'W','B','W','B','W','B','W','B'},
	{'B','W','B','W','B','W','B','W'},
	{'W','B','W','B','W','B','W','B'}
};

char wChess[8][8] = {
	{'W','B','W','B','W','B','W','B'},
	{'B','W','B','W','B','W','B','W'},
	{'W','B','W','B','W','B','W','B'},
	{'B','W','B','W','B','W','B','W'},
	{'W','B','W','B','W','B','W','B'},
	{'B','W','B','W','B','W','B','W'},
	{'W','B','W','B','W','B','W','B'},
	{'B','W','B','W','B','W','B','W'}
};

int check(char **pan, int x, int y){
	int cnt1 = 0;
	int cnt2 = 0;

	for(int i=0; i<8; i++){
		for(int j=0; j<8; j++){
			if(pan[i+x][j+y]!=bChess[i][j]) cnt1++;
			if(pan[i+x][j+y]!=wChess[i][j]) cnt2++;
		}
	}

	if(cnt1<cnt2)
		return cnt1;
	else
		return cnt2;
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	int m, n;
	cin >> m >> n;

	char** pan = new char*[m];

	for (int i = 0; i < m; i++)
		pan[i] = new char[n];

	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			cin >> pan[i][j];

	int cnt;
	int least = 64;

	for (int i = 0; i <= m - 8; i++)
		for (int j = 0; j <= n - 8; j++)
		{
			cnt = check(pan, i, j);
			if(cnt<least)
				least = cnt;
		}

	cout << least;

	delete [] pan;
}