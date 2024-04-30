#include <bits/stdc++.h>

using namespace std;
typedef struct {
    int x;
    int y;
    int z;
    int check;
}st;
vector<st> v;
char s[9][10], b[9][10], c[9][10];
int isOk(int x, int y, int z){
    vector<int> vv;
    vv.push_back(x);
    vv.push_back(y);
    vv.push_back(z);
    sort(vv.begin(), vv.end());
    x = vv[0];
    y = vv[1];
    z = vv[2];

    for(int i=0; i<v.size(); i++) {
        if(v[i].x == x && v[i].y == y && v[i].z == z && v[i].check == 0) {
            v[i].check = 1;
            return 1;
        }
    }
    return 0;
}
void check(int x, int y, int z){

    if(strcmp(s[x], s[y]) == 0 && strcmp(s[x], s[z]) != 0) return;
    if(strcmp(s[x], s[y]) != 0 && (strcmp(s[x], s[z]) == 0 || strcmp(s[y], s[z]) == 0)) return;

    if(strcmp(c[x], c[y]) == 0 && strcmp(c[x], c[z]) != 0) return;
    if(strcmp(c[x], c[y]) != 0 && (strcmp(c[x], c[z]) == 0 || strcmp(c[y], c[z]) == 0)) return;

    if(strcmp(b[x], b[y]) == 0 && strcmp(b[x], b[z]) != 0) return;
    if(strcmp(b[x], b[y]) != 0 && (strcmp(b[x], b[z]) == 0 || strcmp(b[y], b[z]) == 0)) return;

    v.push_back({x+1, y+1, z+1, 0});
}
int main()
{
    int answer = 0;
    int A,B,C,n;
    char in;
    for(int i=0; i<9; i++) {
        scanf("%s %s %s",&s[i], &c[i], &b[i]);
    }

    for(int i=0; i<9; i++) {
        for(int j=i; j<9; j++) {
            for(int k=j; k<9; k++) {
                if(i != j && j != k && i != k) {
                    check(i, j, k);
                }
            }
        }
    }
    int cnt = v.size();
    int G = 0;
    for(scanf("%d",&n);n--;) {
        scanf(" %c",&in);
        if(in == 'H') {
            scanf("%d %d %d",&A,&B,&C);
            if(isOk(A, B, C)) {
                answer += 1;
                cnt--;
            }
            else answer -= 1;
        }
        else {
            if(cnt == 0 && G == 0) {
                answer += 3;
                G = 1;
            }
            else answer -= 1;
        }
    }
    printf("%d",answer);

    return 0;
}
