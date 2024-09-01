#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int arr[101];
    for (int i = 0; i <= 100; i++)
        arr[i] = 0;

    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        arr[x] = y;
    }

    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        arr[x] = y;
    }

    queue<int> queue;
    int map[101];
    map[1] = 0;
    for (int i = 2; i <= 100; i++)
        map[i] = 10000;

    queue.push(1);
    while (!queue.empty()) {
        int x = queue.front();
        queue.pop();
        for (int i = 1; i <= 6; i++) {
            int y = x + i;
            if (y > 100) continue;
            if (arr[y] != 0) {
                y = arr[y];
            }
            if (map[y] > map[x] + 1) {
                map[y] = map[x] + 1;
                queue.push(y);
            }
        }
    }

    cout << map[100];
    return 0;
}
