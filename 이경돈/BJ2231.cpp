#include <iostream>
using namespace std;

int findConst(int ans);

int main() {
	int k;
	cin >> k;
	/*
	int sum = k;

	while (k > 0) {
		sum += k % 10;
		k /= 10;
	}
	*/

	cout << findConst(k);
}

int findConst(int ans) {
	int tmp = 1;
	int i, sum;

	while (tmp < ans) {
		i = tmp;
		sum = tmp;
		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}
		if (ans == sum)
			return tmp;
		tmp++;
	}

	return 0;
}