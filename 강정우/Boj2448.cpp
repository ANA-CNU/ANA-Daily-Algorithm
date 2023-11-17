#include <iostream>
#include <vector>
using namespace std;

vector<vector<char>> v;

void draw_star(int n, int x, int y) {
    if (n == 3) {
        v[y][x] = '*';
        v[y + 1][x - 1] = v[y + 1][x + 1] = '*';
        v[y + 2][x - 2] = v[y + 2][x - 1] = v[y + 2][x] = v[y + 2][x + 1] = v[y + 2][x + 2] = '*';
        return;
    }
    draw_star(n / 2, x, y);
    draw_star(n / 2, x - n / 2, y + n / 2);
    draw_star(n / 2, x + n / 2, y + n / 2);
}

int main() {
    int n;
    cin >> n;
    v.resize(n, vector<char>(2 * n - 1, ' '));

    draw_star(n, n - 1, 0);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 2 * n - 1; j++) {
            cout << v[i][j];
        }
        cout << '\n';
    }

    return 0;
}
