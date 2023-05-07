#include <iostream>
using namespace std;

int a[1000001] = { 0, };

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	int start, end;
	cin >> start >> end;

	for (int i = 2; i <= 1000000; i++)
		a[i] = i;

	for (int i = 2; i <= 1000000; i++) {
		if (a[i] == 0) continue;
		for (int j = 2 * i; j <= 1000000; j += i)
			a[j] = 0;
	}

	for (int i = start; i <= end; i++)
		if(a[i]!=0)
			cout << a[i] << "\n";
}