#include <iostream>
using namespace std;

int main() {
	int n, m;

	cin >> n >> m;

	int* pNum = new int[n];
	
	for (int i = 0; i < n; i++) {
		cin >> pNum[i];
	}


	int max = 0;
	int sum = 0;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++) {
				if(i!=j && j!=k && k!=i)
					sum = pNum[i] + pNum[j] + pNum[k];
				if (sum > max && sum <= m)
					max = sum;
			}
		}
	}

	cout << max;
}