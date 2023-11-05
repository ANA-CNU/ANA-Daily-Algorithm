#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int R, C;
vector<string> arr;
bool isFind = false;
pair<int, int> swan;
queue<pair<int, int>> swam_q, water_q, tmp_swam_q, tmp_water_q;
int dy[4][2] = { {-1,0}, {1,0}, {0,-1}, {0,1} };
bool ch[1501][1501];

void swanBFS() {
    while (!swam_q.empty()) {
        int x = swam_q.front().first;
        int y = swam_q.front().second;
        swam_q.pop();
        for (int k = 0; k < 4; k++) {
            int nx = x + dy[k][0];
            int ny = y + dy[k][1];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C || ch[nx][ny]) continue;
            ch[nx][ny] = true;
            if (arr[nx][ny] == 'X') tmp_swam_q.push({nx, ny });
            else if (arr[nx][ny] == '.') swam_q.push({nx, ny });
            else if (arr[nx][ny] == 'L') {
                isFind = true;
                break;
            }
        }
    }
}

void waterBFS() {
    while (!water_q.empty()) {
        int x = water_q.front().first;
        int y = water_q.front().second;
        water_q.pop();
        for (int k = 0; k < 4; k++) {
            int nx = x + dy[k][0];
            int ny = y + dy[k][1];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (arr[nx][ny] == 'X') {
                arr[nx][ny] = '.';
                tmp_water_q.push({nx, ny });
            }
        }
    }
}

int meetDay() {
    int day = 0;
    while (!isFind) {
        swanBFS();
        if (isFind) break;
        waterBFS();
        swam_q = tmp_swam_q;
        water_q = tmp_water_q;
        while (!tmp_swam_q.empty()) tmp_swam_q.pop();
        while (!tmp_water_q.empty()) tmp_water_q.pop();
        day++;
    }

    return day;
}

int main() {
    cin >> R >> C;
    for (int i = 0; i < R; i++) {
        string str;
        cin >> str;
        arr.push_back(str);
    }
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < arr[i].size(); j++) {
            if (arr[i][j] == 'L') {
                swan.first = i;
                swan.second = j;
            }
            if (arr[i][j] != 'X') {
                water_q.push({i, j });
            }
        }
    }
    ch[swan.first][swan.second] = true;
    swam_q.push(swan);
    cout << meetDay() << "\n";
    return 0;
}
