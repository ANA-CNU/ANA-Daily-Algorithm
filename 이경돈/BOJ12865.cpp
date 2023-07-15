#include <iostream>
using namespace std;

int dp[101][100001];
int knapsack(int* wt, int* val, int W, int n) {
    int with, without;
    for (int i = 1; i <= n; i++)
        for (int w = 1; w <= W; w++)
            if (wt[i - 1] > w)
                dp[i][w] = dp[i - 1][w];
            else {
                without = dp[i - 1][w];
                with = val[i - 1] + dp[i-1][w - wt[i - 1]];
                dp[i][w] = max(with, without);
            }

    return dp[n][W];
}

int main() {
    int k, weight, a, b;
    cin >> k >> weight;
    
    int* wt = new int[k];
    int* val = new int[k];
    
    for (int i = 0; i < k; i++) {
        cin >> wt[i] >> val[i];
    }

    cout << knapsack(wt, val, weight, k);

    delete[] wt;
    delete[] val;
}