#include <iostream>
#include <string.h>
#define MAX 100001
using namespace std;
int scnt;
int cnt = 0;
int done[MAX] = {0};
int visited[MAX] = {0};
int hope[MAX] = {0};
void dfs(int next){
    visited[next] = 1;
    int next_student = hope[next];
    if (visited[next_student] == 0){
        dfs(next_student);
    }
    else if (done[next_student] == 0){
        for (int i = next_student; i != next; i = hope[i]){
            cnt++;
        }
        cnt++;
    }
    done[next] = 1;
}

int main(){
    int t;
    cin >> t;
    for (int i=0; i < t; ++i){
        memset(done, 0, sizeof(done));
        memset(visited, 0, sizeof(visited));
        memset(hope, 0, sizeof(hope));
        cin >> scnt;
        for (int j=1; j <= scnt; ++j){
            cin >> hope[j];
        }
        cnt = 0;
        for (int j=1; j <= scnt; ++j){
            if (visited[j]==0){
                dfs(j);
            }
        }
        cout << scnt - cnt << endl;
    }
}
