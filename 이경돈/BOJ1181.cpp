#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool cmp(string a, string b) {
	if (a.length() == b.length())
		return a < b;
	else
		return a.length() < b.length();
}

//string sArr[20000];

int main() {
	int k;
	cin >> k;

	string* sArr = new string[k];

	for (int i = 0; i < k; i++)
		cin >> sArr[i];

	sort(sArr, sArr+k, cmp);

	for (int i = 0; i < k; i++) {
		if(i!=0)
			if (sArr[i] == sArr[i - 1]) continue;
		cout << sArr[i] << endl;
	}

	delete [] sArr;
}