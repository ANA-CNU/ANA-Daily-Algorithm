#include <iostream>
#include <string>
#include <cstring>
using namespace std;

int edit_distance2(string str1, string str2) {
    int mem[1001][1001];
    memset(mem, -1, sizeof(mem));
    int m = str1.length();
    int n = str2.length();
    
    for (int i = 0; i <= m; i++)
        for (int j = 0; j <= n; j++) {
            if (i == 0)
                mem[i][j] = j;
            else if (j == 0)
                mem[i][j] = i;
            else if (str1[i - 1] == str2[j - 1])
                mem[i][j] = mem[i - 1][j - 1];
            else {
                mem[i][j] = 1 + min(
                    mem[i - 1][j - 1],
                    min(mem[i - 1][j], mem[i][j - 1])
                );
            }
        }

    return mem[m][n];
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    string str1, str2;
    cin >> str1 >> str2;
    cout << edit_distance2(str1, str2);
}