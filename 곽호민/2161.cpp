#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n;
    cin >> n;

    queue<int> q;
    for(int i = 1; i < n+1; i++)
    {
        q.push(i);
    }

    while(q.size() > 1) {
        cout << q.front() << " ";
        q.pop();
        int f = q.front();
        q.pop();
        q.push(f);
    }

    cout << q.front();

    return 0;
}