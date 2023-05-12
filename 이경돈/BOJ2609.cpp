#include <iostream>
using namespace std;

int gcd(int a, int b) {
	if (a % b == 0) return b;
	else
		return gcd(b, a % b);
}

int main() {
	int a, b;
	cin >> a >> b;

	int res1 = gcd(a, b);
	int res2 = a * b / res1;

	cout << res1 << endl;
	cout << res2 << endl;
}