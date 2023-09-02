#include <iostream>
using namespace std;

int k;
int paper[128][128];
int white;
int blue;

void divide(int x, int y, int n) { // (x,y)를 왼쪽 끝 시작점으로 n×n 영역을 검사
    int dx[4] = { 0, n / 2, 0, n / 2 };
    int dy[4] = { 0, 0, n / 2, n / 2 };
    int sum = 0;

    // 해당 구역의 숫자합 계산
    for (int i = x; i < x + n; i++)
        for (int j = y; j < y+n; j++)
            sum += paper[i][j];

    if (sum == 0) // 해당 구역이 0만으로 채워진 경우 -> 흰색
        white++;
    else if (sum == n * n) // 해당 구역이 1만으로 채워진 경우 -> 파란색
        blue++;
    else { // 0과 1이 섞여있으면 해당 구역을 네 등분해서 각각에 대해 다시 검사
        for (int d = 0; d < 4; d++)
            divide(x + dx[d], y + dy[d], n / 2);
    }
}

int main() {
    cin >> k;
    for (int i = 0; i < k; i++)
        for (int j = 0; j < k; j++)
            cin >> paper[i][j];

    divide(0, 0, k); // (0,0)을 시작으로 k×k 영역을 검사

    cout << white << endl << blue;
}