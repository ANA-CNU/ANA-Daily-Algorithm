#include <iostream>
using namespace std;

int block[500][500];

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n, m, b;
    cin >> n >> m >> b;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> block[i][j];

    int mTime = 128000000;
    int mHeight = 256;

    int time, toAdd, toRemove;

    for (int h = 0; h <= 256; h++) {
        toAdd = 0;
        toRemove = 0;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (block[i][j] > h)
                    toRemove += (block[i][j] - h);
                else if (block[i][j] < h)
                    toAdd += (h - block[i][j]);
            }

        if (toAdd > toRemove+b) continue;

        time = toRemove * 2 + toAdd;
        if (time <= mTime) {
            mTime = time;
            mHeight = h;
        }
    }

    cout << mTime << " " << mHeight;
}