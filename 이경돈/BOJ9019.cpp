#include <iostream>
#include <queue>
#include <string>
#include <cstring>
using namespace std;

int nums[10000];
int visited[10000];
string ans[10000];

// start애서 end로 가는 bfs
string bfs(int start, int end) {
    queue<int> q;
    int num;
    int d, s, l, r;
    int front, back;

    q.push(start);
    visited[start] = 1;
    ans[start] = "";

    while (!q.empty()) {
        num = q.front();
        q.pop();
        if (num == end) // 결과값이 나오면 결과 문자열 ans 반환
            return ans[end];

        // n을 두 배
        d = num * 2 % 10000;
        if (visited[d] == 0) {
            visited[d] = 1;
            q.push(d);
            ans[d] = ans[num] + "D";
        }
        
        // n에서 1 빼기
        s = (num + 9999) % 10000;
        if (visited[s] == 0) {
            visited[s] = 1;
            q.push(s);
            ans[s] = ans[num] + "S";
        }

        // 각 자릿수를 왼쪽으로 회전
        front = num / 1000;
        l = (num * 10 % 10000) + front;
        if (visited[l] == 0) {
            visited[l] = 1;
            q.push(l);
            ans[l] = ans[num] + "L";
        }

        // 각 자릿수를 오른쪽으로 회전
        back = num % 10;
        r = (num / 10 % 1000) + (back * 1000);
        if (visited[r] == 0) {
            visited[r] = 1;
            q.push(r);
            ans[r] = ans[num] + "R";
        }
    }
}

int main() {
    int k, a, b;
    cin >> k;

    while (k-- > 0) {
        cin >> a >> b;
        cout << bfs(a, b) << "\n";

        memset(visited, 0, sizeof(visited)); // visited 배열 초기화
    }
}